package com.caretdev.plugins.idea

import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.module.ModuleTypeManager
import org.jetbrains.annotations.Nls
import javax.swing.Icon

class InterSystemsModuleType : ModuleType<InterSystemsModuleBuilder>(Constants.MODULE_TYPE_ID) {
    companion object {
        fun getInstance(): InterSystemsModuleType {
            return ModuleTypeManager.getInstance().findByID(Constants.MODULE_TYPE_ID) as InterSystemsModuleType
        }
    }

    override fun createModuleBuilder(): InterSystemsModuleBuilder = InterSystemsModuleBuilder()

    override fun getName(): @Nls(capitalization = Nls.Capitalization.Title) String = "InterSystems"

    override fun getDescription(): @Nls(capitalization = Nls.Capitalization.Sentence) String =
        "InterSystems module"

    override fun getNodeIcon(isOpened: Boolean): Icon =
        InterSystemsIcons.ICON
}
