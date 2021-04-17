package com.caretdev.plugins.idea.preloading

import com.caretdev.plugins.idea.configuration.InterSystemsProjectSettings
import com.caretdev.plugins.idea.extensions.InterSystemsLSPExtensionManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManager
import org.eclipse.lsp4j.DidChangeConfigurationParams
import org.wso2.lsp4intellij.IntellijLanguageClient
import org.wso2.lsp4intellij.client.languageserver.serverdefinition.RawCommandServerDefinition
import java.nio.file.Path

class LSPUtils(private val pluginPath: Path) {
    companion object {
        fun notifyConfigChanges(project: Project) {
            val clientConfig = LSClientConfig(InterSystemsProjectSettings.getStoredSettings(project))
            IntellijLanguageClient.didChangeConfiguration(DidChangeConfigurationParams(clientConfig), project)
        }
    }

    fun registerServerDefinition() {
        for (project in ProjectManager.getInstance().openProjects) {
            registerServerDefinition(project)
        }
    }

    fun registerServerDefinition(project: Project) {
        val isDebug = "true" == System.getProperty("idea.is.internal")
        val extList = "mac,cls,inc,int,csp"

        val manager = InterSystemsLSPExtensionManager()
        for (ext in extList.split(",")) {
            IntellijLanguageClient.addExtensionManager(ext, manager)
        }

        val os = OSUtils.operatingSystem
        val arch = System.getProperty("os.arch")
        val exe = if (OSUtils.operatingSystem == OSUtils.WINDOWS) ".exe" else ""
        val lsPath = pluginPath.resolve("lib/language-server/$os-$arch/intersystems-ls$exe")

        var command = arrayOf(lsPath.toAbsolutePath().toString())
        if (isDebug) {
            command = command.plus(arrayOf("-vvvv"))
        }
        IntellijLanguageClient.addServerDefinition(
            RawCommandServerDefinition(
                extList,
                command
            ),
            project
        )
    }
}
