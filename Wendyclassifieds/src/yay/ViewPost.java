package yay;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

public class ViewPost extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6382672640336368062L;
	private ArrayList<Post> posts;
	private  boolean uidTargetAll;

	public ArrayList<Post> getPosts() {
		return posts;
	}

	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}

	public boolean isUidTargetAll() {
		return uidTargetAll;
	}

	public void setUidTargetAll(boolean uidTargetAll) {
		this.uidTargetAll = uidTargetAll;
	}


}
