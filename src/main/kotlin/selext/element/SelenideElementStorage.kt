package selext.element

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.impl.ElementFinder
import selext.extension.isHidden
import selext.extension.isVisible
import selext.selenide.CustomCondition
import org.openqa.selenium.By
import org.openqa.selenium.SearchContext

abstract class SelenideElementStorage(seleniumBy: By) : ElementStorage<SelenideElement>(seleniumBy) {

    final override fun initSelf(searchContext: SearchContext?, index: Int): SelenideElement {
        return ElementFinder.wrap(searchContext, wrappedBy, index)
    }

    protected fun selfShouldBeExist(): SelenideElement = wrappedElement.shouldBe(Condition.exist)

    protected fun selfShouldBeVisible(): SelenideElement = wrappedElement.shouldBe(CustomCondition.visible)

    val searchCriteria: String
        get() = wrappedElement.searchCriteria

    fun getAttribute(attributeName: String): String? {
        mustNotBeBlank(attributeName)
        return selfShouldBeExist().attr(attributeName)
    }

    fun isContainsClass(classAttribute: String): Boolean {
        mustNotBeBlank(classAttribute)
        return selfShouldBeExist().`is`(Condition.cssClass(classAttribute))
    }

    val isVisible
        get() = wrappedElement.isVisible

    val isHidden
        get() = wrappedElement.isHidden

    fun implShouldBeVisible() {
        wrappedElement.shouldBe(CustomCondition.visible)
    }

    fun implShouldBeHidden() {
        wrappedElement.shouldBe(CustomCondition.hidden)
    }

    fun implShouldNotBeVisible() {
        wrappedElement.shouldBe(CustomCondition.hidden)
    }

    fun implShouldHaveAttribute(name: String) {
        wrappedElement.shouldHave(Condition.attribute(name))
    }

    fun implShouldHaveAttribute(name: String, value: String) {
        wrappedElement.shouldHave(Condition.attribute(name, value))
    }

    fun implShouldHaveClass(className: String) {
        wrappedElement.shouldHave(Condition.cssClass(className))
    }

    fun implShouldNotHaveClass(className: String) {
        wrappedElement.shouldNotHave(Condition.cssClass(className))
    }

    fun implShouldExist() {
        wrappedElement.should(Condition.exist)
    }

    fun implHover() {
        selfShouldBeVisible().hover()
    }

    fun dragAndDropTo(element: SelenideElementStorage) {
        selfShouldBeVisible().dragAndDropTo(element.selfShouldBeExist())
    }

    fun pressEscape() {
        selfShouldBeVisible().pressEscape()
    }

    fun pressTab() {
        selfShouldBeVisible().pressTab()
    }

    fun pressEnter() {
        selfShouldBeVisible().pressEnter()
    }

    abstract fun shouldBeVisible(): SelenideElementStorage

    abstract fun shouldBeHidden(): SelenideElementStorage

    abstract fun shouldNotBeVisible(): SelenideElementStorage

    abstract fun shouldHaveAttribute(name: String): SelenideElementStorage

    abstract fun shouldHaveAttribute(name: String, value: String): SelenideElementStorage

    abstract fun shouldHaveClass(className: String): SelenideElementStorage

    abstract fun shouldNotHaveClass(className: String): SelenideElementStorage

    abstract fun shouldExist(): SelenideElementStorage

    abstract fun hover(): SelenideElementStorage
}