package com.wuruihong.jetbrains.gitCommitterSwitch;

import com.intellij.notification.EventLog;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.extensions.ExtensionPointName;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vcs.ProjectLevelVcsManager;
import com.intellij.openapi.vcs.VcsDirectoryMapping;
import com.intellij.openapi.vcs.impl.VcsEP;
import com.intellij.util.xmlb.XmlSerializerUtil;
import com.intellij.util.xmlb.annotations.AbstractCollection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.List;

/**
 * Main Project Component
 */
@State(name = "GitCommitterSwitchMainProjectComponent", storages = {@Storage("git-committer-switch.xml")})
public class MainProjectComponent implements ProjectComponent, PersistentStateComponent<MainProjectComponent> {
    private Project project;

    @AbstractCollection
    private List<User> users;

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

        if (dir.isEmpty()) {
            System.out.println("Empty Vcs directory mapping!");
        }

    }

    @Override
    public void projectClosed() {
        // called when project is being closed
    }

    @Override
    public MainProjectComponent getState() {
        return this;
    }

    @Override
    public void loadState(MainProjectComponent o) {
        XmlSerializerUtil.copyBean(o, this);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
