package com.caretdev.plugins.idea.project

import com.caretdev.plugins.idea.InterSystemsIcons
import com.intellij.openapi.actionSystem.CustomShortcutSet
import com.intellij.openapi.roots.ui.configuration.ModuleSourceRootEditHandler
import java.awt.Color
import javax.swing.Icon

class InterSystemsSourceRootEditHandler :
    ModuleSourceRootEditHandler<InterSystemsSourceRootProperties>(InterSystemsSourceRootType.SOURCE) {

    override fun getRootTypeName(): String = "Sources"

    override fun getRootIcon(): Icon = InterSystemsIcons.ICON

    override fun getFolderUnderRootIcon(): Icon = InterSystemsIcons.ICON

    override fun getMarkRootShortcutSet(): CustomShortcutSet? = null

    override fun getRootsGroupTitle(): String = "Sources"

    override fun getRootsGroupColor(): Color = Color.LIGHT_GRAY

    override fun getUnmarkRootButtonText(): String = "Unmark"
}
