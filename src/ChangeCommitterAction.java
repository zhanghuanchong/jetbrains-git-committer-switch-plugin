import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.util.IconLoader;
import com.intellij.ui.components.JBList;

/**
 * Created by hans on 2017/2/9.
 */
public class ChangeCommitterAction extends AnAction {

    public ChangeCommitterAction() {
        super("Change Git Committer", null, IconLoader.getIcon("/icons/users.png"));
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        JBPopupFactory.getInstance()
                .createListPopupBuilder(new JBList("Option 1", "Option 2"))
                .createPopup()
                .showInBestPositionFor(e.getDataContext());
    }
}
