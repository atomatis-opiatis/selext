package selext.element.field

import selext.element.field.interfaces.IClickableElement
import org.openqa.selenium.By
import selext.element.field.interfaces.IAlertCallerElement

class Button(by: By) : FieldObject(by), IClickableElement, IAlertCallerElement {

    override fun click(): Button {
        implClick()
        return this
    }

    override fun clickAndConfirmAlert(): Button {
        implClickAndConfirmAlert()
        return this
    }

    override fun clickAndConfirmAlert(expectedDialogText: String): Button {
        implClickAndConfirmAlert(expectedDialogText)
        return this
    }

    override fun clickAndDismissAlert(): Button {
        implClickAndDismissAlert()
        return this
    }

    override fun clickAndDismissAlert(expectedDialogText: String): Button {
        implClickAndDismissAlert(expectedDialogText)
        return this
    }

    override fun doubleClick(): Button {
        implDoubleClick()
        return this
    }

    override fun contextClick(): Button {
        implContextClick()
        return this
    }

    override fun clickLeftSide(): Button {
        implClickLeftSide()
        return this
    }

    override fun clickRightSide(): Button {
        implClickRightSide()
        return this
    }

    override fun hover(): Button {
        implHover()
        return this
    }

    override fun shouldBeVisible(): Button {
        implShouldBeVisible()
        return this
    }

    override fun shouldBeHidden(): Button {
        implShouldBeHidden()
        return this
    }

    override fun shouldNotBeVisible(): Button {
        implShouldNotBeVisible()
        return this
    }

    override fun shouldHaveAttribute(name: String): Button {
        implShouldHaveAttribute(name)
        return this
    }

    override fun shouldHaveAttribute(name: String, value: String): Button {
        implShouldHaveAttribute(name, value)
        return this
    }

    override fun shouldHaveClass(className: String): Button {
        implShouldHaveClass(className)
        return this
    }

    override fun shouldNotHaveClass(className: String): Button {
        implShouldNotHaveClass(className)
        return this
    }

    override fun shouldExist(): Button {
        implShouldExist()
        return this
    }

    override fun shouldBeDisabled(): Button {
        implShouldBeDisabled()
        return this
    }

    override fun shouldBeEnabled(): Button {
        implShouldBeEnabled()
        return this
    }
}