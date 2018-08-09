package selext.element.field

import org.openqa.selenium.By
import selext.element.field.interfaces.ISimpleTextElement

class Text(by: By) : FieldObject(by), ISimpleTextElement {

    override fun hover(): Text {
        implHover()
        return this
    }

    override fun shouldBeVisible(): Text {
        implShouldBeVisible()
        return this
    }

    override fun shouldBeHidden(): Text {
        implShouldBeHidden()
        return this
    }

    override fun shouldNotBeVisible(): Text {
        implShouldNotBeVisible()
        return this
    }

    override fun shouldHaveAttribute(name: String): Text {
        implShouldHaveAttribute(name)
        return this
    }

    override fun shouldHaveAttribute(name: String, value: String): Text {
        implShouldHaveAttribute(name, value)
        return this
    }

    override fun shouldHaveClass(className: String): Text {
        implShouldHaveClass(className)
        return this
    }

    override fun shouldNotHaveClass(className: String): Text {
        implShouldNotHaveClass(className)
        return this
    }

    override fun shouldExist(): Text {
        implShouldExist()
        return this
    }

    override fun shouldMatchText(regex: String): Text {
        implShouldMatchText(regex)
        return this
    }

    override fun shouldBeEmpty(): Text {
        implShouldBeEmpty()
        return this
    }

    override fun shouldHaveAnyText(): Text {
        implShouldHaveAnyValue()
        return this
    }

    override fun shouldContainText(text: String): Text {
        implShouldContainText(text)
        return this
    }

    override fun shouldHaveExactText(text: String): Text {
        implShouldHaveExactText(text)
        return this
    }

    override fun shouldHaveTextAnyOf(texts: List<String>): Text {
        shouldHaveTextAnyOf(texts)
        return this
    }

    override fun shouldHaveTextAnyOf(vararg texts: String): Text
            = shouldHaveTextAnyOf(texts.toList())
}