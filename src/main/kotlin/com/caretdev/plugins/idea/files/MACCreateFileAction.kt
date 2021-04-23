package com.caretdev.plugins.idea.files

import com.caretdev.plugins.idea.InterSystemsIcons
import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

class MACCreateFileAction : CreateFileFromTemplateAction(CAPTION, "", InterSystemsIcons.ICON) {
    private companion object {
        private const val CAPTION = "ObjectScript MAC Routine"
    }

    override fun buildDialog(project: Project, directory: PsiDirectory, builder: CreateFileFromTemplateDialog.Builder) {
        builder.setTitle(CAPTION)
            .addKind("Empty file", InterSystemsIcons.ICON, "ObjectScript MAC")
    }

    override fun getActionName(directory: PsiDirectory?, newName: String, templateName: String?): String = CAPTION
}
