package selext.element.field

import org.openqa.selenium.By
import selext.element.field.interfaces.IClickableElement
import selext.element.field.interfaces.IEditableElement
import java.io.File

class FileInput(by: By) : FieldObject(by), IClickableElement, IEditableElement {

    override fun click(): FileInput {
        implClick()
        return this
    }

    override fun doubleClick(): FileInput {
        implDoubleClick()
        return this
    }

    override fun contextClick(): FileInput {
        implContextClick()
        return this
    }

    override fun clickLeftSide(): FileInput {
        implClickLeftSide()
        return this
    }

    override fun clickRightSide(): FileInput {
        implClickRightSide()
        return this
    }

    override var value: String
        get() = implGetValue()
        set(value) = implSetValue(value)

    override fun add(value: String): FileInput {
        implAdd(value)
        return this
    }

    override fun append(value: String) = add(value)

    override fun focus(): FileInput {
        implFocus()
        return this
    }

    override fun clear(): FileInput {
        implClear()
        return this
    }

    override infix fun set(value: String): FileInput {
        implSetValue(value)
        return this
    }

    override fun hover(): FileInput {
        implHover()
        return this
    }

    override fun shouldBeVisible(): FileInput {
        implShouldBeVisible()
        return this
    }

    override fun shouldBeHidden(): FileInput {
        implShouldBeHidden()
        return this
    }

    override fun shouldNotBeVisible(): FileInput {
        implShouldNotBeVisible()
        return this
    }

    override fun shouldHaveAttribute(name: String): FileInput {
        implShouldHaveAttribute(name)
        return this
    }

    override fun shouldHaveAttribute(name: String, value: String): FileInput {
        implShouldHaveAttribute(name, value)
        return this
    }

    override fun shouldHaveClass(className: String): FileInput {
        implShouldHaveClass(className)
        return this
    }

    override fun shouldNotHaveClass(className: String): FileInput {
        implShouldNotHaveClass(className)
        return this
    }

    override fun shouldExist(): FileInput {
        implShouldExist()
        return this
    }

    override fun shouldHaveAnyValue(): FileInput {
        implShouldHaveAnyValue()
        return this
    }

    override fun shouldBeEmpty(): FileInput {
        implShouldBeEmpty()
        return this
    }

    override fun shouldContainValue(value: String): FileInput  {
        implShouldContainValue(value)
        return this
    }

    override fun shouldHaveExactValue(value: String): FileInput {
        implShouldHaveExactValue(value)
        return this
    }

    override fun shouldHaveValueAnyOf(values: List<String>): FileInput  {
        implShouldHaveValueAnyOf(values)
        return this
    }

    override fun shouldHaveValueAnyOf(vararg values: String): FileInput = shouldHaveValueAnyOf(values.toList())

    override fun shouldBeDisabled(): FileInput {
        implShouldBeDisabled()
        return this
    }

    override fun shouldBeEnabled(): FileInput {
        implShouldBeEnabled()
        return this
    }

    override fun shouldBeNonEditable(): FileInput {
        implShouldBeNonEditable()
        return this
    }

    override fun shouldBeEditable(): FileInput {
        implShouldBeEditable()
        return this
    }

    fun upload(file: File): FileInput {
        selfShouldBeExist().uploadFile(file)
        return this
    }
}