package selext.element.pageobject

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Url(val string: String = "", val regex: String = "")