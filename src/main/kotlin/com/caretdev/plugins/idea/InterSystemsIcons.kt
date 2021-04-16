package com.caretdev.plugins.idea

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

class InterSystemsIcons {
    companion object {
        val FILE: Icon = IconLoader.getIcon("/icons/intersystems.svg", InterSystemsIcons::class.java)
        val ICON = FILE
    }
}