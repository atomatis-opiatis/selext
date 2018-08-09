package selext.element.field.interfaces

interface IEditableElement {

    var value: String

    fun set(value: String): IEditableElement

    fun add(value: String): IEditableElement

    fun append(value: String): IEditableElement

    fun clear(): IEditableElement

    fun focus(): IEditableElement

    fun shouldHaveAnyValue(): IEditableElement

    fun shouldBeEmpty(): IEditableElement

    fun shouldContainValue(value: String): IEditableElement

    fun shouldHaveExactValue(value: String): IEditableElement

    fun shouldHaveValueAnyOf(values: List<String>): IEditableElement

    fun shouldHaveValueAnyOf(vararg values: String): IEditableElement

    fun shouldBeDisabled(): IEditableElement

    fun shouldBeEnabled(): IEditableElement

    fun shouldBeNonEditable(): IEditableElement

    fun shouldBeEditable(): IEditableElement
}