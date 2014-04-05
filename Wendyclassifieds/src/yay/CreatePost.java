package yay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CreatePost extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CreatePostForm cp = (CreatePostForm) form;
		  DBManager dbm = new DBManager();
	        dbm.startConnection();
	        int uid = (int) request.getSession().getAttribute("uid");
	        Post post = new Post(cp.getLocation(), cp.getTitle(), cp.getBody());
	        dbm.createPost(post, uid);
	        dbm.closeConnection();
		return mapping.findForward("success");
	}
}
