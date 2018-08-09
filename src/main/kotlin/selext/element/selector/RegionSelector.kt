package selext.element.selector

import selext.element.RegionCollection
import selext.element.pageobject.Region
import selext.selenide.CustomBy
import org.openqa.selenium.By

class RegionSelector<T : Region>(private val block: () -> T) : ISelector<RegionCollection<T>> {

    override infix fun id(string: String): RegionCollection<T> {
        return RegionCollection(block, By.id(string))
    }

    override infix fun name(string: String): RegionCollection<T> {
        return RegionCollection(block, By.name(string))
    }

    override infix fun css(string: String): RegionCollection<T> {
        return RegionCollection(block, By.cssSelector(string))
    }

    override infix fun xpath(string: String): RegionCollection<T> {
        return RegionCollection(block, CustomBy.xpath(string))
    }
}