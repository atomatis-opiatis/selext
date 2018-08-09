package selext

/**
 *
 */
interface IGarbageObject<out Type> {

    val value: Type

    fun delete()

    val uniqueCode: String
        get() = hashCode().toString()
}