package selext

import org.apache.commons.io.IOUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.io.FileOutputStream

object TestUtils {

    @JvmStatic
    fun logger(): Logger {
        return LoggerFactory.getLogger("root")
    }

    @JvmStatic
    fun stream2file(path: String): File {
        var suffix: String? = path.substringAfterLast('.')
        suffix = if (suffix == path || suffix.isNullOrEmpty()) null else ".$suffix"
        val prefix: String = path.substringAfterLast(File.separator).substringBeforeLast('.')
        val input = this::class.java.getResourceAsStream(path)
        val tempFile = File.createTempFile(prefix, suffix)

        tempFile.setExecutable(true)
        tempFile.deleteOnExit()
        FileOutputStream(tempFile).use { out -> IOUtils.copy(input, out) }
        logger().info("Created file: " + tempFile.absolutePath)

        return tempFile
    }
}
