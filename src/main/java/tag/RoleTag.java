package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;



/**  
 * 角色权限标签
 * @项目名 nncity-web
 * @类名 LangTag.java  
 * @包名 com.sinocastel.nncity.web.jstl
 * @创建人 ym  
 * @创建时间 2014年12月2日 上午10:04:51
 * @修改人 
 * @修改时间 
 * @修改备注 
 * @版本 V1.0  
 * @版权 Copyright © 航通. All rights reserved.
 */
public class RoleTag extends TagSupport {

	private String menu;
	private String action;

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public int doStartTag() throws JspException {
		//注入spring缓存
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.pageContext.getServletContext());
	/*	RoleService roleService = (RoleService)context.getBean("roleService");
		if(!roleService.checkRoleAction(menu, action)) {
			return this.SKIP_BODY;
		}*/
		if(menu.equals("111"))
		{
			return this.SKIP_BODY;
		}
		return this.EVAL_BODY_INCLUDE;
	}
}
