package selext.element.field

import com.codeborne.selenide.Condition
import selext.element.mod.ComboboxMods
import selext.selenide.removeFocus
import org.openqa.selenium.By
import selext.element.field.interfaces.IClickableElement
import selext.element.field.interfaces.IEditableElement
import selext.element.field.interfaces.IPopupElement

class Combobox(by: By, mods: ComboboxMods) : FieldObjectPopup(by, mods), IPopupElement, IClickableElement, IEditableElement {
    constructor(by: By) : this(by, ComboboxMods())

    override var value: String
        get() = selfShouldBeExist().value
        set(value) {
            mustNotBeBlank(value)
            selfShouldBeExist().value = value
            getPopupOptions().filter(Condition.and("visible and contains text",
                    Condition.visible,
                    Condition.text(value))).first().click()
            popupShouldBeHidden()
        }

    override fun popupShouldBeVisible(): Combobox {
        implPopupShouldBeVisible()
        return this
    }

    override fun popupShouldBeHidden(): Combobox {
        implPopupShouldBeHidden()
        return this
    }

    override fun setFirst(): Combobox {
        set(0)
        return this
    }

    override fun setLast(): Combobox {
        set(-1)
        return this
    }

    override fun set(index: Int): Combobox {
        implSetByClick(index)
        return this
    }

    override fun add(value: String): Combobox {
        implAdd(value)
        return this
    }

    override fun append(value: String) = add(value)

    override fun focus(): Combobox {
        implFocus()
        return this
    }

    override fun clear(): Combobox {
        implClear()
        return this
    }

    override fun set(value: String): Combobox {
        implSetValue(value)
        return this
    }

    override fun click(): Combobox {
        implClick()
        return this
    }

    override fun doubleClick(): Combobox {
        implDoubleClick()
        return this
    }

    override fun contextClick(): Combobox {
        implContextClick()
        return this
    }

    override fun clickLeftSide(): Combobox {
        implClickLeftSide()
        return this
    }

    override fun clickRightSide(): Combobox {
        implClickRightSide()
        return this
    }

    fun filter(text: String): Combobox {
        mustNotBeBlank(text)
        selfShouldBeExist().value = text
        return this
    }

    fun filterAndUnfocus(text: String): Combobox {
        filter(text)
        removeFocus()
        return this
    }

    fun filterAndEnter(text: String): Combobox {
        filter(text)
        pressEnter()
        return this
    }

    fun getOptions(text: String): List<String> {
        mustNotBeBlank(text)
        selfShouldBeExist().append(text)
        return getPopupOptions().filter(Condition.visible).texts() ?: ArrayList()
    }

    override fun hover(): Combobox {
        implHover()
        return this
    }

    override fun shouldBeVisible(): Combobox {
        implShouldBeVisible()
        return this
    }

    override fun shouldBeHidden(): Combobox {
        implShouldBeHidden()
        return this
    }

    override fun shouldNotBeVisible(): Combobox {
        implShouldNotBeVisible()
        return this
    }

    override fun shouldHaveAttribute(name: String): Combobox {
        implShouldHaveAttribute(name)
        return this
    }

    override fun shouldHaveAttribute(name: String, value: String): Combobox {
        implShouldHaveAttribute(name, value)
        return this
    }

    override fun shouldHaveClass(className: String): Combobox {
        implShouldHaveClass(className)
        return this
    }

    override fun shouldNotHaveClass(className: String): Combobox {
        implShouldNotHaveClass(className)
        return this
    }

    override fun shouldExist(): Combobox {
        implShouldExist()
        return this
    }

    override fun shouldBeDisabled(): Combobox {
        implShouldBeDisabled()
        return this
    }

    override fun shouldBeEnabled(): Combobox {
        implShouldBeEnabled()
        return this
    }

    override fun shouldHaveAnyValue(): Combobox {
        implShouldHaveAnyValue()
        return this
    }

    override fun shouldBeEmpty(): Combobox {
        implShouldBeEmpty()
        return this
    }

    override fun shouldContainValue(value: String): Combobox  {
        implShouldContainValue(value)
        return this
    }

    override fun shouldHaveExactValue(value: String): Combobox {
        implShouldHaveExactValue(value)
        return this
    }

    override fun shouldHaveValueAnyOf(values: List<String>): Combobox  {
        implShouldHaveValueAnyOf(values)
        return this
    }

    override fun shouldHaveValueAnyOf(vararg values: String): Combobox = shouldHaveValueAnyOf(values.toList())

    override fun shouldBeNonEditable(): Combobox {
        implShouldBeNonEditable()
        return this
    }

    override fun shouldBeEditable(): Combobox {
        implShouldBeEditable()
        return this
    }
}