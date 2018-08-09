package selext.ui.pageObjects.button

import selext.element.Page

/**
 *
 */
class ButtonEventsPage : Page() {

    val textButton = button id "textButton"
    val consoleLog = text css ".box div.console"
}