package selext.ui.pageObjects.dropdown

import selext.enums.PositionLevel
import selext.ui.pageObjects.BasicMainPage

class MainDropdownPage : BasicMainPage() {

    val colorDropdown = dropdown.mods {
        it.positionLevel = PositionLevel.GRANDPARENT
    } css "[aria-labelledby='color_label'] .k-input"

    val capDiv = div id "cap"
}