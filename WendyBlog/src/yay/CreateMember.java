package yay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CreateMember extends Action {
	public ActionForward execute(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
	        throws Exception {
				DBManager dbm = new DBManager();
			
				NewMemForm member = (NewMemForm) form;

				if(!member.getPswd().equals(member.getPswdconf())){
					return mapping.findForward("failure");
				}
				dbm.startConnection();
				dbm.createMember(member);

				dbm.closeConnection();
				return mapping.findForward("success");
	
	}
}
