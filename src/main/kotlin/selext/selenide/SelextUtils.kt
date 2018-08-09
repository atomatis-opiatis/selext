package selext.selenide

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.actions
import com.codeborne.selenide.WebDriverRunner
import com.codeborne.selenide.ex.JavaScriptErrorsFound
import selext.Global
import org.openqa.selenium.By
import org.openqa.selenium.logging.LogType
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait

/**
 * @param param название параметра.
 * @return значение параметра get-метода.
 * @throws StringIndexOutOfBoundsException если такого параметра нет.
 */
fun getUrlParamValue(param: String): String {
    val currentUrl = WebDriverRunner.url()
    val indexOfEqual = currentUrl.indexOf("$param=")
    if (indexOfEqual < 0) throw StringIndexOutOfBoundsException()
    val value = currentUrl.substring(indexOfEqual + param.length + 1)
    val index = value.indexOf('&')

    return value.substring(0, if (index < 0) value.lastIndex else index)
}

/**
 * Ожидает до возвращения [ExpectedCondition.apply] значения true.
 * Время ожидания берется из [selext.TestConfig.waitTimeout].
 */
fun waitUntil(expectedCondition: ExpectedCondition<Boolean>) {
    val wait = WebDriverWait(WebDriverRunner.getWebDriver(), Global.testConfig.waitTimeout)
    wait.until(expectedCondition)
}

/**
 * Убирает текущий фокус элемента.
 * Реализовано через клик по элементу body в отрицательных координатах.
 */
fun removeFocus() {
    val body = `$`(By.tagName("body"))
    body.sendKeys("")
    actions().moveToElement(body, -1000, -1000).click().perform()
    actions().moveToElement(body).perform()
}

/**
 * Проверяет наличие js ошибок. Если есть - кидает [JavaScriptErrorsFound].
 */
fun assertNoJavascriptErrors() {
    Selenide.assertNoJavascriptErrors()

    val errors = Selenide.getWebDriverLogs(LogType.BROWSER).filter {
        val lowered = it.toLowerCase()
        lowered.contains("severe") || lowered.contains("error")
    }

    if (errors.isNotEmpty())
        throw JavaScriptErrorsFound(errors)
}