package selext.selenide

import selext.Global
import org.openqa.selenium.By
import org.openqa.selenium.OutputType
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.events.WebDriverEventListener

class WaitEventListener : WebDriverEventListener {

    override fun beforeNavigateRefresh(driver: WebDriver?) {
    }

    override fun beforeScript(script: String?, driver: WebDriver?) {
    }

    override fun beforeClickOn(element: WebElement?, driver: WebDriver?) {
    }

    override fun beforeNavigateTo(url: String?, driver: WebDriver?) {
    }

    override fun beforeChangeValueOf(element: WebElement?, driver: WebDriver?, keysToSend: Array<out CharSequence>?) {
    }

    override fun beforeNavigateForward(driver: WebDriver?) {
    }

    override fun beforeAlertDismiss(driver: WebDriver?) {
    }

    override fun beforeNavigateBack(driver: WebDriver?) {
    }

    override fun beforeFindBy(by: By?, element: WebElement?, driver: WebDriver?) {
    }

    override fun beforeAlertAccept(driver: WebDriver?) {
    }

    override fun beforeGetText(element: WebElement?, driver: WebDriver?) {
    }

    override fun <X : Any?> beforeGetScreenshotAs(target: OutputType<X>?) {
    }

    override fun beforeSwitchToWindow(windowName: String?, driver: WebDriver?) {
    }

    override fun afterAlertDismiss(driver: WebDriver?) {
        Thread.sleep(Global.testConfig.postActionDelay)
        waitUntil(CustomCondition.jsLoaded)
    }

    override fun afterAlertAccept(driver: WebDriver?) {
        Thread.sleep(Global.testConfig.postActionDelay)
        waitUntil(CustomCondition.jsLoaded)
    }

    override fun afterScript(script: String?, driver: WebDriver?) {
    }

    override fun afterFindBy(by: By?, element: WebElement?, driver: WebDriver?) {
    }

    override fun afterNavigateBack(driver: WebDriver?) {
        Thread.sleep(Global.testConfig.postActionDelay)
        waitUntil(CustomCondition.jsLoaded)

        if (Global.testConfig.extraJSAssertMode) {
            assertNoJavascriptErrors()
        }
    }

    override fun afterNavigateRefresh(driver: WebDriver?) {
        Thread.sleep(Global.testConfig.postActionDelay)
        waitUntil(CustomCondition.jsLoaded)

        if (Global.testConfig.extraJSAssertMode) {
            assertNoJavascriptErrors()
        }
    }

    override fun afterClickOn(element: WebElement?, driver: WebDriver?) {
        Thread.sleep(Global.testConfig.postActionDelay)
        waitUntil(CustomCondition.jsLoaded)

        if (Global.testConfig.extraJSAssertMode) {
            assertNoJavascriptErrors()
        }
    }

    override fun afterNavigateTo(url: String?, driver: WebDriver?) {
        Thread.sleep(Global.testConfig.postActionDelay)
        waitUntil(CustomCondition.jsLoaded)

        if (Global.testConfig.extraJSAssertMode) {
            assertNoJavascriptErrors()
        }
    }

    override fun afterChangeValueOf(element: WebElement?, driver: WebDriver?, keysToSend: Array<out CharSequence>?) {
        Thread.sleep(Global.testConfig.postActionDelay)

        if (Global.testConfig.extraJSAssertMode) {
            assertNoJavascriptErrors()
        }
    }

    override fun afterNavigateForward(driver: WebDriver?) {
        Thread.sleep(Global.testConfig.postActionDelay)
        waitUntil(CustomCondition.jsLoaded)

        if (Global.testConfig.extraJSAssertMode) {
            assertNoJavascriptErrors()
        }
    }

    override fun afterGetText(element: WebElement?, driver: WebDriver?, text: String?) {
    }

    override fun afterSwitchToWindow(windowName: String?, driver: WebDriver?) {
    }

    override fun <X : Any?> afterGetScreenshotAs(target: OutputType<X>?, screenshot: X) {
    }

    override fun onException(throwable: Throwable?, driver: WebDriver?) {
    }
}