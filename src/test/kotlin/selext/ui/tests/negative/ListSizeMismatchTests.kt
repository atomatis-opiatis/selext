package selext.ui.tests.negative

import com.codeborne.selenide.ex.ListSizeMismatch
import selext.ui.configs.Config
import selext.TestNGTestSuite
import selext.extension.content
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import selext.ui.pageObjects.menu.MainMenuPage

class ListSizeMismatchTests : TestNGTestSuite(Config) {

    @BeforeMethod
    fun before() {
        open("https://demos.telerik.com/kendo-ui/menu/index")
    }

    @Test(expectedExceptions = [ListSizeMismatch::class])
    fun menuSizeMismatchTest() {
        MainMenuPage().content()
                .storeMenu.shouldHaveSize(99)
    }

    @Test(expectedExceptions = [ListSizeMismatch::class])
    fun menuGreaterSizeMismatchTest() {
        MainMenuPage().content()
                .storeMenu.shouldHaveSizeGreaterThan(99)
    }

    @Test(expectedExceptions = [ListSizeMismatch::class])
    fun menuLessSizeMismatchTest() {
        MainMenuPage().content()
                .storeMenu.shouldHaveSizeLessThan(2)
    }
}