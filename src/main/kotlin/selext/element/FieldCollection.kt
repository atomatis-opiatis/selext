package selext.element

import com.codeborne.selenide.CollectionCondition
import com.codeborne.selenide.Condition
import com.codeborne.selenide.ex.ElementNotFound
import com.codeborne.selenide.ex.ListSizeMismatch
import selext.element.field.FieldObject
import org.openqa.selenium.By
import kotlin.reflect.KFunction1

class FieldCollection<Element : FieldObject>(private val block: KFunction1<By, Element>, by: By)
    : ElementCollectionStorage<Element>(by), IFieldCollection<Element> {

    override val collection: List<Element>
        get() = wrappedElement.map {
            block(wrappedBy).apply {
                setStoredElement(this, it)
                this.init()
            }
        }

    override fun shouldAnyItemHaveText(exactText: String) {
        mustNotBeBlank(exactText)
        try {
            wrappedElement.filterBy(Condition.exactText(exactText)).shouldHave(CollectionCondition.sizeGreaterThan(0))
        } catch (e: ListSizeMismatch) {
            throw ElementNotFound("self text '$exactText'", Condition.exist)
        }
    }

    override operator fun get(exactText: String): Element {
        return collection.find { it.text == exactText } ?:
                throw ElementNotFound("self text '$exactText'", Condition.exist)
    }
}