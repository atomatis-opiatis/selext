package selext.element.field.interfaces

interface IPopupElement {

    var value: String

    fun popupShouldBeVisible(): IPopupElement

    fun popupShouldBeHidden(): IPopupElement

    fun setFirst(): IPopupElement

    fun setLast(): IPopupElement

    fun set(index: Int): IPopupElement

    fun getOptions(): List<String>
}