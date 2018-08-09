package selext.ui.tests.negative

import com.codeborne.selenide.ex.ElementNotFound
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import selext.TestNGTestSuite
import selext.ui.configs.Config
import selext.extension.content
import selext.ui.pageObjects.nonExistent.NonExistentComboboxPage

class ModsErrorsTests : TestNGTestSuite(Config) {

    @BeforeMethod
    fun before() {
        open("https://demos.telerik.com/kendo-ui/combobox/index")
    }

    @Test(expectedExceptions = [ElementNotFound::class])
    fun comboboxWrongPositionLevelTest() {

        NonExistentComboboxPage().content()
                .comboboxWrongPositionLevel.setLast()
    }

    @Test(expectedExceptions = [ElementNotFound::class], expectedExceptionsMessageRegExp=".*By.id: wrongId.*")
    fun comboboxWrongButtonLocatorTest() {

        NonExistentComboboxPage().content()
                .comboboxWrongButtonLocator.setFirst()
    }

    @Test
    fun comboboxMissingClickableButtonTest() {

        NonExistentComboboxPage().content {
            nonClickableCombobox.click()
                    .popupShouldBeHidden()
            comboboxList.shouldBeHidden()
        }
    }
}