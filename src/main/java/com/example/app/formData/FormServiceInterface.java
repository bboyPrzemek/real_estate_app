package com.example.app.formData;

import org.springframework.data.domain.Page;

import com.example.app.model.Estate;


public interface FormServiceInterface{
	 Page<? extends Estate> search(SearchFormData formData, Integer page);
	 Boolean create(CreateFormData formData);
}
