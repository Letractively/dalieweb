/**
 * 
 */
package dalieweb.beehive.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import dalieweb.beehive.Bean;

/**
 * @author Dalie
 *
 */
public class GuestBookEntry extends Bean implements Serializable {
	
	/** Constant to usage GuestBookEntry.Name */
	public static final String GUESTBOOK_ENTRY_NAME = "Guestbook.EntryName";
	/** Constant to usage GuestBookEntry.EAddress */
	public static final String GUESTBOOK_ENTRY_EADDRESS = "Guestbook.EntryEMail";
	/** Constant to usage GuestBookEntry.textEntry */
	public static final String GUESTBOOK_ENTRY_TEXTENTRY = "Guestbook.EntryMessage";
	/** Constant to usage GUESTBOOK.isSubmitted*/
	public static final String GUESTBOOK_SUBMITTED = "Guestbook.isSubmitted";
	
	/** GuestBookEntry: Name */
	private String entryName = null;
	/** GuestBookEntry: EMail */
	private String entryEMail = null;
	/** GuestBookEntry: Text */
	private String entryText = null;
	
	private List<String> error;
	
	public GuestBookEntry(){
		this.error = new ArrayList<String>();
	}	

	/**
	 * To verify GuestBookEntry.
	 * 
	 * @return true is valid
	 * 
	 * */
	@Override
	public boolean isValidate() {
		
		/* EntryName is mandatory */
		if (StringUtils.isBlank(this.entryName)) {
			error.add("Name is Missing.");
		}
		/* EntryEMail is mandatory */
		if (StringUtils.isBlank(this.entryEMail)) {
			error.add("MailAddress is Missing.");
		}
		/* EntryText is mandatory */
		if (StringUtils.isBlank(this.entryText)) {
			error.add("Entry is Missing.");
		}
		
		/* check is GuestBookEntry valid */
		if (error.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "GuestBookEntry [entryName=" + entryName + ", entryEMail="
				+ entryEMail + ", entryText=" + entryText + ", error=" + error
				+ "]";
	}

	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public String getEntryEMail() {
		return entryEMail;
	}

	public void setEntryEMail(String entryEMail) {
		this.entryEMail = entryEMail;
	}

	public String getEntryText() {
		return entryText;
	}

	public void setEntryText(String entryText) {
		this.entryText = entryText;
	}

	public List<String> getError() {
		return error;
	}

	public void setError(List<String> error) {
		this.error = error;
	}
	
}
