package com.caretdev.plugins.idea.preloading


import com.caretdev.plugins.idea.Constants
import com.intellij.ide.plugins.IdeaPluginDescriptor
import com.intellij.ide.plugins.PluginManagerCore
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.PreloadingActivity
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.project.ProjectManagerListener
import org.jetbrains.plugins.textmate.TextMateService
import org.jetbrains.plugins.textmate.configuration.BundleConfigBean
import org.jetbrains.plugins.textmate.configuration.TextMateSettings

class PluginPreloadingActivity : PreloadingActivity() {
    override fun preload(indicator: ProgressIndicator) {
        val plugin = PluginManagerCore.getPlugin(PluginId.getId(Constants.PLUGIN_ID))
        setupSyntaxHighlighting(plugin)
        val lspUtils = LSPUtils(plugin!!.pluginPath)
        lspUtils.registerServerDefinition()

        var connect = ApplicationManager.getApplication().messageBus.connect()
        connect.subscribe(ProjectManager.TOPIC, object : ProjectManagerListener {
            override fun projectOpened(project: Project) {
                lspUtils.registerServerDefinition(project);
            }
        })

        ProjectManager.getInstance().addProjectManagerListener { _: Project? ->
            true
        }
    }

    private fun setupSyntaxHighlighting(plugin: IdeaPluginDescriptor?) {
        val state = TextMateSettings.getInstance().state ?: TextMateSettings.TextMateSettingsState()
        val bundlePath = plugin!!.pluginPath.resolve("lib/textmate").toFile().absolutePath
        state.setBundles(setOf(BundleConfigBean("objectscript", bundlePath, true)))
        TextMateSettings.getInstance().loadState(state)
        TextMateService.getInstance().reloadEnabledBundles()
    }
}
