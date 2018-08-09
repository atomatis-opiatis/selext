package selext.element.selector

import selext.element.FieldCollection
import selext.element.field.FieldObject
import selext.selenide.CustomBy
import org.openqa.selenium.By
import kotlin.reflect.KFunction1

class FieldCollectionSelector<T : FieldObject>(private val fieldCreation: KFunction1<By, T>) : ISelector<FieldCollection<T>> {

    override infix fun id(string: String): FieldCollection<T> {
        return FieldCollection(fieldCreation, By.id(string))
    }

    override infix fun name(string: String): FieldCollection<T> {
        return FieldCollection(fieldCreation, By.name(string))
    }

    override infix fun css(string: String): FieldCollection<T> {
        return FieldCollection(fieldCreation, By.cssSelector(string))
    }

    override infix fun xpath(string: String): FieldCollection<T> {
        return FieldCollection(fieldCreation, CustomBy.xpath(string))
    }
}