package selext.element

import selext.element.pageobject.Region
import selext.element.pageobject.RegionComponent
import org.openqa.selenium.SearchContext
import selext.TestUtils.logger

abstract class BasicElement {

    protected fun initElements(searchContext: SearchContext?, index: Int = 0) {
        var targetClass: Class<*> = this::class.java
        while (targetClass !in listOf(
                        Page::class.java,
                        Region::class.java,
                        RegionComponent::class.java,
                        RegionCollection::class.java,
                        ElementCollectionStorage::class.java,
                        SelenideElementStorage::class.java,
                        ElementStorage::class.java,
                        BasicElement::class.java,
                        Any::class.java))
        {
            logger().info("-- found fields in ${targetClass.simpleName}: " + targetClass.declaredFields.map { it.name })
            targetClass.declaredFields
                    .filter {
                        BasicElement::class.java.isAssignableFrom(it.type)
                        && !listOf("wrapperStoredElement", "INSTANCE").contains(it.name)
                    }
                    .forEach {
                        logger().info("--- field: " + it.name + ", parent: " + (if (searchContext != null) targetClass.simpleName
                                + " (" + searchContext.toString().substring(0, 50) + ")" else null))
                        it.isAccessible = true
                        (it.get(this@BasicElement) as BasicElement).init(searchContext, index)
                    }
            targetClass = targetClass.superclass
        }
    }

    abstract fun init(searchContext: SearchContext? = null, index: Int = 0)

    protected fun mustNotBeNegative(value: Int) {
        if (value < 0) throw IllegalArgumentException("The '$value' value must not be be negative")
    }

    protected fun mustNotBeNegative(value: Double) {
        if (value < 0) throw IllegalArgumentException("The '$value' value must not be negative")
    }

    protected fun mustNotBeNegative(value: Short) {
        if (value < 0) throw IllegalArgumentException("The '$value' value must not be negative")
    }

    protected fun mustNotBeNegative(value: Float) {
        if (value < 0) throw IllegalArgumentException("The '$value' value must not be negative")
    }

    protected fun mustNotBeEmpty(value: String) {
        if (value.isEmpty()) throw IllegalArgumentException("The '$value' value must not be empty")
    }

    protected fun mustNotBeBlank(value: String) {
        if (value.isBlank()) throw IllegalArgumentException("The '$value' value must not be blank")
    }

    protected fun mustNotBeEmpty(list: List<*>) {
        if (list.isEmpty()) throw IllegalArgumentException("The '$list' value must not be empty")
    }
}