package selext.extension

import selext.element.pageobject.Region
import selext.element.pageobject.RegionComponent
import selext.selenide.CustomBy
import org.openqa.selenium.By

infix fun <T : Region> T.id(string: String): RegionComponent<T> = RegionComponent(this, By.id(string))

infix fun <T : Region> T.name(string: String): RegionComponent<T> = RegionComponent(this, By.name(string))

infix fun <T : Region> T.css(string: String): RegionComponent<T> = RegionComponent(this, By.cssSelector(string))

infix fun <T : Region> T.xpath(string: String): RegionComponent<T> = RegionComponent(this, CustomBy.xpath(string))

fun <T : Region> T.content(block: T.() -> Unit) {
    init()
    block()
}

fun <T : Region> T.content(): T {
    init()
    return this
}

fun <T : RegionComponent<R>, R : Region> T.content(block: R.() -> Unit) {
    block(this.invoke())
}

fun <T : RegionComponent<R>, R : Region> T.content() = this.invoke()
