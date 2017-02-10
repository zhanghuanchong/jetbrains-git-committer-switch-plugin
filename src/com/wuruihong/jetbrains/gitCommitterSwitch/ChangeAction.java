package com.wuruihong.jetbrains.gitCommitterSwitch;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import javax.swing.*;

/**
 * Created by hans on 2017/2/9.
 */
public class ChangeAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Notification notification = new Notification(
            "GitCommitterSwitch",
            "Message",
            "Changed the current git committer to \"" + this.getTemplatePresentation().getText() + "\"",
            NotificationType.INFORMATION
        );
        Notifications.Bus.notify(notification);

        Timer timer = new Timer(2000, e1 -> {
            notification.expire();
        });
        timer.start();
    }
}
