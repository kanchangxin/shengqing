package cn.qtone.controller;

import cn.qtone.business.model.Criteria;
import cn.qtone.business.model.User;
import cn.qtone.services.UserService;
import cn.qtone.util.base.BaseController;
import cn.qtone.util.base.ReturnJsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author huangshengqing
 * 2015年11月10日
 */
@Controller
@RequestMapping(value = "/cross")
public class LoginController extends BaseController {
	
	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/login.do")
	public ReturnJsonData test1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReturnJsonData returnJsonData=new ReturnJsonData(true);
		User user=new User();
		user.setName("测试用户");
		user.setPassword("123456");
		user.setState(0);
		user.setCreateDate(new Date());

		returnJsonData.setData(user);
		return returnJsonData;
	}
	/* (non-Javadoc)
	 * @see cn.qtone.util.base.BaseController#getTemplateRoot()
	 */
	@Override
	public String getTemplateRoot() {
		// TODO Auto-generated method stub
		return null;
	}

}
