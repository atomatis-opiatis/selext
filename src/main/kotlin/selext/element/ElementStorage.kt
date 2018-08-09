package selext.element

import org.openqa.selenium.By
import org.openqa.selenium.SearchContext

abstract class ElementStorage<out T>(protected val wrappedBy: By) : BasicElement() {

    private var wrapperStoredElement: T? = null

    protected val wrappedElement: T
        get() = wrapperStoredElement ?: throw RuntimeException("PageObject must be initialized")

    protected abstract fun initSelf(searchContext: SearchContext?, index: Int = 0): T

    override fun init(searchContext: SearchContext?, index: Int) {
        if (wrapperStoredElement == null)
            wrapperStoredElement = initSelf(searchContext, index)
    }
}