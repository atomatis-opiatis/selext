package selext

import org.openqa.selenium.By
import org.openqa.selenium.Dimension
import selext.enums.Position
import selext.enums.PositionLevel
import java.util.*

/**
 * Базовый класс для конфигураций тестовых проектов.
 */
abstract class TestConfig {

    /**
     * Selenide Configuration settings
     */

    @JvmField var browser = System.getProperty("BROWSER")?: "chrome"

    @JvmField var pageLoadStrategy = "normal"

    @JvmField var savePageSource = true

    @JvmField var holdBrowserOpen = false

    @JvmField var screenshots = true

    @JvmField var startMaximized = true

    @JvmField var headless = System.getProperty("HEADLESS")?.toBoolean() ?: false

    // время ожидания элементов для методов should...() и wait...()
    @JvmField var waitTimeout: Long = System.getProperty("WAIT_ELEMENT_TIMEOUT")?.toLong() ?: 10000

    @JvmField var collectionsWaitTimeout: Long = System.getProperty("WAIT_ELEMENT_TIMEOUT")?.toLong() ?: 10000

    @JvmField var remote: String?  = System.getProperty("REMOTE")

    @JvmField var remoteDimension = Dimension(1920, 1080)

    // задержка после выполнения действий навигации, клика, изменения значения; используется для замедления прохождения тестов
    @JvmField var postActionDelay: Long = 0

    @JvmField var clearCacheInsteadOfCloseBrowser: Boolean = true


    /**
     * Modes
     */

    @JvmField var jQueryMode: Boolean = true

    @JvmField var angularMode: Boolean = false

    // включает проверку на отсутствие js-ошибок после действий навигации, клика, изменения значений
    @JvmField var extraJSAssertMode = System.getProperty("EXTRA_JS_ASSERT_MODE")?.toBoolean() ?: false

    // включает проверку видимости полей для pageobject'ов
    @JvmField var extraFieldVisibilityAssertMode
            = System.getProperty("EXTRA_FIELD_VISIBILITY_ASSERT_MODE")?.toBoolean() ?: false


    /**
     * Misc
     */

    @JvmField var isDataPreparationUsed = System.getProperty("IS_DATA_PREPARATION_USED")?.toBoolean() ?: true

    @JvmField var isCleanAfterUsed = System.getProperty("IS_CLEAN_AFTER_USED")?.toBoolean() ?: true

    @JvmField var defaultLocale: Locale = Locale("ru")

    /**
     * Field defaults
     */

    val defaultDropdownUlLocator: By = By.xpath("//ul")

    val defaultDropdownOptionLocator: By = By.xpath("li[@role='option']")

    val defaultDropdownClickableLocator: By? = null

    val defaultDropdownPositionType = Position.ABSOLUTE

    val defaultDropdownPositionLevel = PositionLevel.PARENT

    val defaultComboboxUlLocator: By = By.xpath("//ul")

    val defaultComboboxOptionLocator: By = By.xpath("li[@role='option']")

    val defaultComboboxClickableLocator: By? = null

    val defaultComboboxPositionType = Position.ABSOLUTE

    val defaultComboboxPositionLevel = PositionLevel.PARENT

}