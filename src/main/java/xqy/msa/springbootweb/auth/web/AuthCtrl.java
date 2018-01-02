package xqy.msa.springbootweb.auth.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthCtrl 
{
	@RequestMapping(value="/api/getSessionId")
	@ResponseBody
	public String getSessionId(HttpServletRequest request){
		
		Object o = request.getSession().getAttribute("springboot");
		if(o == null){
			o = "spring boot port "+request.getLocalPort()+" created";
			request.getSession().setAttribute("springboot", o);
		}
		
		return "端口=" + request.getLocalPort() +  " sessionId=" + request.getSession().getId() +"<br/>"+o;
	}
}
