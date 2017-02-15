package tag;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**  
 * 验证字符
 * @项目名 nncity-web
 * @类名 LangTag.java  
 * @包名 com.sinocastel.nncity.web.jstl
 * @创建人 ym  
 * @创建时间 2016年7月27日 上午10:04:51
 * @修改人 zc
 * @修改时间 
 * @修改备注 
 * @版本 V1.0  
 * @版权 Copyright © 航通. All rights reserved.
 */
public class TokenTag extends TagSupport {
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -1815168785364991254L;

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		
		//得到uuid
		String uuid=UUID.randomUUID().toString().replace("-","");
		Map<String,String> tokenMap = (Map<String, String>) pageContext.getSession().getAttribute("tokenMap") ;
		if(tokenMap == null || tokenMap.size() == 0 ){
			tokenMap = new HashMap<String,String>();
		}
		tokenMap.put(uuid, uuid);
		//得到session
		pageContext.getSession().setAttribute("s_tokenMap",tokenMap);
		String html="<input type='hidden' id='tokenName' name='tokenName' readonly='readonly' value="+uuid+">";
		try {
			pageContext.getOut().print(html);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
		
	}

}
