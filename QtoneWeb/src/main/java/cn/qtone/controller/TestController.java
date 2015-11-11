package cn.qtone.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qtone.business.model.Criteria;
import cn.qtone.business.model.User;
import cn.qtone.services.UserService;
import cn.qtone.util.base.BaseController;
import cn.qtone.util.base.ReturnJsonData;

/**
 * @author huangshengqing
 * 2015年11月10日
 */
@Controller
@RequestMapping(value = "/test")
public class TestController extends BaseController {
	
	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/test1.do")
	public ReturnJsonData test1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReturnJsonData returnJsonData=new ReturnJsonData(true);
		User user=new User();
		user.setName("测试用户");
		user.setPassword("123456");
		user.setState(0);
		user.setCreateDate(new Date());
		userService.insertSelective(user);
		
		Criteria example=new Criteria();
		List<User> list=userService.selectByExample(example);
		returnJsonData.setData(list);
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
