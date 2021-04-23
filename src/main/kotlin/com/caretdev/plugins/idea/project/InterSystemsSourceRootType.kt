package com.caretdev.plugins.idea.project

import org.jetbrains.jps.model.ex.JpsElementTypeBase
import org.jetbrains.jps.model.module.JpsModuleSourceRootType

class InterSystemsSourceRootType :
    JpsElementTypeBase<InterSystemsSourceRootProperties>(),
    JpsModuleSourceRootType<InterSystemsSourceRootProperties> {

    companion object {
        val SOURCE: InterSystemsSourceRootType = InterSystemsSourceRootType()
        val TEST_SOURCE: InterSystemsSourceRootType = InterSystemsSourceRootType()
    }

    override fun createDefaultProperties(): InterSystemsSourceRootProperties =
        InterSystemsSourceRootProperties()
}
