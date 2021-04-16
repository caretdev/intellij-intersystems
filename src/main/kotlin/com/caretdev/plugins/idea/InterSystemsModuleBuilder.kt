package com.caretdev.plugins.idea

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.project.ProjectType
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path


class InterSystemsModuleBuilder : ModuleBuilder() {
    override fun getModuleType(): ModuleType<*> {
        return InterSystemsModuleType.getInstance()
    }

    override fun setupModule(module: Module?) {
        super.setupModule(module)
    }

    @Throws(IOException::class)
    private fun initProject(path: Path) {
        val src: Path = path.resolve("src")
        val test: Path = path.resolve("tests")
        Files.createDirectory(src)
        Files.createDirectory(test)
    }
}

