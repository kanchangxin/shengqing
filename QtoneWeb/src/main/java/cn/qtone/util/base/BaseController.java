package cn.qtone.util.base;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;

import cn.qtone.util.common.VariableName;
import cn.qtone.util.tools.StringUtil;


/**
 * 基础控制器
 */
public abstract class BaseController {
	
	@Autowired
	HttpServletRequest request;
	
	/**
	 * 日志对象
	 */
	protected Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * 取得session中用户信息
	 * @return
	 */
	public BaseLoginVO getLoginUser(HttpServletRequest request){
		if(request.getSession().getAttribute(VariableName.USER)!=null){
			return (BaseLoginVO) request.getSession().getAttribute(VariableName.USER);
		}
		else{
			return null;
		}
	}

	public BaseLoginVO getLoginUser( ){
		return this.getLoginUser(request);
	}	
	
	public void setLoginUser(HttpServletRequest request,BaseLoginVO vo){
		request.getSession().setAttribute(VariableName.USER,vo);
	}
	
	public void setLoginUser(BaseLoginVO vo){
		this.setLoginUser(request, vo);
	}
	
	
	
	/**设置返回信息
	 * @param success
	 * @param message
	 * @param data
	 * @return
	 */
	public ReturnJsonData setReturnJsonData(boolean success,String message,Object data) {
		return new ReturnJsonData(success, message, data);
	}
	public ReturnJsonData setReturnJsonData(boolean success,String message) {
		return new ReturnJsonData(success, message);
	}
	public ReturnJsonData setReturnJsonData(boolean success) {
		return new ReturnJsonData(success);
	}
	public ReturnJsonData setReturnJsonData() {
		return new ReturnJsonData();
	}
	/**
	 * 取得静态页面模板的相对于网站根的根路径	 * 
	 * @return 格式如:/background/html/
	 */
	public abstract String getTemplateRoot();	
	
	
	/**
	 * 获取客户端ipd
	 * @param request
	 * @return
	 */
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if(ip.contains(",")){
			ip=ip.split(",")[0];
		}
		return ip;
	}
	/**
	 * 取得分页对象
	 * @param request    必须包含：showdivId，pageInputName
	 * @param page       当前第几页
	 * @param totalRows  总记录数
	 * @param pageSize   每页记录数
	 * @return
	 */
	public PageModel getPageOb(HttpServletRequest request,int page,int totalRows,int pageSize){
		PageModel pageOb=new PageModel();
//		String url=request.getRequestURI();
//		String restr=url;
//		String querystr=request.getQueryString();
//		if(querystr!=null)
//		{
//			if(querystr.indexOf("page=")!=-1){//过滤掉page参数
//				String startStr=querystr.substring(0,querystr.indexOf("page="));
//				String endStr=querystr.substring(querystr.indexOf("page="));
//				if(endStr.indexOf("&")!=-1){
//					restr=restr+"?"+startStr+endStr.substring(endStr.indexOf("&")+1);
//				}else{
//					restr=restr+"?"+("".equals(startStr)?"":startStr.substring(0,startStr.length()-1));
//				}
//			}else{
//				restr=restr+"?"+querystr;
//			}
//		}
//		pageOb.setShowdivId(request.getParameter("showdivId"));//分页所在div id
//		pageOb.setPageInputName(request.getParameter("pageInputName"));//分页文本框id
//		pageOb.setUrl(restr);
		pageOb.init(page, totalRows, pageSize);
		return pageOb;
	}
	
	public PageModel getPageOb(int page,int totalRows,int pageSize){
		return this.getPageOb(request,  page,  totalRows,  pageSize);
	}
	 /**登录平台
	 * @param request
	 * @return
	 */
	public String checkFrom(HttpServletRequest request){
			String from="window";
			String header=request.getHeader("user-agent");
			if(!StringUtil.isNulOrBlank(header)){
				if(header.contains("Android")){
//					if(header.contains("MicroMessenger")){
//						from="weixin";
//					}else{
						from="android";
//					}
				}else if(header.contains("iPhone")){
//					if(header.contains("MicroMessenger")){
//						from="weixin";
//					}else{
						from="iphone";
//					}
				}
			}
			
			return from;
		}
	
}

