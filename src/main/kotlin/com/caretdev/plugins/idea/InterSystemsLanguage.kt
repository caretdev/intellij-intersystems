package com.caretdev.plugins.idea

import com.intellij.lang.Language

object InterSystemsLanguage : Language("objectscript") {
    override fun isCaseSensitive() = false

    override fun getDisplayName() = "ObjectScript"
}
