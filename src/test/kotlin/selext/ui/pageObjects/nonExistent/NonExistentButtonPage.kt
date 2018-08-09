package selext.ui.pageObjects.nonExistent

import selext.element.pageobject.Region
import selext.extension.id
import selext.ui.pageObjects.BasicMainPage

/**
 *
 */

class NonExistentButtonPage : BasicMainPage() { //PageComponent(id = "NonExistentButtonPageId") {

    val missingRegion = MissingRegion() id "MissingRegion" // must throw exception
    class MissingRegion : Region() {
        val primaryButton = button id "primaryTextButton"

        val exampleRegion = ExampleRegion() id "exampleWrap"
        class ExampleRegion : Region() {
            val primaryButton = button id "primaryTextButton"
        }
    }

    val exampleRegion = ExampleRegion() id "exampleWrap"
    class ExampleRegion : Region() {
        val nestedMissingRegion = NestedMissingRegion() id "NestedMissingRegion" // must throw exception
        class NestedMissingRegion : Region() {
            val primaryButton = button id "primaryTextButton"
        }
    }

    //init { init() }
}