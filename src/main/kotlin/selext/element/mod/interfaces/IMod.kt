package selext.element.mod.interfaces

import org.openqa.selenium.By

interface IMod {
    class Locator(defaultBy: By?) {
        private var locator: By? = defaultBy

        fun getLocator(): By = locator ?: throw NullPointerException("Expression 'locator' must not be null")

        val isNull: Boolean get() = locator == null

        infix fun id(string: String) { locator = By.id(string) }

        infix fun name(string: String) { locator = By.name(string) }

        infix fun css(string: String) { locator = By.cssSelector(string) }

        infix fun xpath(string: String) { locator = By.xpath(string) }
    }
}