package selext.ui.pageObjects

import selext.element.Page
import java.util.regex.Pattern

/**
 *
 */
abstract class BasicMainPage(url: Regex, title: Regex) : Page(url, title) {
    constructor(url: String = "", title: String = "") : this(Regex(Pattern.quote(url)), Regex(Pattern.quote(title)))

    val menu = list(link) css "#example-nav li a"
}
