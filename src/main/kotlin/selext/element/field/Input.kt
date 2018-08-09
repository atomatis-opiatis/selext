package selext.element.field

import selext.element.field.interfaces.IClickableElement
import org.openqa.selenium.By
import selext.element.field.interfaces.IEditableElement

class Input(by: By) : FieldObject(by), IClickableElement, IEditableElement {

    override fun click(): Input {
        implClick()
        return this
    }

    override fun doubleClick(): Input {
        implDoubleClick()
        return this
    }

    override fun contextClick(): Input {
        implContextClick()
        return this
    }

    override fun clickLeftSide(): Input {
        implClickLeftSide()
        return this
    }

    override fun clickRightSide(): Input {
        implClickRightSide()
        return this
    }

    override var value: String
        get() = implGetValue()
        set(value) = implSetValue(value)

    override fun add(value: String): Input {
        implAdd(value)
        return this
    }

    override fun append(value: String) = add(value)

    override fun focus(): Input {
        implFocus()
        return this
    }

    override fun clear(): Input {
        implClear()
        return this
    }

    override fun set(value: String): Input {
        implSetValue(value)
        return this
    }

    override fun hover(): Input {
        implHover()
        return this
    }

    override fun shouldBeVisible(): Input {
        implShouldBeVisible()
        return this
    }

    override fun shouldBeHidden(): Input {
        implShouldBeHidden()
        return this
    }

    override fun shouldNotBeVisible(): Input {
        implShouldNotBeVisible()
        return this
    }

    override fun shouldHaveAttribute(name: String): Input {
        implShouldHaveAttribute(name)
        return this
    }

    override fun shouldHaveAttribute(name: String, value: String): Input {
        implShouldHaveAttribute(name, value)
        return this
    }

    override fun shouldHaveClass(className: String): Input {
        implShouldHaveClass(className)
        return this
    }

    override fun shouldNotHaveClass(className: String): Input {
        implShouldNotHaveClass(className)
        return this
    }

    override fun shouldExist(): Input {
        implShouldExist()
        return this
    }

    override fun shouldHaveAnyValue(): Input {
        implShouldHaveAnyValue()
        return this
    }

    override fun shouldBeEmpty(): Input {
        implShouldBeEmpty()
        return this
    }

    override fun shouldContainValue(value: String): Input  {
        implShouldContainValue(value)
        return this
    }

    override fun shouldHaveExactValue(value: String): Input {
        implShouldHaveExactValue(value)
        return this
    }

    override fun shouldHaveValueAnyOf(values: List<String>): Input  {
        implShouldHaveValueAnyOf(values)
        return this
    }

    override fun shouldHaveValueAnyOf(vararg values: String): Input = shouldHaveValueAnyOf(values.toList())

    override fun shouldBeDisabled(): Input {
        implShouldBeDisabled()
        return this
    }

    override fun shouldBeEnabled(): Input {
        implShouldBeEnabled()
        return this
    }

    override fun shouldBeNonEditable(): Input {
        implShouldBeNonEditable()
        return this
    }

    override fun shouldBeEditable(): Input {
        implShouldBeEditable()
        return this
    }

    fun pressBackspace(): Input {
        implPressBackspace()
        return this
    }

    fun press(vararg keysToSend: CharSequence): Input {
        implPress(*keysToSend)
        return this
    }
}