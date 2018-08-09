package selext.element

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import selext.element.pageobject.Region
import org.openqa.selenium.TimeoutException
import java.util.regex.Pattern

abstract class Page(private val url: Regex, private val title: Regex) : Region() {
    constructor(url: String = "", title: String = "") : this(Regex(Pattern.quote(url)), Regex(Pattern.quote(title)))

    fun getUrl() = url.toString()

    fun getTitle() = title.toString()

    fun urlShouldMatch() {
        var urlvar = ""
        try {
            Selenide.Wait().until {
                urlvar = WebDriverRunner.url()
                urlvar.matches(url)
            }
        } catch (e: TimeoutException) {
            throw AssertionError("actual: '$urlvar', expected: '$url'")
        }
    }

    fun titleShouldMatch() {
        var titlevar = ""
        try {
            Selenide.Wait().until {
                titlevar = Selenide.title()
                titlevar.matches(title)
            }
        } catch (e: TimeoutException) {
            throw AssertionError("actual: '$titlevar', expected: '$title'")
        }
    }

    fun refresh() = Selenide.refresh()
}