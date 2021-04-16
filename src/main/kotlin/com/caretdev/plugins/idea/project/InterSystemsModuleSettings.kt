package com.caretdev.plugins.idea.project

import com.intellij.openapi.module.Module;
import com.intellij.codeInsight.daemon.DaemonCodeAnalyzer
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.StoragePathMacros
import com.intellij.openapi.module.ModuleServiceManager
import com.intellij.openapi.project.Project
import com.intellij.psi.impl.source.resolve.ResolveCache
import com.intellij.util.xmlb.XmlSerializerUtil


@State(
    name = "InterSystems",
    storages = [Storage(value = StoragePathMacros.MODULE_FILE)]
)
class InterSystemsModuleSettings(private val myModule: Module) :
    PersistentStateComponent<InterSystemsModuleSettings.InterSystemsModuleSettingsState> {

    companion object {
        fun getInstance(module: Module?): InterSystemsModuleSettings? {
            return ModuleServiceManager.getService(module!!, InterSystemsModuleSettings::class.java)
        }
    }

    private val myState = InterSystemsModuleSettingsState()
    private fun cleanResolveCaches() {
        val project: Project = myModule.project
        if (project.disposed.equals(false)) {
            ResolveCache.getInstance(project).clearCache(true)
            DaemonCodeAnalyzer.getInstance(project).restart()
        }
    }

    override fun getState(): InterSystemsModuleSettingsState {
        return myState
    }

    override fun loadState(state: InterSystemsModuleSettingsState) {
        XmlSerializerUtil.copyBean(state, myState)
    }

    class InterSystemsModuleSettingsState
}
