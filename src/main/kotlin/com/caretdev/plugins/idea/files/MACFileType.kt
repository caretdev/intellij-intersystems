package com.caretdev.plugins.idea.files

import com.caretdev.plugins.idea.InterSystemsIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.plugins.textmate.TextMateLanguage
import javax.swing.Icon

object MACFileType : LanguageFileType(TextMateLanguage.LANGUAGE) {

    override fun getName(): String = "ObjectScript Routine"

    override fun getDescription(): String = name

    override fun getDefaultExtension(): String = "mac"

    override fun getIcon(): Icon = InterSystemsIcons.ICON

    override fun getDisplayName(): String = name
}
