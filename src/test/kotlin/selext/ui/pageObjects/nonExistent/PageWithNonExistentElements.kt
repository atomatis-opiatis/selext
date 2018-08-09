package selext.ui.pageObjects.nonExistent

import selext.ui.pageObjects.BasicMainPage
import selext.ui.pageObjects.grid.CheckboxGridPage

/**
 *
 */
class PageWithNonExistentElements : BasicMainPage() {//PageComponent() {
    val nonExistentButton = button id "nonExistentButtonId"
    val nonExistentRows = list(CheckboxGridPage::Row) css "tbody trrrr"

    //init { init() }
}