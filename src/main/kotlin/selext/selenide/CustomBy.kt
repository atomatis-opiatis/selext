package selext.selenide

import org.openqa.selenium.By

object CustomBy {

    fun xpath(xpathExpression: String): By {
        val xpath = when {
            xpathExpression.startsWith("/") -> ".$xpathExpression"
            xpathExpression.startsWith("(/") -> "(." + (xpathExpression.drop(1))
            else -> xpathExpression
        }
        return By.xpath(xpath)
    }
}