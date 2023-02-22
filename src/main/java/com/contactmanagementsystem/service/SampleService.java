package com.contactmanagementsystem.service;

import java.util.List;

import com.contactmanagementsystem.entity.Sample;
import com.contactmanagementsystem.request.EditRequest;
import com.contactmanagementsystem.request.SampleRequest;
import com.contactmanagementsystem.response.SampleResponse;

public interface SampleService {
    public String sample(SampleRequest sampleRequest);
    List<SampleResponse> getSampleResponse(String search);
    public String editSample(EditRequest editRequest);
    public String deleteSample(Long id);
}
