package com.contactmanagementsystem.service.serviceImpl;

import com.contactmanagementsystem.entity.Sample;
import com.contactmanagementsystem.repository.Samplerepo;
import com.contactmanagementsystem.request.EditRequest;
import com.contactmanagementsystem.request.SampleRequest;
import com.contactmanagementsystem.response.SampleResponse;
import com.contactmanagementsystem.service.SampleService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {
    @Autowired
    Samplerepo samplerepo;
    @Override
    public String sample(SampleRequest sampleRequest) {
        Sample sample = new Sample();
        sample.setFirstName(sampleRequest.getFirstName());
        sample.setLastName(sampleRequest.getFirstName());
        sample.setEmail(sampleRequest.getEmail());
        sample.setPhone(sampleRequest.getPhone());
        
        
        samplerepo.save(sample);
        return "let's go in controller";
    }

    @Override
	public List<SampleResponse> getSampleResponse(String search) {
		if(search!=null) {
			return samplerepo.findAllBySearchValue(search).stream().map(this:: convertToModel).collect(Collectors.toList());
		}
		else{
			return samplerepo.findAll().stream().map(this:: convertToModel).collect(Collectors.toList());
		}

	}
	private SampleResponse convertToModel(Sample sample) {
		return SampleResponse.builder().firstName(sample.getFirstName())
				.lastName(sample.getLastName())
				.email(sample.getEmail())
				.phone(sample.getPhone()).build();
	}
	@Override
	public String editSample(EditRequest editRequest) {
		 Sample sample =samplerepo.findById(editRequest.getId()).orElseThrow(null);
	        sample.setFirstName(editRequest.getFirstName());
	        sample.setLastName(editRequest.getFirstName());
	        sample.setEmail(editRequest.getEmail());
	        sample.setPhone(editRequest.getPhone());
	        
	        
	        samplerepo.save(sample);
	        return "let's go in controller";
	}
	@Override
	public String deleteSample(Long id) {
		 Sample sample =samplerepo.findById(id).orElseThrow(null);
		 samplerepo.delete(sample);

		return "go to Controller";
	}

}
