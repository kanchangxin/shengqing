package cn.qtone.util.tools;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 工具
 * 
 * @author Jason 2014-4-8 16:00:42
 * 
 */
public class MD5Util {

	public static void main(String... agrs) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		System.out.println(md5String("你好"));
	}


	/**
	 * MD5
	 * 
	 * @param encryptText
	 *            等待加密的字符串
	 * @return 加密后的字条串
	 */
	public static String md5String(String encryptText) {
		return md5Bytes(encryptText.getBytes());
	}

	/**
	 * MD5带字符集 课加密中文
	 * 
	 * @param encryptText
	 * @param charset
	 * @return
	 */
	public static String md5String(String encryptText, String charset) {
		try {
			return md5Bytes(encryptText.getBytes(charset));
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * MD5返回大写
	 * @param encryptText
	 * @return
	 */
	public static String md5StringToUpperCase(String encryptText) {
		return md5Bytes(encryptText.getBytes()).toUpperCase();
	}		

	public static String md5Bytes(byte[] encryptBytes) {
		String str = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(encryptBytes);
			byte b[] = md.digest();

			StringBuffer buf = new StringBuffer("");
			for (int i = 0; i < b.length; i++) {
				String hex = Integer.toHexString(b[i] & 0xFF);
				if (hex.length() == 1) {
					hex = '0' + hex;
				}
				buf.append(hex);
			}
			str = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}