package com.caretdev.plugins.idea

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.vfs.LocalFileSystem
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class InterSystemsModuleBuilder : ModuleBuilder() {
    override fun getModuleType(): ModuleType<*> {
        return InterSystemsModuleType.getInstance()
    }

    override fun setupRootModel(modifiableRootModel: ModifiableRootModel) {
        val entry = doAddContentEntry(modifiableRootModel) ?: return
        val path: Path = Paths.get(contentEntryPath!!)
        val src = path.resolve("src")
        Files.createDirectory(src)
        val srcPath = LocalFileSystem.getInstance().refreshAndFindFileByNioFile(src) ?: return
        entry.addSourceFolder(srcPath, false)
    }
}
