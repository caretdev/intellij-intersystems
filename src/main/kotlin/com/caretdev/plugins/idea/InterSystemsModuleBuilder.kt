package com.caretdev.plugins.idea

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType

class InterSystemsModuleBuilder : ModuleBuilder() {
    override fun getModuleType(): ModuleType<*> {
        return InterSystemsModuleType.getInstance()
    }

    override fun setupModule(module: Module?) {
        super.setupModule(module)
    }
}
