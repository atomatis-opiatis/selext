package selext

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import selext.Global
import selext.TestConfig
import selext.selenide.WaitEventListener
import io.github.bonigarcia.wdm.ChromeDriverManager
import org.openqa.selenium.WebDriverException

/**
 *
 */
abstract class AbstractBasicTest(@JvmField protected val config: TestConfig) {

    init {
        Global.testConfig = config
        Configuration.browser = config.browser
        Configuration.pageLoadStrategy = config.pageLoadStrategy
        Configuration.savePageSource = config.savePageSource
        Configuration.holdBrowserOpen = config.holdBrowserOpen
        Configuration.screenshots = config.screenshots
        Configuration.startMaximized = config.startMaximized
        Configuration.timeout = config.waitTimeout
        Configuration.collectionsTimeout = config.collectionsWaitTimeout
        Configuration.remote = config.remote
        Configuration.headless = config.headless

        if (Configuration.remote != null)
            System.setProperty("capabilities.enableVNC", true.toString())
        else
            ChromeDriverManager.getInstance().setup()
        //System.setProperty("webdriver.chrome.driver", TestUtils.driverPath)

        Global.stateInit("WaitEventListener") {
            WebDriverRunner.addListener(WaitEventListener())
        }
    }

    protected fun beforeConfiguration() {
        if (Configuration.startMaximized)
            WebDriverRunner.getWebDriver().manage().window().maximize()

        if (Configuration.remote != null)
            WebDriverRunner.getWebDriver().manage().window().size = config.remoteDimension
    }

    protected fun clearBrowser() {
        if (config.isCleanAfterUsed)
            Global.clear()

        if (Global.testConfig.clearCacheInsteadOfCloseBrowser) {
            try {
                Selenide.clearBrowserLocalStorage()
                Selenide.clearBrowserCookies()
                Selenide.refresh()
                if (WebDriverRunner.getWebDriver().manage().cookies.size > 0)
                    throw WebDriverException("Cookies still exists =(")
            } catch (e: WebDriverException) {
                Selenide.close()
            }
        } else {
            Selenide.close()
        }
    }

    protected fun open(url: String) = Selenide.open(url)
}