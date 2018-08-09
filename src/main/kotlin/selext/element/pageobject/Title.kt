package selext.element.pageobject

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Title(val string: String = "", val regex: String = "")