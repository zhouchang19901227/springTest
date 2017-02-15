package springmvcControl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springAopTest.Human;
import springAopTest.Sleepable;


@Controller
public class HelloController {

	@Autowired private Sleepable human;

	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public String index(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		human.sleep();
		
		return "index";
	}
}
