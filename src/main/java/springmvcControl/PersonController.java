package springmvcControl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import SpringImplService.PersonService;
import entity.hibernate.Person;

@Controller
@RequestMapping(value="/person")
public class PersonController {
	@Resource(name="personService")
	private PersonService personService;
	
	@RequestMapping(value="/savePersonUI", method = { RequestMethod.GET,  RequestMethod.POST})
	public String savePersonUI(){
		return "savePersonForm";
	}
	@RequestMapping(value="/test", method = {RequestMethod.GET})
	@ResponseBody
	public Object test(Person person){
	System.out.println(person.getLastUpdateTime().toString());
    System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(person.getLastUpdateTime()));;
		HashMap<String, Object> map =new HashMap<String,Object>();
		map.put("test", "111");
		map.put("test2", "2222");
		map.put("test22222", "1112222");
		return map;
	}
	
	@RequestMapping(value="/jsonp", method = {RequestMethod.GET})
	@ResponseBody
	public void test(HttpServletRequest request,HttpServletResponse response){
		String str  = "jsonp";        
		JSONObject json = new JSONObject();        
		json.put("name", str);        
		try {            
			response.getWriter().print("handler("+json.toJSONString()+")");
		} catch (IOException e) {  
		   e.printStackTrace();       
		}
	}
	

}
