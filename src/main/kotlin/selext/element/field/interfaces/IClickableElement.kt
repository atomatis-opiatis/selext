package selext.element.field.interfaces

interface IClickableElement {

    fun click(): IClickableElement

    fun doubleClick(): IClickableElement

    fun contextClick(): IClickableElement

    fun clickLeftSide(): IClickableElement

    fun clickRightSide(): IClickableElement

    fun shouldBeDisabled(): IClickableElement

    fun shouldBeEnabled(): IClickableElement
}