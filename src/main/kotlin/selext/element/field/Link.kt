package selext.element.field

import selext.element.field.interfaces.IClickableElement
import org.openqa.selenium.By
import selext.element.field.interfaces.IAlertCallerElement

class Link(by: By) : FieldObject(by), IClickableElement, IAlertCallerElement {

    override fun click(): Link {
        implClick()
        return this
    }

    override fun clickAndConfirmAlert(): Link {
        implClickAndConfirmAlert()
        return this
    }

    override fun clickAndConfirmAlert(expectedDialogText: String): Link {
        implClickAndConfirmAlert(expectedDialogText)
        return this
    }

    override fun clickAndDismissAlert(): Link {
        implClickAndDismissAlert()
        return this
    }

    override fun clickAndDismissAlert(expectedDialogText: String): Link {
        implClickAndDismissAlert(expectedDialogText)
        return this
    }

    override fun doubleClick(): Link {
        implDoubleClick()
        return this
    }

    override fun contextClick(): Link {
        implContextClick()
        return this
    }

    override fun clickLeftSide(): Link {
        implClickLeftSide()
        return this
    }

    override fun clickRightSide(): Link {
        implClickRightSide()
        return this
    }

    override fun hover(): Link {
        implHover()
        return this
    }

    override fun shouldBeVisible(): Link {
        implShouldBeVisible()
        return this
    }

    override fun shouldBeHidden(): Link {
        implShouldBeHidden()
        return this
    }

    override fun shouldNotBeVisible(): Link {
        implShouldNotBeVisible()
        return this
    }

    override fun shouldHaveAttribute(name: String): Link {
        implShouldHaveAttribute(name)
        return this
    }

    override fun shouldHaveAttribute(name: String, value: String): Link {
        implShouldHaveAttribute(name, value)
        return this
    }

    override fun shouldHaveClass(className: String): Link {
        implShouldHaveClass(className)
        return this
    }

    override fun shouldNotHaveClass(className: String): Link {
        implShouldNotHaveClass(className)
        return this
    }

    override fun shouldExist(): Link {
        implShouldExist()
        return this
    }

    override fun shouldBeDisabled(): Link {
        implShouldBeDisabled()
        return this
    }

    override fun shouldBeEnabled(): Link {
        implShouldBeEnabled()
        return this
    }

    fun download() = selfShouldBeExist().download()
}