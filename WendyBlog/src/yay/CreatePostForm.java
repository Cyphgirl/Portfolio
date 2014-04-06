package yay;

import org.apache.struts.action.ActionForm;

public class CreatePostForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1572664258662270787L;
	private String title;
	private String body;
	private String location;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
