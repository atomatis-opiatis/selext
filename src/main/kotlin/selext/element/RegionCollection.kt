package selext.element

import org.openqa.selenium.By
import selext.element.pageobject.Region
import selext.element.pageobject.RegionComponent

class RegionCollection<R : Region>(private val block: () -> R, by: By) : ElementCollectionStorage<RegionComponent<R>>(by) {

    override val collection: List<RegionComponent<R>>
        get() = wrappedElement.map {
            RegionComponent(block(), wrappedBy).apply {
                setStoredElement(this, it)
                this.init()
            }
        }
}