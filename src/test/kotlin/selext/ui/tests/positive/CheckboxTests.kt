package selext.ui.tests.positive
import selext.ui.configs.Config
import selext.TestNGTestSuite
import selext.extension.content
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import selext.ui.pageObjects.UIComponentsMainPage
import selext.ui.pageObjects.grid.CheckboxGridPage
import selext.ui.pageObjects.grid.MainGridPage

/**
 *
 */
class CheckboxTests : TestNGTestSuite(Config) {

    @BeforeMethod
    fun before() {
        open("https://demos.telerik.com/kendo-ui/")

        UIComponentsMainPage().content {
            gridMenu.click()
        }
    }

    @Test
    fun headerCheckboxStateTest() {
        MainGridPage().content {
            menu["Checkbox selection"].click()
        }

        CheckboxGridPage().content {
            header.content()
                    .checkBox.select()
            rows.first().content()
                    .rowCheckBox.shouldBeSelected()
            rows.last().content()
                    .rowCheckBox.shouldBeSelected()
        }
    }

    @Test
    fun checkboxStateTest() {
        MainGridPage().content {
            menu["Checkbox selection"].click()
        }

        CheckboxGridPage().content {
            rows.first().content()
                    .rowCheckBox.select()
            rows.last().content()
                    .rowCheckBox.shouldNotBeSelected()
        }
    }
}