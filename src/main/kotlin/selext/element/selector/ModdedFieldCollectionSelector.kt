package selext.element.selector

import org.openqa.selenium.By
import selext.element.ModdedFieldCollection
import selext.element.field.FieldObject
import selext.element.mod.interfaces.IMod
import selext.selenide.CustomBy
import kotlin.reflect.KFunction2

class ModdedFieldCollectionSelector<T : FieldObject, M : IMod>(private val fieldCreation: KFunction2<By, M, T>,
                                                               private val modsCreation: (() -> M))
    : ISelector<ModdedFieldCollection<T, M>> {

    override infix fun id(string: String): ModdedFieldCollection<T, M> {
        return ModdedFieldCollection(fieldCreation, modsCreation, By.id(string))
    }

    override infix fun name(string: String): ModdedFieldCollection<T, M> {
        return ModdedFieldCollection(fieldCreation, modsCreation, By.name(string))
    }

    override infix fun css(string: String): ModdedFieldCollection<T, M> {
        return ModdedFieldCollection(fieldCreation, modsCreation, By.cssSelector(string))
    }

    override infix fun xpath(string: String): ModdedFieldCollection<T, M> {
        return ModdedFieldCollection(fieldCreation, modsCreation, CustomBy.xpath(string))
    }
}