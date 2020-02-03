package com.cisco.cmad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CmadLogAnalyzerController {

	@Autowired
	private  LogAnalyzerRepo repo;
	
	@RequestMapping(path = "/log", method = RequestMethod.POST)
	public HttpStatus  add(@RequestBody Log log) {
		repo.save(log);
		return HttpStatus.CREATED;
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String  index() {
		return "Hello";
	}

}

