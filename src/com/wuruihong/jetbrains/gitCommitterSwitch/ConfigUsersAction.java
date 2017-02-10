package com.wuruihong.jetbrains.gitCommitterSwitch;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.util.IconLoader;

/**
 * Created by hans on 2017/2/9.
 */
public class ConfigUsersAction extends AnAction {
    public ConfigUsersAction() {
        super(
            "Configure users...",
            "Configure available users to commit changes",
            IconLoader.getIcon("/icons/cog.png")
        );
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
    }
}
