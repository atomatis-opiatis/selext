package selext.ui.pageObjects.nonExistent

import selext.ui.pageObjects.BasicMainPage
import selext.ui.pageObjects.grid.CheckboxGridPage

/**
 *
 */
class NonExistentGridPage : BasicMainPage() {//PageComponent(id = "NonExistentGridPageId") {
    val rows = list(CheckboxGridPage::Row) css "tbody tr"

    //init { init() }
}