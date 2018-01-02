package xqy.msa.springbootweb.portal.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeCtrl {
	@RequestMapping
	public <T> ResponseEntity<T> home(){
		return new ResponseEntity("welcome",HttpStatus.OK);
	}
}
