package selext.ui.tests.negative

import com.codeborne.selenide.ex.ElementShould
import selext.ui.configs.Config
import selext.TestNGTestSuite
import selext.extension.content
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import selext.ui.pageObjects.menu.MainMenuPage

class NotFoundAttributeTests : TestNGTestSuite(Config) {

    @BeforeMethod
    fun before() {
        open("https://demos.telerik.com/kendo-ui/menu/index")
    }

    @Test(expectedExceptions = [ElementShould::class], expectedExceptionsMessageRegExp = ".*should have css class.*")
    fun notFoundClassTest() {
        MainMenuPage().content()
                .storeMenu["Products"].shouldHaveClass("non-existent-class")
    }

    @Test(expectedExceptions = [ElementShould::class], expectedExceptionsMessageRegExp = ".*should have exact text.*")
    fun notFoundTextTest() {
        MainMenuPage().content()
                .storeMenu[0].shouldHaveExactText("Bla-bla-bla")
    }
}