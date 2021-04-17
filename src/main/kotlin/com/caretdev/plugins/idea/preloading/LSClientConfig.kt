@file:Suppress("UnusedPrivateMember")
package com.caretdev.plugins.idea.preloading

import com.caretdev.plugins.idea.configuration.InterSystemsProjectSettings
import com.google.gson.annotations.SerializedName

class LSClientConfig(settings: InterSystemsProjectSettings) {
    private val traceLog = settings.lsTraceLogs
    private val objectscript = ObjectScript().apply {
        conn = ObjectScriptConnection().apply {
            host = settings.host
            port = settings.port
            namespace = settings.namespace
            username = settings.username
            password = settings.password
        }
    }

    internal class ObjectScript {
        internal var conn = ObjectScriptConnection()
    }

    internal class ObjectScriptConnection {
        internal var active = true
        internal var host = ""
        @SerializedName("superPort")
        internal var port = 0
        @SerializedName("ns")
        internal var namespace = ""
        internal var username = ""
        internal var password = ""
    }
}
