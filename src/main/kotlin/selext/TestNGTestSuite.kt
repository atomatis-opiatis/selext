package selext

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.testng.ScreenShooter
import selext.selenide.WaitEventListener
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Listeners

/**
 * Базовый класс для всех тестовых классов.
 * Задает значения [Configuration] из [config], добавляет обработчик событий [WaitEventListener].
 *
 * @param config конфигурация тестов которая будет использоваться во время запуска.
 *
 * Порядок вызова методов с аннотациями:
 *
 *  BeforeSuite
 *   BeforeTest
 *    BeforeClass
 *     BeforeMethod
 *      Test
 *     AfterMethod
 *    AfterClass
 *   AfterTest
 *  AfterSuite
 */

@Listeners(ScreenShooter::class)
abstract class TestNGTestSuite(config: TestConfig) : AbstractBasicTest(config) {

    @BeforeSuite(alwaysRun = true)
    fun beforeClassBrowserConfiguration() {
        beforeConfiguration()
    }

    @BeforeMethod(alwaysRun = true)
    fun beforeMethodBrowserConfiguration() {
        beforeConfiguration()
    }

    @AfterTest(alwaysRun = true)
    open fun afterMethodClearBrowser() {
        clearBrowser()
    }
}