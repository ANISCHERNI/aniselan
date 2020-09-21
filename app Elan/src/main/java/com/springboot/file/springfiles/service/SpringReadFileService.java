package com.springboot.file.springfiles.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.file.springfiles.model.User;

@Service
public interface SpringReadFileService {

	 List<User> findAll() ;

	boolean saveDataFromUploadFile(MultipartFile file);
	
	
	
	

}
