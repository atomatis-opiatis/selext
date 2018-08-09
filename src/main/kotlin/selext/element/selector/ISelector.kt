package selext.element.selector

interface ISelector<R> {

    infix fun id(string: String): R

    infix fun name(string: String): R

    infix fun css(string: String): R

    infix fun xpath(string: String): R
}