package com.caretdev.plugins.idea.notifiers

import com.intellij.notification.Notification
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationGroupManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.MessageType
import com.intellij.remoteServer.util.CloudNotifier

class InterSystemsLSLogNotifier : CloudNotifier(notificationDisplayId) {
    companion object {
        const val notificationDisplayId = "InterSystems Language Server Logs"
    }

    fun showMessage(project: Project, message: String, messageType: MessageType) {
        val notificationGroup: NotificationGroup = findOrCreateBalloonGroup()!!
        val notification: Notification =
            notificationGroup.createNotification(message, messageType.toNotificationType())
        if (project.isOpen && !project.isDisposed) {
            notification.notify(project)
        } else {
            notification.notify(null)
        }
    }

    private fun findOrCreateBalloonGroup(): NotificationGroup? {
        return NotificationGroupManager.getInstance().getNotificationGroup(notificationDisplayId)
    }
}
