package selext.ui.pageObjects.button

import selext.ui.pageObjects.BasicMainPage

class MainButtonPage : BasicMainPage() {

    val primaryButton = button id "primaryTextButton"
    val secondaryButton = button id "textButton"
    val disabledButton = button id "primaryDisabledButton"
}