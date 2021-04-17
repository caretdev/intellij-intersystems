package com.caretdev.plugins.idea.configuration

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@State(name = "InterSystemsProjectSettings", storages = [Storage("InterSystems.project.xml")])
class InterSystemsProjectSettingsComponent private constructor() :
    PersistentStateComponent<InterSystemsProjectSettings> {
    private var settings: InterSystemsProjectSettings = InterSystemsProjectSettings()
    override fun getState(): InterSystemsProjectSettings {
        return settings
    }

    override fun loadState(state: InterSystemsProjectSettings) {
        settings = state
    }
}
