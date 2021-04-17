package com.caretdev.plugins.idea.configuration

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.options.ConfigurableProvider
import com.intellij.openapi.project.Project

class InterSystemsConfigurableProvider(private val project: Project) : ConfigurableProvider() {
    private var projectsSettingsConfigurable: Configurable? = null

    override fun createConfigurable(): Configurable? {
        projectsSettingsConfigurable = projectsSettingsConfigurable ?: InterSystemsProjectSettingsConfigurable(project)
        return projectsSettingsConfigurable
    }
}
