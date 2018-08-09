package selext.ui.pageObjects.combobox

import selext.enums.PositionLevel
import selext.ui.pageObjects.BasicMainPage

class MainComboboxPage : BasicMainPage() {

    val shirtSizeCombobox = combobox.mods {
        it.positionLevel = PositionLevel.GRANDPARENT
        it.arrowButton css ".k-combobox [aria-controls='size_listbox']"
    } css ".k-combobox input[aria-labelledby='size_label']"

    val customizeButton = button id "get"
}