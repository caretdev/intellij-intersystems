package com.caretdev.plugins.idea.toolWindow

import com.intellij.openapi.wm.ToolWindow
import javax.swing.JPanel
import javax.swing.JTabbedPane
import javax.swing.JTextPane

class IRISToolWindow(private val toolWindow: ToolWindow) {
    internal var content: JPanel? = null
    internal var tabbedPane: JTabbedPane? = null
    internal var outputPane: JTextPane? = null
}