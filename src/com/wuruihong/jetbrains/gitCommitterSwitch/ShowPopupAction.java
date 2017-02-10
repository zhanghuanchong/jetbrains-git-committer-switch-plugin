package com.wuruihong.jetbrains.gitCommitterSwitch;

import com.intellij.ide.actions.QuickSwitchSchemeAction;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;

/**
 * Created by hans on 2017/2/9.
 */
public class ShowPopupAction extends QuickSwitchSchemeAction {
    protected ShowPopupAction() {
        super();
        this.getTemplatePresentation().setIcon(IconLoader.getIcon("/icons/users.png"));
    }

    @Override
    protected String getPopupTitle(AnActionEvent e) {
        return "Chang Git Committer";
    }

    @Override
    protected void fillActions(Project project, @NotNull DefaultActionGroup defaultActionGroup, @NotNull DataContext dataContext) {
        String[] users = {"User 1", "User 2"};
        for (String u: users) {
            AnAction action = new ChangeAction();
            action.getTemplatePresentation().setText(u);

            defaultActionGroup.addAction(action);
        }

        defaultActionGroup.addSeparator();
        defaultActionGroup.addAction(new ConfigUsersAction());
    }
}
