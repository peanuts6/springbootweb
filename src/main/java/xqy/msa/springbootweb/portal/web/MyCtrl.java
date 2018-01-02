package xqy.msa.springbootweb.portal.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/my")
public class MyCtrl {
	@RequestMapping("/{username}")
	public <T> ResponseEntity<T> my(@PathVariable String username){
		return new ResponseEntity("Welcome : "+username,HttpStatus.OK);
	}
}
