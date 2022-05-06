package com.caretdev.plugins.idea.configuration

import com.intellij.openapi.project.Project
import com.intellij.ui.components.JBCheckBox
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JFormattedTextField
import javax.swing.JPanel
import javax.swing.JPasswordField
import javax.swing.JTextField

class InterSystemsProjectSettingsPanel(project: Project) : WithProject(project) {

    internal var settingsPane: JPanel
    private var host: JTextField = JTextField()
    private var port: JFormattedTextField = JFormattedTextField()
    private var namespace: JTextField = JTextField()
    private var username: JTextField = JTextField()
    private var password: JPasswordField = JPasswordField()
    private var lsTraceLogs: JBCheckBox = JBCheckBox()

    init {
        settingsPane = FormBuilder.createFormBuilder()
            .addLabeledComponent("Host:", host)
            .addLabeledComponent("Port:", port)
            .addLabeledComponent("Namespace:", namespace)
            .addLabeledComponent("Username:", username)
            .addLabeledComponent("Password:", password)
            .addLabeledComponent("Show trace logs", lsTraceLogs)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    fun getPanel(): JComponent {
        return settingsPane
    }

    fun setData(settings: InterSystemsProjectSettings) {
        lsTraceLogs.isSelected = settings.lsTraceLogs
        host.text = settings.host
        port.text = settings.port.toString()
        namespace.text = settings.namespace
        username.text = settings.username
        password.text = settings.password
    }

    fun storeSettings(settings: InterSystemsProjectSettings) {
        settings.lsTraceLogs = lsTraceLogs.isSelected
        settings.host = host.text
        settings.port = port.text.toInt()
        settings.namespace = namespace.text
        settings.username = username.text
        settings.password = password.password.joinToString("")
    }

    fun isModified(settings: InterSystemsProjectSettings): Boolean = lsTraceLogs.isSelected != settings.lsTraceLogs ||
        host.text != settings.host ||
        port.text.toInt() != settings.port ||
        namespace.text != settings.namespace ||
        username.text != settings.username ||
        !password.password.contentEquals(settings.password.toCharArray())
}
