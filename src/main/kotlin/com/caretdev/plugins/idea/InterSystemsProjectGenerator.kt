package com.caretdev.plugins.idea

import com.caretdev.plugins.idea.InterSystemsIcons.Companion.ICON
import com.intellij.facet.ui.ValidationResult
import com.intellij.openapi.module.Module
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.NlsContexts
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.DirectoryProjectGenerator
import javax.swing.Icon

class InterSystemsProjectGenerator : DirectoryProjectGenerator<Any?> {
    override fun getName(): @NlsContexts.Label String {
        return "InterSystems"
    }

    override fun getLogo(): Icon? {
        return ICON
    }

    override fun generateProject(project: Project, baseDir: VirtualFile, settings: Any, module: Module) {}
    override fun validate(baseDirPath: String): ValidationResult {
        return ValidationResult.OK
    }
}