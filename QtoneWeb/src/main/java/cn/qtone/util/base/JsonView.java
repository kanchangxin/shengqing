package cn.qtone.util.base;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.View;

/**
 * JSON视图，返回AJAX请求时后的JSON字符串
 * 
 * @author Daniel
 * 
 */
public class JsonView implements View {

	private String returnMsg;//返回值
	private boolean success = true;//结果
	private long returnCode; //返回代码
	private int resultcode=0; //返回代码

	/**
	 * 用于存储各属性和值
	 */
	private Map<String, Object> map = new HashMap<String, Object>();
	
	/**
	 * 构造方法，若采用此构造方法，则返回的jsonstring不包含msg和success属性，用于非提示信息类型的JSON构造，例如下拉列表
	 */
	public JsonView(){
		
	}
	
	public JsonView(String returnMsg) {
		this.returnMsg = StringUtils.trimToEmpty(returnMsg);
	}

	public JsonView(boolean success, String returnMsg) {
		this.returnMsg = StringUtils.trimToEmpty(returnMsg);
		this.success = success;
	}

	public String getContentType() {
		return "text/plain;charset=UTF-8";
	}

	/**
	 * 设置返回到客户端的json对象的属性
	 */
	public void setProperty(String key, Object value) {
		map.put(key, value);
	}
	
	/**
	 * 
	 * @param 设置成功true,或者失败false
	 */
	public void setSuccess(boolean b){
		this.success=b;
	}
	
	/**
	 * 取得 当前值是否是成功的标示
	 * @return
	 */
	public boolean getSuccess(){
		return this.success;
	}
	
	public String getReturnMsg() {
		return returnMsg;
	}
	/*
	 * 设置返回的消息
	 */
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	/**
	 * 使用json返回数据供前台js进行解析.
	 */
	@SuppressWarnings("unchecked")
	public void render(Map arg0, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		PrintWriter out = resp.getWriter();
		out.write(this.getJSONString());
		out.close();
		out = null;
	}

	/**
	 * 获取json字符串，例： {"success":true,"message":"操作成功！"}
	 */
	private String getJSONString() {
//		.fromMap(this.map);
		JSONObject obj = JSONObject.fromObject(this.map);
		if(returnMsg != null){
			obj.put("success", success);
			obj.put("returnMsg", returnMsg);
			obj.put("returnCode", returnCode);
			obj.put("resultcode", resultcode);
//			//此处为了兼容前端JS的代码
//			if(StringUtil.isNulOrBlank(StringUtil.valueOf(map.get("returnMsg"))))
//			    obj.put("returnMsg",returnMsg);
		}
		return obj.toString();
	}

	public long getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(long returnCode) {
		this.returnCode = returnCode;
	}

	public int getResultcode() {
		return resultcode;
	}

	public void setResultcode(int resultcode) {
		this.resultcode = resultcode;
	}
	
	
}
