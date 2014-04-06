package yay;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
public class LoginAction extends Action{
    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginForm loginForm = (LoginForm) form;
        NewMemForm nmf;
        DBManager dbm = new DBManager();
        dbm.startConnection();
        loginForm.setUid(dbm.getUid(loginForm.getUsername(), loginForm.getPassword()));
        if (loginForm.getUid() > -1) {
        nmf = dbm.getMember(loginForm.getUid());
        loginForm.setName(nmf.getName());
        loginForm.setEmail(nmf.getEmail());
        loginForm.setLocation(nmf.getLocation());
        loginForm.setTelno(nmf.getTelno());
        loginForm.setBio(nmf.getBio());
        dbm.closeConnection();
        request.getSession().setAttribute("uid", loginForm.getUid());

            return mapping.findForward(SUCCESS);
        } else {
            return mapping.findForward(FAILURE);
        }
    }
}
