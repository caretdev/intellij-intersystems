package com.caretdev.plugins.idea.preloading

import java.util.Locale

object OSUtils {
    const val WINDOWS = "windows"
    const val LINUX = "linux"
    const val MAC = "darwin"
    private val OS = System.getProperty("os.name").lowercase(Locale.getDefault())

    /**
     * Returns name of the operating system running. null if not a unsupported operating system.
     *
     * @return operating system
     */
    val operatingSystem: String?
        get() {
            if (isWindows) {
                return WINDOWS
            } else if (isUnix || isSolaris) {
                return LINUX
            } else if (isMac) {
                return MAC
            }
            return null
        }
    val isWindows: Boolean
        get() = OS.contains("win")
    val isMac: Boolean
        get() = OS.contains("mac")
    val isUnix: Boolean
        get() = OS.contains("nix") || OS.contains("nux") || OS.contains("aix")
    val isSolaris: Boolean
        get() = OS.contains("sunos")
}
