package com.caretdev.plugins.idea.extensions.client

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.event.DocumentListener
import com.intellij.openapi.editor.event.EditorMouseListener
import com.intellij.openapi.editor.event.EditorMouseMotionListener
import org.wso2.lsp4intellij.client.languageserver.ServerOptions
import org.wso2.lsp4intellij.client.languageserver.requestmanager.RequestManager
import org.wso2.lsp4intellij.client.languageserver.wrapper.LanguageServerWrapper
import org.wso2.lsp4intellij.editor.EditorEventManager
import org.wso2.lsp4intellij.listeners.LSPCaretListenerImpl

@Suppress("LongParameterList")
class InterSystemsEditorEventManager(
    editor: Editor,
    documentListener: DocumentListener?,
    mouseListener: EditorMouseListener?,
    mouseMotionListener: EditorMouseMotionListener?,
    caretListener: LSPCaretListenerImpl?,
    requestManager: RequestManager?,
    serverOptions: ServerOptions?,
    wrapper: LanguageServerWrapper?
) : EditorEventManager(
    editor,
    documentListener,
    mouseListener,
    mouseMotionListener,
    caretListener,
    requestManager,
    serverOptions,
    wrapper
)
