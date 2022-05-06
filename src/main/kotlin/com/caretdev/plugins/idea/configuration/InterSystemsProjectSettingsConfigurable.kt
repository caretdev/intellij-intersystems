package com.caretdev.plugins.idea.configuration

import com.caretdev.plugins.idea.preloading.LSPUtils
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import javax.swing.JComponent

class InterSystemsProjectSettingsConfigurable(private val project: Project) :
    WithProject(project),
    Configurable.VariableProjectAppLevel,
    Configurable {

    private var settingsPanel: InterSystemsProjectSettingsPanel? = InterSystemsProjectSettingsPanel(project)

    override fun isProjectLevel(): Boolean = true

    override fun createComponent(): JComponent {
        settingsPanel = settingsPanel ?: InterSystemsProjectSettingsPanel(project)
        return settingsPanel!!.getPanel()
    }

    override fun isModified(): Boolean =
        settingsPanel!!.isModified(InterSystemsProjectSettings.getStoredSettings(project))

    override fun apply() {
        settingsPanel!!.storeSettings(InterSystemsProjectSettings.getStoredSettings(project))
        LSPUtils.notifyConfigChanges(project)
    }

    override fun reset() = settingsPanel!!.setData(InterSystemsProjectSettings.getStoredSettings(project))

    override fun getDisplayName(): String = "InterSystems"

    override fun disposeUIResources() {
//        Disposer.dispose(settingsPanel!!)
        this.settingsPanel = null
    }
}
