package selext.ui.tests.positive
import selext.ui.configs.Config
import selext.TestNGTestSuite
import selext.extension.content
import selext.selenide.removeFocus
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import selext.ui.pageObjects.UIComponentsMainPage
import selext.ui.pageObjects.button.ButtonEventsPage
import selext.ui.pageObjects.button.MainButtonPage

/**
 *
 */
class ButtonTests : TestNGTestSuite(Config) {

    @BeforeMethod
    fun before() {
        open("https://demos.telerik.com/kendo-ui/")
        UIComponentsMainPage().content()
                .buttonMenu.click()
    }

    @Test
    fun buttonFocusTest() {
        val className = "k-state-focused"

        MainButtonPage().content {
            primaryButton
                    .shouldNotHaveClass(className)
                    .click()
                    .shouldHaveClass(className)
            removeFocus()
            primaryButton.shouldNotHaveClass(className)
        }
    }

    @Test
    fun disabledButtonTest() {
        MainButtonPage().content()
                .disabledButton.shouldBeDisabled()
    }

    @Test
    fun buttonClickEventTest() {
        MainButtonPage().content()
                .menu["Events"].click()

        ButtonEventsPage().content {
            consoleLog.shouldBeEmpty()
            textButton.click()
            consoleLog.shouldContainText("event :: click (textButton)")
        }
    }
}