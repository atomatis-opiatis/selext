package selext.element

interface IPageArea {

    private fun fieldsShouldBeVisible() {
        this::class.java.fields.forEach {
            if (it.name != "INSTANCE" && !it.isAnnotationPresent(Hidden::class.java)) {
                when {
                    SelenideElementStorage::class.java.isAssignableFrom(it.type) -> {
                        (it.get(this) as SelenideElementStorage).shouldBeVisible()
                    }
                    ElementCollectionStorage::class.java.isAssignableFrom(it.type) -> {
                        (it.get(this) as ElementCollectionStorage<*>).shouldBeVisible()
                    }
                }
            }
        }
    }

    fun allFieldsShouldBeVisible() = fieldsShouldBeVisible()
}