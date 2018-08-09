package selext.element.field.interfaces

interface IAlertCallerElement {

    fun clickAndConfirmAlert(): IClickableElement

    fun clickAndConfirmAlert(expectedDialogText: String): IClickableElement

    fun clickAndDismissAlert(): IClickableElement

    fun clickAndDismissAlert(expectedDialogText: String): IClickableElement
}