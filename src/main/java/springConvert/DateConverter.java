package springConvert;

import java.text.SimpleDateFormat;
import java.util.Date;

/*import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.expression.ParseException;

public class DateConverter implements Converter<String, Date> {    
@Override    
public Date convert(String source) {    
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");    
    dateFormat.setLenient(false);         
 
       try {
		return dateFormat.parse(source);
	} catch (java.text.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	   
           
    return null;    
}  
}*/


import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;


public class DateConverter implements WebBindingInitializer {

	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
	}
	
}