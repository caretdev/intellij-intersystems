package com.caretdev.plugins.idea.extensions.client

import com.caretdev.plugins.idea.preloading.LSPUtils
import org.eclipse.lsp4j.*
import org.eclipse.lsp4j.services.LanguageClient
import org.eclipse.lsp4j.services.LanguageServer
import org.wso2.lsp4intellij.client.languageserver.requestmanager.DefaultRequestManager
import org.wso2.lsp4intellij.client.languageserver.wrapper.LanguageServerWrapper
import java.util.concurrent.CompletableFuture

class InterSystemsRequestManager(
    wrapper: LanguageServerWrapper?,
    server: LanguageServer?,
    client: LanguageClient?,
    serverCapabilities: ServerCapabilities?
) : DefaultRequestManager(wrapper, server, client, serverCapabilities) {

    var configSent = false

    override fun initialized(params: InitializedParams?) {
        super.initialized(params)
        configSent = false
    }

    override fun didOpen(params: DidOpenTextDocumentParams?) {
        super.didOpen(params)
        if (!configSent) {
            LSPUtils.notifyConfigChanges(wrapper!!.project!!)
            configSent = true
        }
    }
}