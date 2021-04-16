package com.caretdev.plugins.idea.configuration

import com.google.gson.annotations.SerializedName
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.project.Project
import java.io.Serializable

class InterSystemsProjectSettings : Serializable {

    private var lsTraceLogs = false
    private var host = ""
    private var port = 1972
    private var namespace = ""
    private var username = ""
    private var password = ""

    companion object {
        fun getStoredSettings(project: Project): InterSystemsProjectSettings {
            val component: InterSystemsProjectSettingsComponent = ServiceManager.getService(
                project,
                InterSystemsProjectSettingsComponent::class.java
            )
                ?: return InterSystemsProjectSettings()
            return component.state
        }
    }

    fun isLsTraceLogs(): Boolean {
        return lsTraceLogs
    }

    fun setLsTraceLogs(lsTraceLogs: Boolean) {
        this.lsTraceLogs = lsTraceLogs
    }

    fun getHost() : String {
        return host
    }

    fun setHost(value : String) {
        host = value
    }

    fun getNamespace() : String {
        return namespace
    }

    fun setNamespace(value: String) {
        namespace = value
    }

    fun getUsername() : String {
        return username
    }

    fun setUsername(value: String) {
        username = value
    }

    fun getPort() : Int {
        return port
    }

    fun setPort(value : Int) {
        port = value
    }

    fun getPassword() : String {
        return password
    }

    fun setPassword(value : String) {
        password = value
    }
}