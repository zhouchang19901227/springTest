package init;


import java.util.Enumeration;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class RequestInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("RequestafterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("RequestpostHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("RequestpreHandle");
		Enumeration<String> paraNames = request.getParameterNames();
		while(paraNames.hasMoreElements()) {
			String[] paraArr = request.getParameterValues(paraNames.nextElement());
			if(paraArr != null && paraArr.length > 0) {
                //拼接所有参数值
				String para = "";
				for(int i=0;i<paraArr.length;i++) {
					para += paraArr[i];
				}
                //统一转为小写
				para = para.toLowerCase();
				//参数过滤SCRIPT_PATTERN.matcher(para).find()|| !sqlValidate(para)
				if(stripXSS(para)) {//防止js注入
					if(request.getHeader("x-requested-with") != null) {
                        //如果是ajax请求
						response.getOutputStream().write("{status:false}".getBytes());
					}
					else {
						response.sendRedirect(request.getContextPath() + "/info/500");
					}
					return false;
				}
			}
		}
		return true;
	
	}
	public boolean stripXSS(String value) {
        boolean result = false;
        if (value != null) {
 
            value = value.replaceAll("", "");
 
            Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>",
                    Pattern.CASE_INSENSITIVE);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
                return result;
 
            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                            | Pattern.DOTALL);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
                return result;
 
            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                            | Pattern.DOTALL);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
                return result;
 
            scriptPattern = Pattern.compile("</script>",
                    Pattern.CASE_INSENSITIVE);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
                return result;
 
            scriptPattern = Pattern.compile("<script(.*?)>",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                            | Pattern.DOTALL);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
                return result;
 
            scriptPattern = Pattern.compile("eval\\((.*?)\\)",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                            | Pattern.DOTALL);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
                return result;
 
            scriptPattern = Pattern.compile("expression\\((.*?)\\)",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                            | Pattern.DOTALL);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
                return result;
 
            scriptPattern = Pattern.compile("vbscript:",
                    Pattern.CASE_INSENSITIVE);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
                return result;
            
            scriptPattern = Pattern.compile("onload(.*?)=",
                    Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                            | Pattern.DOTALL);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
              return result;
 
            scriptPattern = Pattern.compile("alert", Pattern.CASE_INSENSITIVE);
            result = scriptPattern.matcher(value).find();// .replaceAll("");
            if (result)
                return result;
        }
        return result;
    }

}
