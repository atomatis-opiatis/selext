package selext.element.field

import selext.selenide.CustomCondition
import org.openqa.selenium.By
import selext.element.field.interfaces.IAlertCallerElement
import selext.element.field.interfaces.IClickableElement

class Checkbox(by: By) : FieldObject(by), IClickableElement, IAlertCallerElement {

    override fun click(): Checkbox {
        implClick()
        return this
    }

    override fun clickAndConfirmAlert(): Checkbox {
        implClickAndConfirmAlert()
        return this
    }

    override fun clickAndConfirmAlert(expectedDialogText: String): Checkbox {
        implClickAndConfirmAlert(expectedDialogText)
        return this
    }

    override fun clickAndDismissAlert(): Checkbox {
        implClickAndDismissAlert()
        return this
    }

    override fun clickAndDismissAlert(expectedDialogText: String): Checkbox {
        implClickAndDismissAlert(expectedDialogText)
        return this
    }

    override fun doubleClick(): Checkbox {
        implDoubleClick()
        return this
    }

    override fun contextClick(): Checkbox {
        implContextClick()
        return this
    }

    override fun clickLeftSide(): Checkbox {
        implClickLeftSide()
        return this
    }

    override fun clickRightSide(): Checkbox {
        implClickRightSide()
        return this
    }

    fun select(): Checkbox {
        if (!isSelected()) click()
        return this
    }

    fun deselect(): Checkbox {
        if (isSelected()) click()
        return this
    }

    fun isSelected(): Boolean = selfShouldBeExist().`is`(CustomCondition.checked)

    override fun hover(): Checkbox {
        implHover()
        return this
    }

    override fun shouldBeVisible(): Checkbox {
        implShouldBeVisible()
        return this
    }

    override fun shouldBeHidden(): Checkbox {
        implShouldBeHidden()
        return this
    }

    override fun shouldNotBeVisible(): Checkbox {
        implShouldNotBeVisible()
        return this
    }

    override fun shouldHaveAttribute(name: String): Checkbox {
        implShouldHaveAttribute(name)
        return this
    }

    override fun shouldHaveAttribute(name: String, value: String): Checkbox {
        implShouldHaveAttribute(name, value)
        return this
    }

    override fun shouldHaveClass(className: String): Checkbox {
        implShouldHaveClass(className)
        return this
    }

    override fun shouldNotHaveClass(className: String): Checkbox {
        implShouldNotHaveClass(className)
        return this
    }

    override fun shouldExist(): Checkbox {
        implShouldExist()
        return this
    }

    fun shouldBeSelected(): Checkbox {
        selfShouldBeExist().shouldBe(CustomCondition.checked)
        return this
    }

    fun shouldNotBeSelected(): Checkbox {
        selfShouldBeExist().shouldNotBe(CustomCondition.checked)
        return this
    }

    override fun shouldBeDisabled(): Checkbox {
        implShouldBeDisabled()
        return this
    }

    override fun shouldBeEnabled(): Checkbox {
        implShouldBeEnabled()
        return this
    }
}