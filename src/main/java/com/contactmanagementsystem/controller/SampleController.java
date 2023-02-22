package com.contactmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contactmanagementsystem.entity.Sample;
import com.contactmanagementsystem.request.EditRequest;
import com.contactmanagementsystem.request.SampleRequest;
import com.contactmanagementsystem.response.SampleResponse;
import com.contactmanagementsystem.service.serviceImpl.SampleServiceImpl;

@RestController

public class SampleController {
	@Autowired
	SampleServiceImpl sampleService;

	@PostMapping("/createContactManagementSyatem")
	public String samp(@RequestBody SampleRequest sampleRequest) {
		sampleService.sample(sampleRequest);
		return "Created sucessfully";
	}
	@GetMapping("/getContactManagementSyatem")
    public List<SampleResponse> samp(@RequestParam(required = false) String search) 
	{
		List<SampleResponse> sr=sampleService.getSampleResponse(search);
		return sr;
		
	}
//	@GetMapping("/searchUser")
//    public SampleResponse getContactManagementSytem(@RequestBody String fisrtName,
//    		String lastName, String email) 
//	{
//		SampleResponse list=sampleService.getContactManagementSytem();
//		return list;
//		
//	}
	
	@PutMapping("/editContactManagementSyatem")
	public String samp(@RequestBody EditRequest editRequest) {
		sampleService.editSample(editRequest);
		return "edited sucessfully";
	}
	@DeleteMapping("/deleteContactManagementSyatem/{id}")
	public String delete(@PathVariable Long id) {
		sampleService.deleteSample(id);
		return "Deleted";
		
	}

}
