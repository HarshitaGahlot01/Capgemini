package com.gal.api;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gal.model.Department;

@RestController
@RequestMapping("/json")
public class JsonDemoController {
	@GetMapping("/department")
 public ResponseEntity<String> getDepartmentJson() throws JsonProcessingException{
 {
		Department d=new Department();
		d.setDepartmentId(70);
		d.setDepartmentName("HR");
		d.setEstablishedDate(Date.valueOf("2020-05-05"));
		d.setManagerId(111);
		ObjectMapper mapper=new ObjectMapper();
		String s=mapper.writeValueAsString(d);
		ResponseEntity.ok().body(s);//ok code 200
		ResponseEntity.status(HttpStatus.CREATED).body(s); // created new Department
		ResponseEntity.status(HttpStatus.NO_CONTENT);
		return ResponseEntity.ok().header("content-type","application/json").body(s);
				
				
	 
 }
}}
