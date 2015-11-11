package cn.qtone.util.init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.qtone.util.tools.LoggerUtil;


/**
 * 
 * 单独初始化Spring IOC 容器（单应用模式时）
 * @author Ethan.Lam  2011-7-13
 *
 */
public class BusinessContainer {
   
	private ApplicationContext ctx = null;
	
	private static BusinessContainer client = new BusinessContainer();
	
	final String APP_HOME = "F:/zj/04newxxt/XxtBusinessProject/";
//	final String purviewclass = "lzserj.business.purview.DefaultPurviewImp";
	final String logCfgPath="config/log4j.xml";
	
	
	private BusinessContainer(){
		init();
	}
	
	public ApplicationContext getApplicationContext(){
		return ctx;
	}
	
	/**
	 * 初始化 Spring IOC
	 */
	public  void init() {
		try {
			System.setProperty("APP_HOME",APP_HOME);
			if(ctx==null)
			   ctx = new FileSystemXmlApplicationContext("config/SpringContext.xml");
//			XxtBusinessBootCfg.setupPurviewHandler(purviewclass, logCfgPath);
			LoggerUtil.info("已经加载Spring环境......");
			BusinessBootCfg.setupSpringUtilHandler(SpringContextImp.class);
			LoggerUtil.info("已经完成程序上下文环境的配置......");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static BusinessContainer getInstance(){
		return client;
	}
	
}
