package selext.ui.pageObjects.grid

import selext.element.Page
import selext.element.pageobject.Region
import selext.extension.css

/**
 *
 */
class CheckboxGridPage : Page() {

    val header = Header css "table[role=grid]"
    object Header : Region() {
        val checkBox = checkbox xpath ".//th[input[@type='checkbox']]"
    }

    val rows = list(CheckboxGridPage::Row) css "tbody tr"
    class Row : Region() {
        val rowCheckBox = checkbox xpath ".//td[input[@type='checkbox']]"
    }
}