package com.example.app.formData;

import org.springframework.data.domain.Page;

import com.example.app.model.Estate;


public interface FormServiceInterface{
	 Page<? extends Estate> search(FormData formData, Integer page);
}
