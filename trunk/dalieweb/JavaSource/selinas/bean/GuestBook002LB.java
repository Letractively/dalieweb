package selinas.bean;

import java.io.Serializable;

public class GuestBook002LB extends ErrorBean implements Serializable {

	private String name;
	private String email;
	private String content;
	
	public GuestBook002LB() {
		super();
		this.name = "Name";
		this.email = "eMail";
		this.content = "Geben Sie hier Ihren Kommentar ein";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String eMail) {
		this.email = eMail;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "GuestBook002LB [name=" + name + ", email=" + email
				+ ", content=" + content + "]";
	}
	
	
}
