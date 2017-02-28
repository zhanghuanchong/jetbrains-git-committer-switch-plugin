package com.wuruihong.jetbrains.gitCommitterSwitch;

import com.intellij.openapi.components.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vcs.ProjectLevelVcsManager;
import com.intellij.openapi.vcs.VcsDirectoryMapping;
import com.intellij.util.xmlb.XmlSerializerUtil;
import com.intellij.util.xmlb.annotations.AbstractCollection;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Main Project Component
 */
@State(name = "GitCommitterSwitchMainProjectComponent", storages = {@Storage(StoragePathMacros.WORKSPACE_FILE)})
public class MainProjectComponent implements ProjectComponent, PersistentStateComponent<MainProjectComponent> {
    private Project project;

    @AbstractCollection
    private List<User> users = new ArrayList<>();

    private String gitDir;

    public MainProjectComponent() {}

    public MainProjectComponent(Project project) {
        this();
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
        this.gitDir = vcsDirectoryMapping.getDirectory();
        System.out.println("VcsDirectoryMapping: " + this.gitDir);

        if (this.gitDir.isEmpty()) {
            System.out.println("Empty Vcs directory mapping!");
            this.gitDir = null;
        }
    }

    @Override
    public void projectClosed() {
        // called when project is being closed
    }

    @Override
    public MainProjectComponent getState() {
        if (this.users.isEmpty()) {
            if (this.gitDir != null) {
                String file = this.gitDir + "/.git/config";
            }
            User user = new User("Hans Zhang", "devwingcom@gmail.com");
            user.setSelected(true);
            this.users.add(user);
        } else {
            User user = this.users.get(0);
            System.out.println(user.toString());
        }
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
