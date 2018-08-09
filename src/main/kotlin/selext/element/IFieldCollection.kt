package selext.element

import selext.element.field.FieldObject

interface IFieldCollection<out Element : FieldObject> {

    fun shouldAnyItemHaveText(exactText: String)

    operator fun get(exactText: String): Element
}