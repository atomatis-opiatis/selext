package selext.ui.tests.positive

import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import selext.TestNGTestSuite
import selext.ui.configs.Config
import selext.extension.content
import selext.ui.pageObjects.dropdown.MainDropdownPage

class DropdownTests : TestNGTestSuite(Config) {

    @BeforeMethod
    fun before() {
        open("https://demos.telerik.com/kendo-ui/dropdownlist/index")
    }

    @Test
    fun dropdownSetFirstTest() {
        dropdownSetLastTest()
        MainDropdownPage().content {
            colorDropdown.setFirst()
            capDiv.shouldHaveClass("black-cap")
        }
    }

    @Test
    fun dropdownSetLastTest() {
        MainDropdownPage().content {
            colorDropdown.setLast()
            capDiv.shouldHaveClass("grey-cap")
        }
    }

    @Test
    fun dropdownSetByIndexTest() {
        MainDropdownPage().content {
            colorDropdown.set(1)
            capDiv.shouldHaveClass("orange-cap")
        }
    }
}