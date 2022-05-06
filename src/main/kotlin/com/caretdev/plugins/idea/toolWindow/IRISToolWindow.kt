package com.caretdev.plugins.idea.toolWindow

import com.intellij.ui.components.JBTabbedPane
import com.intellij.util.ui.FormBuilder
import javax.swing.JPanel
import javax.swing.JTabbedPane
import javax.swing.JTextPane

class IRISToolWindow {
    internal var content: JPanel? = null
    internal var tabbedPane: JTabbedPane = JBTabbedPane()
    internal var outputPane: JTextPane = JTextPane()

    init {
        tabbedPane.addTab("Output", outputPane)

        content = FormBuilder.createFormBuilder()
            .addComponent(tabbedPane)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }
}
