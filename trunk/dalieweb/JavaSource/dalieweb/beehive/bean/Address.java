package dalieweb.beehive.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import dalieweb.beehive.Bean;

public class Address extends Bean implements Serializable {
	
	/** Constant for BeanId */
	public static final String ADDRESS_BEAN_ID = "Address.bean.iD";
	/** Constant to usage Address.firstName */
	public static final String ADDRESS_FIRST_NAME = "Address.fristName";
	/** Constant to usage Address.lastName */
	public static final String ADDRESS_LAST_NAME = "Address.lastName";
	/** Constant to usage Address.street1 */
	public static final String ADDRESS_STREET_1 = "Address.street1";
	/** Constant to usage Address.street2 */
	public static final String ADDRESS_STREET_2 = "Address.street2";
	/** Constant to usage Address.city */
	public static final String ADDRESS_CITY = "Address.city";
	/** Constant to usage Address.state */
	public static final String ADDRESS_STATE = "Address.state";
	/** Constant to usage Address.postalCode */
	public static final String ADDRESS_POSTAL_CODE = "Address.postalCode";
	/** Constant to usage Address.contry */
	public static final String ADDRESS_COUNTRY = "Address.country";
	/** Constant to usage Address.isSubmitted*/
	public static final String ADDRESS_SUBMITTED = "Address.isSubmitted";
	
	
	/** Address: firstName */
	private String firstName = null;
	/** Address: lastName */
	private String lastName = null;
	/** Address: street */
	private String street1 = null;
	/** Address: additional street */
	private String street2 = null;
	/** Address: city */
	private String city = null;
	/** Address: state */
	private String state = null;
	/** Address: postalCode */
	private String postalCode = null;
	/** Address: country */
	private String country = null;
	
	private List<String> error;
	
	public Address(){
		this.error = new ArrayList<String>();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	public List<String> getError() {
		return error;
	}

	public void setError(List<String> error) {
		this.error = error;
	}


	@Override
	public String toString() {
		return "Address [firstName=" + firstName + ", lastName=" + lastName
				+ ", street1=" + street1 + ", street2=" + street2 + ", city="
				+ city + ", state=" + state + ", postalCode=" + postalCode
				+ ", country=" + country + "]";
	}

	/**
	 * To verify Address.
	 * 
	 * @return true is valid
	 * 
	 * */
	@Override
	public boolean isValidate() {
		
		/* fistName is mandatory */
		if (StringUtils.isBlank(this.firstName)) {
			error.add("First Name is Missing.");
		}
		/* lastName is mandatory */
		if (StringUtils.isBlank(this.lastName)) {
			error.add("Last Name is Missing");
		}
		/* street1 is mandatory */
		if (StringUtils.isBlank(this.street1)) {
			error.add("Street is Missing");
		}
		/* city is mandatory */
		if (StringUtils.isBlank(this.city)) {
			error.add("City is Missing");
		}
		/* State is mandatory */
		if (StringUtils.isBlank(this.state)) {
			error.add("State is Missing");
		}
		/* postalCode is mandatory */
		if (StringUtils.isBlank(this.postalCode)) {
			error.add("PostalCode is Missing");
		}
		/* country is mandatory */
		if (StringUtils.isBlank(this.country)) {
			error.add("Country is Missing");
		}
		
		/* check is Address valid */
		if (error.size() == 0) {
			return true;
		}
		return false;
	}
	
}
