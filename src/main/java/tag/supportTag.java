package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class supportTag  extends TagSupport  {

	private String key;

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		
		try {
			if(key=="tt")
			{
				this.pageContext.getOut().print("1111");
		    }
			else
			{
				this.pageContext.getOut().print("2222");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.EVAL_BODY_INCLUDE;
	}

}
