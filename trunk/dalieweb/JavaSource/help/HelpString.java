/*
 * Created on 13.01.2010
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package help;

import org.apache.commons.lang.StringUtils;
/**
 * @author DV0101
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class HelpString {

	/**
	 * Remove spaces.
	 *
	 * @param argStr string to remove over spaces from.
	 * @return String
	 */
	public static String collapseSpaces(String argStr){
		if(argStr.length() > 20){
			StringBuffer argBuf = new StringBuffer();
			for (int cIdx = 0 ; cIdx < 20; cIdx++){
	            argBuf.append(argStr.charAt(cIdx));
			}//for
			return argBuf.toString();
		}else{
			return argStr;
		}//endif
	}//collapseSpaces
	
	/**
	 * Remove spaces.
	 *
	 * @param argStr string to remove over spaces from.
	 * @return String
	 */
	public static String collapseSpaces(String argStr, int count){
		if(argStr.length() > count){
			StringBuffer argBuf = new StringBuffer();
			for (int cIdx = 0 ; cIdx < count; cIdx++){
	            argBuf.append(argStr.charAt(cIdx));
			}//for
			return argBuf.toString();
		}else{
			return argStr;
		}//endif
	}//collapseSpaces
	
	/**
	 * Remove spaces.
	 *
	 * @param argStr string to remove over spaces from.
	 * @return String
	 */
	public static String collapseSpacesWP(String argStr, int count){
		if(argStr.length() > count){
			StringBuffer argBuf = new StringBuffer();
			for (int cIdx = 0 ; cIdx < count; cIdx++){
	            argBuf.append(argStr.charAt(cIdx));
			}//for
			return argBuf.toString() + "...";
		}else{
			return argStr; 
		}//endif
	}//collapseSpaces
	
	/**
	 * Remove spaces.
	 *
	 * @param argStr string to remove over spaces from.
	 * @return String
	 */
	public static String collapseHtml(String argStr){
		if(argStr.length() > 0){
			String cleanString = argStr.replaceAll("\\<.*?\\>", "");
			cleanString = StringUtils.replace(cleanString, "&nbsp;", " ");
			cleanString = StringUtils.replace(cleanString, "&Uuml;","�");
			cleanString = StringUtils.replace(cleanString, "&uuml;","�");
			cleanString = StringUtils.replace(cleanString, "&Ouml;","�");
			cleanString = StringUtils.replace(cleanString, "&ouml;","�");
			cleanString = StringUtils.replace(cleanString, "&Auml;","�");
			cleanString = StringUtils.replace(cleanString, "&auml;","�");
			cleanString = StringUtils.replace(cleanString, "&szlig;","�");
			cleanString = StringUtils.replace(cleanString, "&amp;","&");
			cleanString = StringUtils.replace(cleanString, "&lt;","<");
			cleanString = StringUtils.replace(cleanString, "&gt;",">");
			cleanString = StringUtils.replace(cleanString, "&quot;","\"");
			cleanString = StringUtils.replace(cleanString, "&sect;","�");
			cleanString = StringUtils.replace(cleanString, "&euro;","�");
			return cleanString;
		}else{
			return argStr; 
		}//endif
	}//collapseHtml
	
}//class HelpString
