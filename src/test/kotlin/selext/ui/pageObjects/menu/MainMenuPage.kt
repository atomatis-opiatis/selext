package selext.ui.pageObjects.menu

import selext.element.pageobject.Region
import selext.ui.pageObjects.BasicMainPage

class MainMenuPage : BasicMainPage() {

    val storeMenu = list css "#megaStore>#menu>li"

    val storeFirstMenu = list(MainMenuPage::MenuFirstLevel) css "#megaStore>#menu>li"
    class MenuFirstLevel : Region() {

        val menuText = text css "span"
        val storeSecondMenu = list(MenuFirstLevel::MenuSecondLevel) css "div>ul.k-menu-group>li"
        class MenuSecondLevel : Region() {

            val menuText = text css "span"
            val storeThirdMenu = list css "div>ul.k-menu-group>li"
        }
    }
}