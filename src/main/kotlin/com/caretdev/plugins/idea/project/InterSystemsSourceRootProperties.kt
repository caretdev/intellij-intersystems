package com.caretdev.plugins.idea.project

import org.jetbrains.jps.model.JpsSimpleElement
import org.jetbrains.jps.model.ex.JpsElementBase

class InterSystemsSourceRootProperties :
    JpsElementBase<InterSystemsSourceRootProperties>(),
    JpsSimpleElement<InterSystemsSourceRootProperties> {
    override fun createCopy(): InterSystemsSourceRootProperties =
        com.caretdev.plugins.idea.project.InterSystemsSourceRootProperties()

    override fun applyChanges(modified: InterSystemsSourceRootProperties) {
        // noting to apply, yet
    }

    override fun getData(): InterSystemsSourceRootProperties = this

    override fun setData(data: InterSystemsSourceRootProperties) {
        this.applyChanges(data)
    }
}
