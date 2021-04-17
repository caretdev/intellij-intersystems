package com.caretdev.plugins.idea.configuration

import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.project.Project
import java.io.Serializable

class InterSystemsProjectSettings : Serializable {
    var lsTraceLogs = false
    var host = ""
    var port = 0
    var namespace = ""
    var username = ""
    var password = ""

    companion object {
        const val serialVersionUID = 42L
        fun getStoredSettings(project: Project): InterSystemsProjectSettings {
            val component: InterSystemsProjectSettingsComponent = ServiceManager.getService(
                project,
                InterSystemsProjectSettingsComponent::class.java
            )
                ?: return InterSystemsProjectSettings()
            return component.state
        }
    }
}
