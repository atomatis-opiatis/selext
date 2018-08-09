package selext.extension

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.ex.ElementNotFound
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.StaleElementReferenceException

val SelenideElement.isVisible: Boolean
    get() {
        if (!this.isDisplayed) return false
        return try {
            Selenide.actions().moveToElement(this).perform()
            val size = this.size
            val location = this.location
            val elX = location.getX()
            val elY = location.getY()
            val elWidth = size.getWidth()
            val elHeight = size.getHeight()

            elX + elWidth > 1 && elY + elHeight > 1 && elWidth > 0 && elHeight > 0
        } catch (e: ElementNotFound) {
            false
        } catch (e: NoSuchElementException) {
            false
        } catch (e: StaleElementReferenceException) {
            false
        }
    }

val SelenideElement.isHidden: Boolean
    get() = !isVisible

val SelenideElement.isDisabled: Boolean
    get() = !isEnabled
                || has(Condition.cssClass("disabled"))
                || has(Condition.attribute("aria-disabled", "true"))
                || has(Condition.attribute("aria-readonly", "true"))
                || has(Condition.attribute("readonly"))

val SelenideElement.isNonEditable: Boolean
    get() = isDisabled

val SelenideElement.isEditable: Boolean
    get() = !isDisabled

/*val SelenideElement.valWithoutNBS: String
    get() = `val`()?.replace('\u00a0', ' ') ?: ""*/
