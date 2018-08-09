package selext.element.mod

import selext.enums.Position
import selext.element.mod.interfaces.IMod
import org.openqa.selenium.By
import selext.Global
import selext.element.mod.interfaces.IPopupElementMod
import selext.enums.PositionLevel

class DropdownMods(clickableBy: By?, listRootBy: By, listOptionBy: By,
                        override var position: Position, override var positionLevel: PositionLevel) : IPopupElementMod {
    constructor() : this(
            Global.testConfig.defaultDropdownClickableLocator,
            Global.testConfig.defaultDropdownUlLocator,
            Global.testConfig.defaultDropdownOptionLocator,
            Global.testConfig.defaultDropdownPositionType,
            Global.testConfig.defaultDropdownPositionLevel)

    override val listRootElement = IMod.Locator(listRootBy)
    override val listOptionElement = IMod.Locator(listOptionBy)
    override val arrowButton = IMod.Locator(clickableBy)
}