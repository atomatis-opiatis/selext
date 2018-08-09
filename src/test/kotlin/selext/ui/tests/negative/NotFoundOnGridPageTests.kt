package selext.ui.tests.negative

import com.codeborne.selenide.ex.ElementNotFound
import selext.ui.configs.Config
import selext.TestNGTestSuite
import selext.extension.content
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import selext.ui.pageObjects.UIComponentsMainPage
import selext.ui.pageObjects.nonExistent.NonExistentGridPage
import selext.ui.pageObjects.nonExistent.PageWithNonExistentElements

/**
 *
 */
class NotFoundOnGridPageTests : TestNGTestSuite(Config) {

    @BeforeMethod
    fun before() {
        open("https://demos.telerik.com/kendo-ui/")
        UIComponentsMainPage().content()
                .gridMenu.click()
    }

    @Test(expectedExceptions = [ElementNotFound::class])
    fun componentNotFound() {
        NonExistentGridPage().content {
            rows.first().content()
                    .rowCheckBox.select()
        }
    }

    @Test(expectedExceptions = [ElementNotFound::class])
    fun elementNotFound() {
        PageWithNonExistentElements().content {
            nonExistentRows.first().content()
                    .rowCheckBox.select()
        }
    }
}