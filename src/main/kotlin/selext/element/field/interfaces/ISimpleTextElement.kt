package selext.element.field.interfaces

interface ISimpleTextElement {

    val text: String

    fun shouldMatchText(regex: String): ISimpleTextElement

    fun shouldBeEmpty(): ISimpleTextElement

    fun shouldHaveAnyText(): ISimpleTextElement

    fun shouldContainText(text: String): ISimpleTextElement

    fun shouldHaveExactText(text: String): ISimpleTextElement

    fun shouldHaveTextAnyOf(texts: List<String>): ISimpleTextElement

    fun shouldHaveTextAnyOf(vararg texts: String): ISimpleTextElement
}