package selext.element.selector

import selext.element.SelenideElementStorage
import selext.selenide.CustomBy
import org.openqa.selenium.By
import kotlin.reflect.KFunction1

class ElementSelector<R : SelenideElementStorage>(private val elementCreation: KFunction1<By, R>) : ISelector<R> {

    override infix fun id(string: String): R = elementCreation(By.id(string))

    override infix fun name(string: String): R = elementCreation(By.name(string))

    override infix fun css(string: String): R = elementCreation(By.cssSelector(string))

    override infix fun xpath(string: String): R = elementCreation(CustomBy.xpath(string))
}