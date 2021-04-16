package com.caretdev.plugins.idea.preloading

import com.caretdev.plugins.idea.configuration.InterSystemsProjectSettings
import com.google.gson.annotations.SerializedName

class LSClientConfig(settings: InterSystemsProjectSettings) {
    private var traceLog = settings.isLsTraceLogs()
    private var objectscript = ObjectScript().apply {
        conn = ObjectScriptConnection().apply {
            host = settings.getHost()
            port = settings.getPort()
            namespace = settings.getNamespace()
            username = settings.getUsername()
            password = settings.getPassword()
        }
    }

    internal class ObjectScript {
        internal var conn = ObjectScriptConnection()
    }

    internal class ObjectScriptConnection {
        internal var active = true
        internal var host = ""
        @SerializedName("superPort")
        internal var port = 1972
        @SerializedName("ns")
        internal var namespace = ""
        internal var username = ""
        internal var password = ""
    }
}
