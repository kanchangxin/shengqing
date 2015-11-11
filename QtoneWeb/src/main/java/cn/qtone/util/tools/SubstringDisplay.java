package cn.qtone.util.tools;

/**
 * 截取字符串并返回指定长度的字符
 * @author Administrator
 *
 */
public class SubstringDisplay {
	/**
	 * 截取字符
	 * @param value
	 * @param lenght
	 * @return
	 */
	public  String SubString(String value, int lenght)
	{
		if(value == null)
			return null;
		
		int ilenght = lenght;
		int i = value.getBytes().length;
		int j = value.length();
		
		if(i == j)
			ilenght = ilenght + 8;
			
		return this.sub(value, ilenght);
	}
	
	public  String SubString(String value)
	{
		if(value == null)
			return null;
		
		int ilenght = 0;
		int i = value.getBytes().length;
		int j = value.length();
		
		if(i == j){
			ilenght = 20;
		}
		else{
			ilenght = 11;
		}
			
		return this.sub(value, ilenght);
	}
	
	private String sub(String value, int lenght)
	{
		if (value != null && value.length() > lenght)
		{
			return value.substring(0, lenght) + "...";
		}
		else
		{
			return value;
		}		
	}
/**
 * 按规则替换字符串
 * @param value 
 * @param style
 * @return
 */
	public String strReplace(String value,String style){
		if(!StringUtil.isNulOrBlank(value)){
			return value.replace(style, "");
		}
		return value;
	}
	/**
	 * 试题处理“”
	 * @param value
	 * @return
	 */
	public String strReplace(String value){
		if(!StringUtil.isNulOrBlank(value)){
			return value.replace("\\\"", "\"").replace("<p>", "").replace("</p>", "").trim();
		}
		return value;
	}
	/**
	 * 
	 * @param str 原字符串
	 * @param str1 被替换的字符
	 * @param str2 替换的字符
	 * @return
	 */
	public String strReplace(String str,String str1,String str2) {
		if (str == null)
			return null;
		
		return str.replace(str1, str2);
	}
}
