package com.caretdev.plugins.idea.extensions.client

import com.caretdev.plugins.idea.notifiers.InterSystemsLSLogNotifier
import com.intellij.openapi.ui.MessageType
import org.eclipse.lsp4j.ConfigurationParams
import org.eclipse.lsp4j.MessageParams
import org.eclipse.lsp4j.RegistrationParams
import org.wso2.lsp4intellij.client.ClientContext
import org.wso2.lsp4intellij.client.DefaultLanguageClient
import java.util.concurrent.CompletableFuture
import org.eclipse.lsp4j.MessageType as LSMessageType

class InterSystemsLanguageClient(context: ClientContext) : DefaultLanguageClient(context) {

    companion object {
        val logNotifier: InterSystemsLSLogNotifier = InterSystemsLSLogNotifier()
    }

    override fun configuration(configurationParams: ConfigurationParams?): CompletableFuture<MutableList<Any>> {
        return super.configuration(configurationParams)
    }

    override fun registerCapability(params: RegistrationParams?): CompletableFuture<Void> {
        return super.registerCapability(params)
    }

    override fun telemetryEvent(o: Any?) {
        super.telemetryEvent(o)
    }

    override fun logMessage(messageParams: MessageParams) {
        val message = messageParams.message
        when (messageParams.type!!) {
            LSMessageType.Error -> logNotifier.showMessage(context.project!!, message, MessageType.ERROR)
            LSMessageType.Warning -> logNotifier.showMessage(context.project!!, message, MessageType.WARNING)
            LSMessageType.Info -> logNotifier.showMessage(context.project!!, message, MessageType.INFO)
            LSMessageType.Log -> logNotifier.showMessage(context.project!!, message, MessageType.INFO)
        }
    }

    override fun showMessage(messageParams: MessageParams) {
        logMessage(messageParams)
    }
}
