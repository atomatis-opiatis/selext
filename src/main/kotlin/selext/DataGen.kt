package selext

import java.util.*
import java.util.Calendar as Cal

object DataGen { //todo

    object Calendar {

        @JvmStatic val now: Cal
            get() = Cal.getInstance()

        @JvmStatic val today: Cal
            get() = now

        @JvmStatic val midnight: Cal
            get() = now.apply {
                set(Cal.HOUR_OF_DAY, 0)
                set(Cal.MINUTE, 0)
                set(Cal.SECOND, 0)
                set(Cal.MILLISECOND, 0)
            }

        @JvmStatic val tomorrow: Cal
            get() = now.apply {
                add(Cal.DATE, 1)
            }

        @JvmStatic val yesterday: Cal
            get() = now.apply {
                add(Cal.DATE, -1)
            }

        @JvmStatic val dayAgo: Cal = yesterday

        @JvmStatic val monthAgo: Cal
            get() = now.apply {
                add(Cal.MONTH, -1)
            }

        @JvmStatic val yearAgo: Cal
            get() = now.apply {
                add(Cal.YEAR, -1)
            }
    }

    object Text {
        @JvmField val notSpecified = "Не указан"
    }

    object Id {
        @JvmStatic val shortUUID: String
            get() = UUID.randomUUID().toString().substring(0, 4)

        @JvmStatic val longUUID: String
            get() = UUID.randomUUID().toString()
    }
}