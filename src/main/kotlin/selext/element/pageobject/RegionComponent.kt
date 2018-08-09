package selext.element.pageobject

import com.codeborne.selenide.Selenide
import selext.Global
import selext.element.SelenideElementStorage
import org.openqa.selenium.By
import org.openqa.selenium.SearchContext
import java.util.concurrent.TimeUnit

class RegionComponent<out T : Region>(private val region: T, by: By) : SelenideElementStorage(by) {

    override fun init(searchContext: SearchContext?, index: Int) {
        super.init(searchContext, index)
        region.init(wrappedElement, index)
    }

    fun waitChanges(block: () -> Unit) = waitChanges(Global.testConfig.waitTimeout, block)

    fun waitChanges(timeout: Long, block: () -> Unit) {
        val self = selfShouldBeExist()
        val oldHtml = self.innerHtml()
        block()
        var newHtml: String
        Selenide.Wait().withTimeout(timeout, TimeUnit.MILLISECONDS).until {
            newHtml = self.innerHtml()
            newHtml != oldHtml
        }
    }

    operator fun invoke(block: T.() -> Unit) {
        //init()
        block(region)
    }

    operator fun invoke() = region

    override fun shouldBeVisible(): RegionComponent<T> {
        implShouldBeVisible()
        return this
    }

    override fun shouldBeHidden(): RegionComponent<T> {
        implShouldBeHidden()
        return this
    }

    override fun shouldNotBeVisible(): RegionComponent<T> {
        implShouldNotBeVisible()
        return this
    }

    override fun shouldHaveAttribute(name: String): RegionComponent<T> {
        implShouldHaveAttribute(name)
        return this
    }

    override fun shouldHaveAttribute(name: String, value: String): RegionComponent<T> {
        implShouldHaveAttribute(name, value)
        return this
    }

    override fun shouldHaveClass(className: String): RegionComponent<T> {
        implShouldHaveClass(className)
        return this
    }

    override fun shouldNotHaveClass(className: String): RegionComponent<T> {
        implShouldNotHaveClass(className)
        return this
    }

    override fun shouldExist(): RegionComponent<T> {
        implShouldExist()
        return this
    }

    override fun hover(): RegionComponent<T> {
        implHover()
        return this
    }
}