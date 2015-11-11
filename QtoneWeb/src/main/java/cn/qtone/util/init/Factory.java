package cn.qtone.util.init;

import org.apache.log4j.xml.DOMConfigurator;

import cn.qtone.util.tools.LoggerUtil;


public class Factory {
	
//    private static IPurviewInfo purview;
//
//	public static IPurviewInfo getPurview() {
//		return purview;
//	}
	
	
	/**
	 * @param purviewclass
	 * @param lo4j
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static void init(String purviewclass,String lo4j) throws Exception{
		LoggerUtil.info("log4j已经配置...");
		DOMConfigurator.configure(lo4j);//初始化log4j
	
	}
}
