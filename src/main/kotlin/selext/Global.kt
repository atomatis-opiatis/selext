package selext

import selext.TestUtils.logger
import kotlin.reflect.KClass

/**
 * Синглтон как набор глобальных параметров.
 */
object Global {

    private val garbageObjects = HashSet<IGarbageObject<*>>()
    @JvmStatic lateinit var testConfig: TestConfig

    private val params = hashMapOf<String, Any>()
    private val states = hashMapOf<String, Boolean>()

    @JvmStatic fun setState(key: String, state: Boolean) {
        states[key] = state
    }

    @JvmStatic fun setState(key: String) {
        states[key] = true
    }

    @JvmStatic fun stateInit(key: String, block: () -> Unit) {
        if (!getState(key)) {
            block()
            setState(key)
        }
    }

    @JvmStatic fun getState(key: String): Boolean = !(states[key] == null || states[key] == false)

    @JvmStatic fun setParam(key: String, param: Any) {
        params[key] = param
    }

    @JvmStatic fun getParam(key: String): Any? = params[key]

    @JvmStatic fun addGarbage(item: IGarbageObject<*>) {
        if (garbageObjects.none { it.uniqueCode == item.uniqueCode })
            garbageObjects.add(item)
    }

    private fun deleteGarbageForEach(list: Set<IGarbageObject<*>>) {
        ArrayList<IGarbageObject<*>>(list).forEach {
            try {
                it.delete()
            } catch (e: Exception) {
                logger().warn("Garbage not deleted: ${e.message}")
            }
            garbageObjects.remove(it)
        }
    }

    @JvmStatic fun deleteGarbage() = deleteGarbageForEach(garbageObjects)

    @JvmStatic fun deleteGarbage(item: IGarbageObject<*>) {
        deleteGarbageForEach(garbageObjects.filter { it == item }.toHashSet())
    }

    @JvmStatic fun <Type> deleteGarbage(type: Class<Type>) {
        deleteGarbageForEach(garbageObjects.filter { it::class.java.isAssignableFrom(type) }.toHashSet())
    }

    @JvmStatic fun <Type : Any> deleteGarbage(type: KClass<Type>) = deleteGarbage(type::class.java)

    @JvmStatic fun clear() {
        params.clear()
        states.clear()
        deleteGarbage()
    }
}