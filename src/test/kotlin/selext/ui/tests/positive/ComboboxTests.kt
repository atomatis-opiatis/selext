package selext.ui.tests.positive

import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import selext.TestNGTestSuite
import selext.ui.configs.Config
import selext.extension.content
import selext.ui.pageObjects.combobox.MainComboboxPage

class ComboboxTests : TestNGTestSuite(Config) {

    private val alertMessage = "Thank you! Your Choice is:\n\nFabric ID: %s and Size: %s"

    @BeforeMethod
    fun before() {
        open("https://demos.telerik.com/kendo-ui/combobox/index")
    }

    @Test
    fun comboboxSetLastTest() {
        val size = "2X-Large"

        MainComboboxPage().content {
            shirtSizeCombobox.setLast()
                    .shouldHaveExactValue(size)
            customizeButton.clickAndConfirmAlert(alertMessage.format(4, size))
        }
    }

    @Test
    fun comboboxFilterAndUnfocusTest() {
        val size = "X-Large"

        MainComboboxPage().content {
            shirtSizeCombobox.filterAndUnfocus(size)
                    .shouldHaveExactValue(size)
            customizeButton.clickAndConfirmAlert(alertMessage.format(4, size))
        }
    }

    @Test
    fun comboboxFilterAndEnterTest() {
        val size = "Medium"

        MainComboboxPage().content {
            shirtSizeCombobox.filterAndEnter(size)
                    .shouldHaveExactValue(size)
            customizeButton.clickAndConfirmAlert(alertMessage.format(4, size))
        }
    }
}