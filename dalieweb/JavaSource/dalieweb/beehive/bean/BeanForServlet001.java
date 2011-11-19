package dalieweb.beehive.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BeanForServlet001 implements Serializable {
	
	private String name = null;
	private String firstName = null;
	private List<String> errorList = null;
	
	public BeanForServlet001() {
		this.name = "Name";
		this.firstName = "firstName";
		this.errorList = new ArrayList<String>();
	}

	public void addMessage(String message) {
		errorList.add(message);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}
	
}
