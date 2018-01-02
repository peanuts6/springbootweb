package xqy.msa.springbootweb.admin.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class DashboardCtrl {

	@RequestMapping
	public <T> ResponseEntity<T> dashboard(){
		return new ResponseEntity("admin dashboard",HttpStatus.OK);
	}
	
	@RequestMapping("/list")
	public <T> ResponseEntity<T> getlist(){
		List<String> list = new ArrayList<String>();
		list.add("string 1");
		list.add("String 2");
		list.add("String 3");
		return new ResponseEntity(list,HttpStatus.OK);
	}
}
