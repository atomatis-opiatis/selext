package selext.element.field

import com.codeborne.selenide.*
import selext.element.mod.DropdownMods
import org.openqa.selenium.By
import selext.element.field.interfaces.IClickableElement
import selext.element.field.interfaces.IPopupElement

class Dropdown(by: By, mods: DropdownMods) : FieldObjectPopup(by, mods), IPopupElement, IClickableElement {
    constructor(by: By) : this(by, DropdownMods())

    override fun click(): Dropdown {
        implClick()
        return this
    }

    override fun doubleClick(): Dropdown {
        implDoubleClick()
        return this
    }

    override fun contextClick(): Dropdown {
        implContextClick()
        return this
    }

    override fun clickLeftSide(): Dropdown {
        implClickLeftSide()
        return this
    }

    override fun clickRightSide(): Dropdown {
        implClickRightSide()
        return this
    }

    override fun popupShouldBeVisible(): Dropdown {
        implPopupShouldBeVisible()
        return this
    }

    override fun popupShouldBeHidden(): Dropdown {
        implPopupShouldBeHidden()
        return this
    }

    override var value: String
        get() {
            return selfShouldBeExist().value
        }
        set(value) {
            mustNotBeBlank(value)
            clickableVisibleElement.click()
            getPopupOptions().filter(Condition.and("visible and exact text",
                    Condition.visible,
                    Condition.exactText(value))).first().click()
            popupShouldBeHidden()
        }

    override fun set(index: Int): Dropdown {
        implSetByClick(index)
        return this
    }

    override fun setFirst(): Dropdown {
        set(0)
        return this
    }

    override fun setLast(): Dropdown {
        set(-1)
        return this
    }

    override fun hover(): Dropdown {
        implHover()
        return this
    }

    override fun shouldBeVisible(): Dropdown {
        implShouldBeVisible()
        return this
    }

    override fun shouldBeHidden(): Dropdown {
        implShouldBeHidden()
        return this
    }

    override fun shouldNotBeVisible(): Dropdown {
        implShouldNotBeVisible()
        return this
    }

    override fun shouldHaveAttribute(name: String): Dropdown {
        implShouldHaveAttribute(name)
        return this
    }

    override fun shouldHaveAttribute(name: String, value: String): Dropdown {
        implShouldHaveAttribute(name, value)
        return this
    }

    override fun shouldHaveClass(className: String): Dropdown {
        implShouldHaveClass(className)
        return this
    }

    override fun shouldNotHaveClass(className: String): Dropdown {
        implShouldNotHaveClass(className)
        return this
    }

    override fun shouldExist(): Dropdown {
        implShouldExist()
        return this
    }

    override fun shouldBeDisabled(): Dropdown {
        implShouldBeDisabled()
        return this
    }

    override fun shouldBeEnabled(): Dropdown {
        implShouldBeEnabled()
        return this
    }
}