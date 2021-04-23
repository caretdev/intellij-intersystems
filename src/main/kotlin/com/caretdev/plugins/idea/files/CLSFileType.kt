package com.caretdev.plugins.idea.files

import com.caretdev.plugins.idea.InterSystemsIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.plugins.textmate.TextMateLanguage
import javax.swing.Icon

object CLSFileType : LanguageFileType(TextMateLanguage.LANGUAGE) {

    override fun getName(): String = "ObjectScript Class"

    override fun getDescription(): String = "ObjectScript class"

    override fun getDefaultExtension(): String = "cls"

    override fun getIcon(): Icon = InterSystemsIcons.ICON
}
