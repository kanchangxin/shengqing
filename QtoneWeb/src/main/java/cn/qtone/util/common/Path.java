package cn.qtone.util.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import cn.qtone.util.tools.LoggerUtil;
import cn.qtone.util.tools.StringUtil;

/**
 * @author huangshengqing
 * 2014年5月11日
 */
public class Path {

	private static Properties path = new Properties();// 保存配置文件
	public static String WeixinService="SERVICE";
	public static String WeixinBusiness="BUSINESS";
	// 初始化配置文件
	static {
		try {
			// 按照类路径寻找
			//应用程序所有配置
			//String strP = getProjectPath() + "/";
			
			//web所有配置
			String strP = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			LoggerUtil.info("配置文件加载路径是：" + strP);
			path.load(new FileInputStream(strP + "path.properties"));
			LoggerUtil.info("配置文件path.properties加载完毕！");
		} catch (FileNotFoundException e) {
			LoggerUtil.info("异常：没找到配置文件path.properties！");
		} catch (Exception e) {
			LoggerUtil.logger.error(e);
			LoggerUtil.info("异常：初始化配置文件时出错！");
		}
	}
	
	
}
