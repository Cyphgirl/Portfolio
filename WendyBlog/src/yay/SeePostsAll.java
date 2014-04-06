package yay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SeePostsAll extends Action{
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
	        throws Exception {
				DBManager dbm = new DBManager();
				dbm.startConnection();
				ViewPost postings = (ViewPost) form;
				postings.setPosts(dbm.getPosts());
				dbm.closeConnection();
				request.setAttribute("listPosts", postings.getPosts());
				return mapping.findForward("success");
	
	}
}
