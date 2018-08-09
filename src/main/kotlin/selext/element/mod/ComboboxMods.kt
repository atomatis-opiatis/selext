package selext.element.mod

import selext.enums.Position
import org.openqa.selenium.By
import selext.Global
import selext.element.mod.interfaces.IPopupElementMod
import selext.element.mod.interfaces.IMod
import selext.enums.PositionLevel

class ComboboxMods(clickableBy: By?, listRootBy: By, listOptionBy: By,
                   override var position: Position, override var positionLevel: PositionLevel) : IPopupElementMod {
    constructor() : this(
            Global.testConfig.defaultComboboxClickableLocator,
            Global.testConfig.defaultComboboxUlLocator,
            Global.testConfig.defaultComboboxOptionLocator,
            Global.testConfig.defaultComboboxPositionType,
            Global.testConfig.defaultComboboxPositionLevel)

    override val listRootElement = IMod.Locator(listRootBy)
    override val listOptionElement = IMod.Locator(listOptionBy)
    override val arrowButton = IMod.Locator(clickableBy)
}