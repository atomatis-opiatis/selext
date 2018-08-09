# selext


Selenium/Selenide Extensions. Proof of concept.


### Examples (Kotlin):

* PageObject:

```kotlin
class SomePage : Page() {
 
     val menu = list(link) css "#example-nav li a"
     val primaryButton = button id "primaryTextButton"
     val secondaryButton = button id "textButton"
     val disabledButton = button id "primaryDisabledButton"
     
     val someCombo = combobox.mods {
        it.arrowButton id "arrow"
     } id "fatality"
     
     val header = Header id "header"
     object Header : Region() {
         val someText = text xpath "div[div[@name='name']]"
     }
     
     fun doSomeStuff(): UnknownPage {
        someCombo.setLast()
        secondaryButton.click()
        return UnknownPage().content()
     }
 }
```

* Test case:

```kotlin
class SomeTests : BasicTest() {

    @Test
    fun buttonClickEventTest() {
        SomePage().content()
                .menu["Events"].click()

        SomeAnotherPage().content {
            consoleLog.shouldBeEmpty()
            textButton.click()
            consoleLog.shouldContainText("textButton")
                      .shouldHaveClass("changed")
        }
    }
    
    @Test
    fun headerTextTest() {
        SomePage().content()
                .header.content()
                     .someText.shouldHaveTextAnyOf("Peace", "War")
    }
}
```

### Links:

* selenium - https://github.com/SeleniumHQ/selenium
* selenide - https://github.com/codeborne/selenide
* kotlin - http://kotlinlang.org
