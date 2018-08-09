package selext.element.selector

import selext.element.SelenideElementStorage
import selext.element.mod.interfaces.IMod
import selext.selenide.CustomBy
import org.openqa.selenium.By
import kotlin.reflect.KFunction2

class ModElementSelector<R : SelenideElementStorage, M : IMod>(private val elementCreation: KFunction2<By, M, R>,
                                                               private val modsCreation: () -> M) : ISelector<R> {

    override infix fun id(string: String): R = elementCreation(By.id(string), modsCreation())

    override infix fun name(string: String): R = elementCreation(By.name(string), modsCreation())

    override infix fun css(string: String): R = elementCreation(By.cssSelector(string), modsCreation())

    override infix fun xpath(string: String): R = elementCreation(CustomBy.xpath(string), modsCreation())

    class ModdableElementSelector<R : SelenideElementStorage, M : IMod>(private val elementCreation: KFunction2<By, M, R>,
                                                                        private val mods: M) : ISelector<R> {

        override infix fun id(string: String): R = elementCreation(By.id(string), mods)

        override infix fun name(string: String): R = elementCreation(By.name(string), mods)

        override infix fun css(string: String): R = elementCreation(By.cssSelector(string), mods)

        override infix fun xpath(string: String): R = elementCreation(CustomBy.xpath(string), mods)
    }

    fun mods(block: (M) -> Unit): ModdableElementSelector<R, M> {
        val mods = modsCreation()
        block(mods)
        return ModdableElementSelector<R, M>(elementCreation, mods)
    }
}