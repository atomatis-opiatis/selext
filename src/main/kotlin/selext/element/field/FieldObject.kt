package selext.element.field

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.*
import selext.TestUtils.logger
import selext.element.SelenideElementStorage
import selext.extension.isEditable
import selext.extension.isNonEditable
import selext.selenide.CustomCondition

abstract class FieldObject(by: By) : SelenideElementStorage(by) {

    open val isDisabled: Boolean
        get() = selfShouldBeExist().isNonEditable

    open val isEnabled: Boolean
        get() = selfShouldBeExist().isEditable

    open val isNonEditable: Boolean
        get() = selfShouldBeExist().isNonEditable

    open val isEditable: Boolean
        get() = selfShouldBeExist().isEditable

    protected fun implShouldBeDisabled() {
        selfShouldBeExist().shouldBe(CustomCondition.nonEditable)
    }

    protected fun implShouldBeEnabled() {
        selfShouldBeExist().shouldBe(CustomCondition.editable)
    }

    protected fun implShouldBeNonEditable() {
        selfShouldBeExist().shouldBe(CustomCondition.nonEditable)
    }

    protected fun implShouldBeEditable() {
        selfShouldBeExist().shouldBe(CustomCondition.editable)
    }

    /**
     * Clickable
     */

    protected open val clickableVisibleElement: SelenideElement
        get() = selfShouldBeVisible()

    private fun actionClick() {
        Selenide.actions().click(clickableVisibleElement).perform()
        Thread.sleep(250)
    }

    protected fun implClick() {
        clickableVisibleElement.click()
    }

    protected fun implClickAndConfirmAlert(): String? {
        actionClick()
        return Selenide.confirm()
    }

    protected fun implClickAndConfirmAlert(expectedDialogText: String): String? {
        actionClick()
        return Selenide.confirm(expectedDialogText)
    }

    protected fun implClickAndDismissAlert(): String? {
        actionClick()
        return Selenide.dismiss()
    }

    protected fun implClickAndDismissAlert(expectedDialogText: String): String? {
        actionClick()
        return Selenide.dismiss(expectedDialogText)
    }

    protected fun implDoubleClick() {
        clickableVisibleElement.doubleClick()
    }

    protected fun implContextClick() {
        clickableVisibleElement.contextClick()
    }

    protected fun implClickLeftSide() {
        val element = clickableVisibleElement
        val height = element.size.height
        Selenide.actions().moveToElement(element, 1, height / 2).click().perform()
    }

    protected fun implClickRightSide() {
        val element = clickableVisibleElement
        val height = element.size.height
        val width = element.size.width
        Selenide.actions().moveToElement(element, width - 1, height / 2).click().perform()
    }

    /**
     * Editable
     */

    protected fun implAdd(value: String) {
        mustNotBeEmpty(value)
        selfShouldBeExist().append(value)
    }

    protected fun implAppend(value: String) = implAdd(value)

    protected fun implFocus() {
        selfShouldBeVisible().append("")
    }

    protected fun implClear() {
        selfShouldBeExist().value = ""
    }

    protected fun implGetValue(): String {
        return selfShouldBeExist().value
    }

    protected fun implSetValue(value: String) {
        selfShouldBeExist().value = value
    }

    protected fun implShouldHaveAnyValue() {
        selfShouldBeExist().shouldHave(CustomCondition.valueNotEmpty)
    }

    protected fun implShouldBeEmpty() {
        selfShouldBeExist().shouldBe(Condition.empty)
    }

    protected fun implShouldContainValue(value: String)  {
        mustNotBeBlank(value)
        selfShouldBeExist().shouldHave(Condition.value(value))
    }

    protected fun implShouldHaveExactValue(value: String) {
        mustNotBeBlank(value)
        selfShouldBeExist().shouldHave(Condition.exactValue(value))
    }

    protected fun implShouldHaveValueAnyOf(values: List<String>)  {
        mustNotBeEmpty(values)
        selfShouldBeExist().shouldHave(object : Condition("value s in") {
            override fun apply(element: WebElement?): Boolean {
                return values.contains(element!!.getAttribute("value") ?: "")
            }
        })
    }

    protected fun implShouldHaveValueAnyOf(vararg values: String) = implShouldHaveValueAnyOf(values.toList())

    protected fun implPressBackspace() {
        selfShouldBeVisible().apply {
            append("")
            sendKeys(Keys.BACK_SPACE)
        }
    }

    protected fun implPress(vararg keysToSend: CharSequence) {
        selfShouldBeVisible().sendKeys(*keysToSend)
    }

    /**
     * Text
     */

    val text: String
        get() = selfShouldBeExist().text

    val innerText: String
        get() {
            logger().warn("Used innerText for '${this::class.java.simpleName}'")
            return selfShouldBeExist().innerText()
        }

    protected fun implShouldMatchText(regex: String) {
        selfShouldBeExist().should(Condition.matchText(regex))
    }

    protected fun implShouldHaveAnyText() {
        selfShouldBeExist().should(Condition.matchText(".+"))
    }

    protected fun implShouldContainText(text: String) {
        selfShouldBeExist().shouldHave(Condition.text(text))
    }

    protected fun implShouldHaveExactText(text: String) {
        selfShouldBeExist().shouldHave(Condition.exactText(text))
    }

    protected fun implShouldHaveTextAnyOf(texts: List<String>) {
        selfShouldBeExist().shouldHave(object : Condition("text is in") {
            override fun apply(element: WebElement?): Boolean {
                return texts.contains(element!!.text)
            }
        })
    }

    protected fun implShouldHaveTextAnyOf(vararg texts: String) = implShouldHaveTextAnyOf(texts.toList())
}

