package selext.extension

import com.codeborne.selenide.CollectionCondition
import selext.element.FieldCollection
import selext.element.field.Text

fun <T : FieldCollection<Text>> T.shouldHaveTextsInAnyOrder(vararg expectedTexts: String): T {
    shouldHave(CollectionCondition.textsInAnyOrder(*expectedTexts))
    return this
}

fun <T : FieldCollection<Text>> T.shouldHaveTextsInAnyOrder(expectedTexts: List<String>): T {
    shouldHave(CollectionCondition.textsInAnyOrder(expectedTexts))
    return this
}