package selext.ui.tests.positive

import selext.ui.configs.Config
import selext.TestNGTestSuite
import selext.extension.content
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import selext.ui.pageObjects.menu.MainMenuPage

/**
 *
 */
class HoverTests : TestNGTestSuite(Config) {

    @BeforeMethod
    fun before() {
        open("https://demos.telerik.com/kendo-ui/menu/index")
    }

    @Test
    fun menuSimpleHoverTest() {
        MainMenuPage().content().storeMenu["Products"]
                .shouldNotHaveClass("k-state-hover")
                .hover()
                .shouldHaveClass("k-state-hover")
    }

    @Test
    fun menuLevelsHoverTest() {
        MainMenuPage().content {
            storeFirstMenu[0].hover().content()
                    .storeSecondMenu[1].hover().content {
                menuText.shouldHaveExactText("Decor")
                        .shouldBeVisible()
                storeThirdMenu["Carpets"]
                        .shouldBeVisible()
            }
        }
    }
}