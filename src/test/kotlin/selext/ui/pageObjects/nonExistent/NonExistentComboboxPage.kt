package selext.ui.pageObjects.nonExistent

import selext.enums.PositionLevel
import selext.ui.pageObjects.BasicMainPage

class NonExistentComboboxPage : BasicMainPage() {

    val comboboxWrongPositionLevel = combobox.mods {
        it.positionLevel = PositionLevel.PARENT // wrong
        it.arrowButton css ".k-combobox [aria-controls='size_listbox']"
    } css ".k-combobox input[aria-labelledby='size_label']"

    val comboboxWrongButtonLocator = combobox.mods {
        it.positionLevel = PositionLevel.GRANDPARENT
        it.arrowButton id "wrongId"
    } css ".k-combobox input[aria-labelledby='size_label']"

    val nonClickableCombobox = combobox.mods {
        it.positionLevel = PositionLevel.GRANDPARENT
    } css ".k-combobox input[aria-labelledby='size_label']"

    val comboboxList = div id "size_listbox"
}