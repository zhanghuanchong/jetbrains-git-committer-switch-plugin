package com.wuruihong.jetbrains.gitCommitterSwitch;

import com.intellij.notification.EventLog;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.extensions.ExtensionPointName;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vcs.ProjectLevelVcsManager;
import com.intellij.openapi.vcs.VcsDirectoryMapping;
import com.intellij.openapi.vcs.impl.VcsEP;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;

/**
 * Created by hans on 2017/2/10.
 */
public class MainProjectComponent implements ProjectComponent {
    private Project project;

    public MainProjectComponent(Project project) {
        this.project = project;
    }

    @Override
    public void initComponent() {

    }

    @Override
    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @Override
    @NotNull
    public String getComponentName() {
        return "com.wuruihong.jetbrains.gitCommitterSwitch.MainProjectComponent";
    }

    @Override
    public void projectOpened() {
        ProjectLevelVcsManager projectLevelVcsManager = ProjectLevelVcsManager.getInstance(project);
        List<VcsDirectoryMapping> list = projectLevelVcsManager.getDirectoryMappings();
        if (list.isEmpty()) {
            System.out.println("No Vcs directory mapping found!");
            return;
        }
        VcsDirectoryMapping vcsDirectoryMapping = list.get(0);
        String dir = vcsDirectoryMapping.getDirectory();
        System.out.println("VcsDirectoryMapping: " + dir);
    }

    @Override
    public void projectClosed() {
        // called when project is being closed
    }
}
