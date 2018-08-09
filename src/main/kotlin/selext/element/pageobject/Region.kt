package selext.element.pageobject

import selext.element.BasicElement
import selext.element.field.*
import selext.element.mod.ComboboxMods
import selext.element.mod.DropdownMods
import selext.element.selector.ElementSelector
import selext.element.selector.FieldCollectionSelector
import selext.element.selector.ModElementSelector
import selext.element.selector.RegionSelector
import org.openqa.selenium.By
import org.openqa.selenium.SearchContext
import selext.element.mod.interfaces.IMod
import kotlin.reflect.KFunction1
import kotlin.reflect.KFunction2

abstract class Region : BasicElement() {

    override fun init(searchContext: SearchContext?, index: Int) {
        initElements(searchContext, index)
    }

    protected fun <R : Region> list(region: () -> R) = RegionSelector(region)

    protected fun <R : FieldObject> list(elementSelector: ElementSelector<R>) //todo add ModdedElementSelector too
            = FieldCollectionSelector(ElementSelector::class.java.getDeclaredField("elementCreation").let {
        it.isAccessible = true
        it.get(elementSelector)
    } as KFunction1<By, R>)

    protected val list get() = FieldCollectionSelector(::Text)

    protected fun <R : FieldObject> field(fieldCreation: KFunction1<By, R>)
            = ElementSelector(fieldCreation)

    protected fun <R : FieldObject, M : IMod> field(fieldCreation: KFunction2<By, M, R>, modsCreation: () -> M)
            = ModElementSelector(fieldCreation, modsCreation)

    protected fun <R : FieldObject> f(fieldCreation: KFunction1<By, R>)
            = field(fieldCreation)

    protected fun <R : FieldObject, M : IMod> f(fieldCreation: KFunction2<By, M, R>, modsCreation: () -> M)
            = field(fieldCreation, modsCreation)

    protected val button get() = field(::Button)

    protected val checkbox get() = field(::Checkbox)

    protected val combobox
        get() = field<Combobox, ComboboxMods>(::Combobox, ::ComboboxMods)

    protected val dropdown
        get() = field<Dropdown, DropdownMods>(::Dropdown, ::DropdownMods)

    protected val input get() = field(::Input)

    protected val link get() = field(::Link)

    protected val text get() = field(::Text)

    protected val label get() = field(::Text)

    protected val textarea get() = field(::TextArea)

    protected val span get() = field(::Text)

    protected val div get() = field(::Text)
}