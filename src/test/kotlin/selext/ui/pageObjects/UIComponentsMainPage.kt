package selext.ui.pageObjects

import selext.element.Page

class UIComponentsMainPage : Page() {

    val buttonMenu = link css "a[href='/kendo-ui/button/index']"
    val gridMenu = link css "a[href='/kendo-ui/grid/index']"
}