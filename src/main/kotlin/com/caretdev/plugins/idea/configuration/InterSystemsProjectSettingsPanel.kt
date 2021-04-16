package com.caretdev.plugins.idea.configuration

import com.intellij.openapi.Disposable
import com.intellij.openapi.project.Project
import com.intellij.util.ui.UIUtil
import javax.swing.*


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
        settings.isLsTraceLogs().also { lsTraceLogs!!.isSelected = it }
        settings.getHost().also { host!!.text = it }
        settings.getPort().also { port!!.text = it.toString() }
        settings.getNamespace().also { namespace!!.text = it }
        settings.getUsername().also { username!!.text = it }
        settings.getPassword().also { password!!.text = it }
    }

    fun storeSettings(settings: InterSystemsProjectSettings) {
        with(settings) {
            setLsTraceLogs(lsTraceLogs!!.isSelected)
            setHost(host!!.text)
            setPort(port!!.text.toInt())
            setNamespace(namespace!!.text)
            setUsername(username!!.text)
            setPassword(password!!.text)
        }
    }

    fun isModified(settings: InterSystemsProjectSettings): Boolean {
        return lsTraceLogs!!.isSelected != settings.isLsTraceLogs()
                || host!!.text != settings.getHost()
                || port!!.text.toInt() != settings.getPort()
                || namespace!!.text != settings.getNamespace()
                || username!!.text != settings.getUsername()
                || password!!.text != settings.getPassword()
    }

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

    override fun equals(obj: Any?): Boolean {
        if (this === obj) {
            return true
        } else if (obj == null || this.javaClass != obj.javaClass) {
            return false
        }
        val panel: InterSystemsProjectSettingsPanel = obj as InterSystemsProjectSettingsPanel
        return (lsTraceLogs == panel.lsTraceLogs
                && host == panel.host
                && namespace == panel.namespace
                && username == panel.username
                && password == panel.password
                && port == panel.port
                && settingsPane == panel.settingsPane)
    }

}
