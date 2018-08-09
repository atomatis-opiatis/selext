package selext.element.field

import com.codeborne.selenide.*
import com.codeborne.selenide.ex.ElementNotFound
import org.openqa.selenium.By
import org.openqa.selenium.InvalidElementStateException
import org.openqa.selenium.TimeoutException
import selext.element.mod.interfaces.IPopupElementMod
import selext.selenide.CustomCondition

abstract class FieldObjectPopup(by: By, mods: IPopupElementMod) : FieldObject(by) {

    private val modsRootLocator = mods.listRootElement.getLocator()
    private val modsOptionLocator = mods.listOptionElement.getLocator()
    private val modsPosition = mods.position.toString()
    private val modsPositionLevel = mods.positionLevel
    private val modsArrowButton = mods.arrowButton

    override val clickableVisibleElement: SelenideElement
        get() = if (modsArrowButton.isNull)
            selfShouldBeVisible()
        else
            Selenide.`$`(modsArrowButton.getLocator()).shouldBe(CustomCondition.visible)

    private fun findPopups(waitListRoot: Boolean = true): List<SelenideElement> {

        fun getParentFromLevel(element: SelenideElement, level: Int): SelenideElement {

            var currentParent = element
            for (i in 1..level) {
                currentParent = currentParent.parent()
            }
            return currentParent
        }

        return Selenide.`$$`(modsRootLocator).let {
            if (waitListRoot)
                it.shouldHave(CollectionCondition.sizeGreaterThan(0))
            else it
        }.filter {
            getParentFromLevel(it, modsPositionLevel.level).getCssValue("position") == modsPosition.toLowerCase()
                    && it.`$`(modsOptionLocator).isDisplayed
        }
    }

    protected fun getPopupOptions(): ElementsCollection {
        var collection: List<SelenideElement> = ArrayList()
        val elementRoot = modsRootLocator

        try {
            Selenide.Wait().until {
                collection = findPopups()
                collection.isNotEmpty()
            }
        } catch (e: TimeoutException) {
            throw ElementNotFound("$elementRoot with ${modsPosition.toLowerCase()}" +
                    " position on $modsPositionLevel node", Condition.visible)
        }

        if (collection.size > 1) throw InvalidElementStateException("Too many popup $elementRoot found")

        return collection.first().`$$`(modsOptionLocator)
                .shouldHave(CollectionCondition.sizeGreaterThan(0))
    }

    protected fun implPopupShouldBeVisible() {
        Selenide.Wait().until {
            findPopups().isNotEmpty()
        }
    }

    protected fun implPopupShouldBeHidden() {
        Selenide.Wait().until {
            findPopups(false).isEmpty()
        }
    }

    protected fun implSetByClick(index: Int) {
        clickableVisibleElement.click()
        getPopupOptions().filter(Condition.visible).let {
            if (index < 0) it.last() else it[index]
        }.click()
    }

    open fun getOptions(): List<String> {
        clickableVisibleElement.click()
        return getPopupOptions().filter(Condition.visible).texts() ?: ArrayList()
    }
}