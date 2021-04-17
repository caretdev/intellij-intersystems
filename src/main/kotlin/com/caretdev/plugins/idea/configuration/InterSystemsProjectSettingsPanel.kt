package com.caretdev.plugins.idea.configuration

import com.intellij.openapi.Disposable
import com.intellij.openapi.project.Project
import com.intellij.util.ui.UIUtil
import javax.swing.JCheckBox
import javax.swing.JComponent
import javax.swing.JFormattedTextField
import javax.swing.JPanel
import javax.swing.JPasswordField
import javax.swing.JTextField

class InterSystemsProjectSettingsPanel(project: Project) : WithProject(project), Disposable {

    private var settingsPane: JPanel? = null
    private var lsTraceLogs: JCheckBox? = null
    private var host: JTextField? = null
    private var port: JFormattedTextField? = null
    private var namespace: JTextField? = null
    private var username: JTextField? = null
    private var password: JPasswordField? = null

    fun getPanel(): JComponent? {
        return settingsPane
    }

    fun setData(settings: InterSystemsProjectSettings) {
        lsTraceLogs!!.isSelected = settings.lsTraceLogs
        host!!.text = settings.host
        port!!.text = settings.port.toString()
        namespace!!.text = settings.namespace
        username!!.text = settings.username
        password!!.text = settings.password
    }

    fun storeSettings(settings: InterSystemsProjectSettings) {
        settings.lsTraceLogs = lsTraceLogs!!.isSelected
        settings.host = host!!.text
        settings.port = port!!.text.toInt()
        settings.namespace = namespace!!.text
        settings.username = username!!.text
        settings.password = password!!.password.joinToString("")
    }

    fun isModified(settings: InterSystemsProjectSettings): Boolean =
        lsTraceLogs!!.isSelected != settings.lsTraceLogs ||
            host!!.text != settings.host ||
            port!!.text.toInt() != settings.port ||
            namespace!!.text != settings.namespace ||
            username!!.text != settings.username ||
            !password!!.password.contentEquals(settings.password.toCharArray())

    override fun dispose() {
        UIUtil.dispose(settingsPane)
        settingsPane = null
        lsTraceLogs = null
        host = null
        port = null
        namespace = null
        username = null
        password = null
    }
}
