package selext.ui.tests.negative

import com.codeborne.selenide.ex.ElementNotFound
import selext.ui.configs.Config
import selext.TestNGTestSuite
import selext.extension.content
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import selext.ui.pageObjects.UIComponentsMainPage
import selext.ui.pageObjects.button.MainButtonPage
import selext.ui.pageObjects.nonExistent.NonExistentButtonPage
import selext.ui.pageObjects.nonExistent.PageWithNonExistentElements

/**
 *
 */
class NotFoundOnButtonPageTests : TestNGTestSuite(Config) {

    @BeforeMethod
    fun before() {
        open("https://demos.telerik.com/kendo-ui/")
        UIComponentsMainPage().content()
                .buttonMenu.click()
    }

    @Test(expectedExceptions = [ElementNotFound::class], expectedExceptionsMessageRegExp=".*By.id: MissingRegion.*")
    fun regionNotFound() {
        NonExistentButtonPage().content {
            missingRegion.content()
                    .primaryButton.click()
        }
    }

    @Test(expectedExceptions = [ElementNotFound::class], expectedExceptionsMessageRegExp=".*By.id: NestedMissingRegion.*")
    fun nestedRegionNotFound() {
        NonExistentButtonPage().content {
            exampleRegion.content()
                    .nestedMissingRegion.content()
                        .primaryButton.click()
        }
    }

    @Test(expectedExceptions = [ElementNotFound::class], expectedExceptionsMessageRegExp=".*By.id: MissingRegion.*")
    fun regionWithNestedNotFound() {
        NonExistentButtonPage().content {
            missingRegion.content()
                    .exampleRegion.content()
                        .primaryButton.click()
        }
    }

    @Test(expectedExceptions = [ElementNotFound::class])
    fun elementNotFound() {
        PageWithNonExistentElements().content()
                .nonExistentButton.click()
    }

    @Test(expectedExceptions = [ElementNotFound::class])
    fun listItemNotFoundByText() {
        MainButtonPage().content()
                .menu["listItemNotFoundText"].click()
    }

    @Test(expectedExceptions = [ElementNotFound::class])
    fun listItemNotFoundByCondition() {
        MainButtonPage().content()
                .menu[{ it.isDisabled }].click()
    }
}