package selext.element

import com.codeborne.selenide.CollectionCondition
import com.codeborne.selenide.Condition
import com.codeborne.selenide.ex.ElementNotFound
import com.codeborne.selenide.ex.ListSizeMismatch
import org.openqa.selenium.By
import selext.element.field.FieldObject
import selext.element.mod.interfaces.IMod
import kotlin.reflect.KFunction2

class ModdedFieldCollection<Element : FieldObject, Mods : IMod>(private val block: KFunction2<By, Mods, Element>,
                                                                private val modsCreation: (() -> Mods),
                                                                by: By)
    : ElementCollectionStorage<Element>(by), IFieldCollection<Element> {

    override val collection: List<Element>
        get() = wrappedElement.map {
            block(wrappedBy, modsCreation()).apply {
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