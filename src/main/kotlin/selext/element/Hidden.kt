package selext.element

/**
 * Указывается для полей ([selext.element.field.FieldObject]
 * и [selext.element.pageobject.PageComponent]) которых нет на странице в момент инициализации pageObject.
 * Поля с аннотацией игнорируются при включенном [selext.TestConfig.extraFieldVisibilityAssertMode]
 */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Hidden