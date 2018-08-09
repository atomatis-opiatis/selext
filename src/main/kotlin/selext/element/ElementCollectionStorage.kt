package selext.element

import com.codeborne.selenide.CollectionCondition
import com.codeborne.selenide.Condition
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.ex.ElementNotFound
import com.codeborne.selenide.ex.ListSizeMismatch
import com.codeborne.selenide.impl.BySelectorCollection
import org.openqa.selenium.By
import org.openqa.selenium.SearchContext
import org.openqa.selenium.TimeoutException

abstract class ElementCollectionStorage<Element : SelenideElementStorage>(by: By)
    : ElementStorage<ElementsCollection>(by), Collection<Element> {

    protected abstract val collection: List<Element>

    final override fun initSelf(searchContext: SearchContext?, index: Int): ElementsCollection {
        return ElementsCollection(BySelectorCollection(searchContext, wrappedBy))
    }

    protected fun <T> setStoredElement(obj: ElementStorage<*>, value: T) {
        ElementStorage::class.java.getDeclaredField("wrapperStoredElement").let {
            it.isAccessible = true
            it.set(obj, value)
        }
    }

    override val size: Int
        get() = wrappedElement.size
    // get() = wrappedElement.filter { true }.size // avoid using ElementsCollection.size

    override fun contains(element: Element): Boolean = collection.contains(element)

    override fun containsAll(elements: Collection<Element>): Boolean = collection.containsAll(elements)

    override fun isEmpty(): Boolean = wrappedElement.isEmpty()

    override fun iterator(): Iterator<Element> = collection.iterator()

    operator fun get(index: Int): Element {
        try {
            shouldHaveSizeGreaterThan(index)
        } catch (e: ListSizeMismatch) {
            throw ElementNotFound("self index '$index'", Condition.exist)
        }
        return collection[index]
    }

    operator fun get(block: (Element) -> Boolean): Element {
        wrappedElement.shouldHave(CollectionCondition.sizeGreaterThan(0))
        try {
            var result: Element? = null
            Selenide.Wait().until {
                result = collection.find { block(it) }
                result != null
            }
            return result!!
        } catch (e: TimeoutException) {
            throw ElementNotFound("self '$block'", Condition.exist)
        }
    }

    fun first(): Element = get(0)

    inline fun first(block: Element.() -> Unit): Element {
        return get(0).apply {
            block(this)
        }
    }

    fun last(): Element = get(size - 1)

    fun isExist(block: (Element) -> Boolean): Boolean = collection.find { block(it) } != null

    fun shouldHave(vararg condition: CollectionCondition) {
        wrappedElement.shouldHave(*condition)
    }

    fun shouldBe(vararg condition: CollectionCondition) = this.shouldHave(*condition)

    fun shouldHaveSize(size: Int) {
        mustNotBeNegative(size)
        wrappedElement.shouldHaveSize(size)
    }

    fun shouldHaveSizeGreaterThanZero() {
        wrappedElement.shouldHave(CollectionCondition.sizeGreaterThan(0))
    }

    fun shouldHaveSizeGreaterThan(size: Int) {
        mustNotBeNegative(size)
        wrappedElement.shouldHave(CollectionCondition.sizeGreaterThan(size))
    }

    fun shouldHaveSizeLessThan(size: Int) {
        mustNotBeNegative(size)
        wrappedElement.shouldHave(CollectionCondition.sizeLessThan(size))
    }

    fun shouldNewAppear(count: Int = 1, block: () -> Unit) {
        val oldSize = size
        block()
        if (count <= 0)
            wrappedElement.shouldHave(CollectionCondition.sizeGreaterThan(oldSize))
        else
            wrappedElement.shouldHave(CollectionCondition.size(oldSize + count))
    }

    fun shouldDisappear(count: Int = 1, block: () -> Unit) {
        val oldSize = size
        block()
        if (count <= 0)
            wrappedElement.shouldHave(CollectionCondition.sizeLessThan(oldSize))
        else
            wrappedElement.shouldHave(CollectionCondition.size(oldSize - count))
    }

    open fun shouldBeVisible() {
        wrappedElement.apply {
            shouldHave(CollectionCondition.sizeGreaterThan(0))
            forEach { it.shouldBe(Condition.visible) }
        }
    }

    open fun shouldBeHidden() {
        wrappedElement.forEach { it.shouldBe(Condition.hidden) }
    }

    fun should(vararg condition: CollectionCondition) = shouldHave(*condition)

    val isVisible: Boolean
        get() = wrappedElement.all { it.isDisplayed }

    val isHidden: Boolean
        get() = wrappedElement.all { !it.isDisplayed }

    fun hoverItem(index: Int) {
        shouldHaveSizeGreaterThan(index)
        collection[index].hover()
    }

    fun dragAndDropItemTo(index: Int, element: SelenideElementStorage) {
        shouldHaveSizeGreaterThan(index)
        collection[index].dragAndDropTo(element)
    }
}