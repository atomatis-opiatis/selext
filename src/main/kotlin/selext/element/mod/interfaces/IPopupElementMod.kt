package selext.element.mod.interfaces

import selext.enums.Position
import selext.enums.PositionLevel

interface IPopupElementMod : IMod {

    val listRootElement: IMod.Locator

    val listOptionElement: IMod.Locator

    val arrowButton: IMod.Locator

    var position: Position

    var positionLevel: PositionLevel
}