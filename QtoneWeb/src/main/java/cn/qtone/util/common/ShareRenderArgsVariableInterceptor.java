package cn.qtone.util.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ShareRenderArgsVariableInterceptor extends HandlerInterceptorAdapter {
    static Log log = LogFactory.getLog(ShareRenderArgsVariableInterceptor.class);
    
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    	if(modelAndView!=null){//防止为空错误
	        String viewName = modelAndView.getViewName();
	        if(viewName != null && !viewName.startsWith("redirect:")) {
	            //笔者扩展的httpInclude
	            modelAndView.addObject("httpInclude", new HttpInclude(request, response));
	        }
    	}
    }

}