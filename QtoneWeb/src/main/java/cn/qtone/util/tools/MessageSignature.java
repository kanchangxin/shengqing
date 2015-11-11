package cn.qtone.util.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 封装java数字签名方法
 * @author 
 *
 */
public class MessageSignature {

	/**
	 * 取得签名
	 * @param strSrc    要签名的串
	 * @param hashAlgorithm  签名算法：  可选：MD5,SHA-1  ,选哪个参见：http://stark-summer.iteye.com/blog/1313884
	 * @return 散列签名
	 */
	public static String getSignature(String strSrc, String hashAlgorithm) {
		String strDes=null;
		try {
			MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
			md.update(strSrc.getBytes());
			// 通过执行诸如填充之类的最终操作完成哈希计算
			strDes = bytes2Hex(md.digest()); // to HexString
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Invalid algorithm name:["+hashAlgorithm+"]/n" + e.getMessage());
		}
		return strDes;
	}

	/**
	 * 将字节转换为十六进制字符串  ，大写的！
	 * @param bts
	 * @return
	 */
	public  static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;

		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des.toUpperCase();
	}
	
	// 下面的方法等效与上面的方法将字节转换为十六进制字符串  
	// protected static String byteToHexStr(byte ib) {
	// char[] Digit = {
	// '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
	// 'D', 'E', 'F'
	// };
	// char[] ob = new char[2];
	// ob[0] = Digit[(ib >>> 4) & 0X0F];
	// ob[1] = Digit[ib & 0X0F];
	//
	// String s = new String(ob);
	// return s;
	// }
	// // 将字节数组转换为十六进制字符串
	// protected static String byteToStr(byte[] bytearray) {
	// String strDigest = "";
	// for (int i = 0; i < bytearray.length; i++) {
	// strDigest += byteToHexStr(bytearray[i]);
	// }
	// return strDigest;
	// }
//	public static void main(String[] args) {
//		String strSrc = "可以加密汉字.Oh,and english";
//		System.out.println("Source String:" + strSrc);
//		System.out.println("Encrypted String:");
//		System.out.println("Use MD5:" + getSignature(strSrc, "MD5"));
//		System.out.println("Use SHA-1:" + getSignature(strSrc, "SHA-1"));
//		System.out.println("Use SHA-256:" + getSignature(strSrc, "SHA-256"));
		
//		Source String:可以加密汉字.Oh,and english
//		Encrypted String:
//		Use MD5:0ddaea21399c0109391d806afd931fdc
//		Use SHA-1:8a05e3bceb94886c6836c55cc6d78ae9d2f1cd5b
//		Use SHA-256:ec905fc366afdccd78c00f8fd006c6ca766d41e1bb13dc4b9c936040e62cd0a1
//	}

}
