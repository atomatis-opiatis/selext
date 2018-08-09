package selext.element.field

import org.openqa.selenium.By
import selext.element.SelenideElementStorage

class TextArea(by: By) : FieldObject(by) { //todo
    override fun shouldBeVisible(): SelenideElementStorage {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun shouldBeHidden(): SelenideElementStorage {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun shouldNotBeVisible(): SelenideElementStorage {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun shouldHaveAttribute(name: String): SelenideElementStorage {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun shouldHaveAttribute(name: String, value: String): SelenideElementStorage {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun shouldHaveClass(className: String): SelenideElementStorage {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun shouldNotHaveClass(className: String): SelenideElementStorage {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun shouldExist(): SelenideElementStorage {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hover(): SelenideElementStorage {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    } //todo text/value? добавить метод для добавления текста на новой строке "\n" + text
}
