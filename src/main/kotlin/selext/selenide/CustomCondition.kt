package selext.selenide

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import selext.Global
import selext.extension.isEditable
import selext.extension.isHidden
import selext.extension.isNonEditable
import selext.extension.isVisible
import org.openqa.selenium.WebDriverException
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
import java.util.regex.Pattern

object CustomCondition {

    @JvmField val visible: Condition = object : Condition("visible") {
        override fun apply(element: WebElement?) = Selenide.`$`(element!!).isVisible
    }

    @JvmField val hidden: Condition = object : Condition("hidden", true) {
        override fun apply(element: WebElement?) = Selenide.`$`(element!!).isHidden
    }

    @JvmField val nonEditable: Condition = object : Condition("non editable") {
        override fun apply(element: WebElement?): Boolean = Selenide.`$`(element!!).isNonEditable
    }

    @JvmField val editable: Condition = object : Condition("editable") {
        override fun apply(element: WebElement?): Boolean = Selenide.`$`(element!!).isEditable
    }

    @JvmField val checked: Condition = object : Condition("checked") {
        override fun apply(element: WebElement?): Boolean {
            return Selenide.`$`(element!!).let {
                val innerCheckbox = it.`$x`(".//input[@type='checkbox']")
                if (innerCheckbox.exists())
                    return innerCheckbox.`is`(Condition.checked)
                it.`is`(Condition.or("checked",
                        Condition.checked,
                        Condition.cssClass("checked"),
                        Condition.attribute("aria-checked", "true")))
            }
        }
    }

    @JvmField val valueNotEmpty: Condition = object : Condition("not empty") {
        override fun apply(element: WebElement?): Boolean
                = Pattern.compile(".+").matcher(element!!.getAttribute("value") ?: "").matches()
    }

    @JvmField val jsLoaded: ExpectedCondition<Boolean> = ExpectedCondition {
        val jQueryScript = "return window.jQuery == undefined || jQuery.active === 0"
        val angularScript = "return window.angular == undefined" +
                " || (angular.element(document.body).injector() !== undefined)" +
                " && (angular.element(document.body).injector().get('\$http').pendingRequests.length === 0)"

        Selenide.executeJavaScript<String>("return document.readyState") == "complete" &&
                (if (Global.testConfig.jQueryMode) Selenide.executeJavaScript<Boolean>(jQueryScript) else true) &&
                (if (Global.testConfig.angularMode) Selenide.executeJavaScript<Boolean>(angularScript) else true)
    }

    fun exists(element: WebElement): ExpectedCondition<Boolean> {
        return ExpectedCondition {
            try {
                element.isDisplayed
                return@ExpectedCondition true
            } catch (e: WebDriverException) {
                return@ExpectedCondition false
            }
        }
    }
}