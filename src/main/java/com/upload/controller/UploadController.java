package com.upload.controller;




import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/api.upload")
public class UploadController {
	
	@Autowired
	private Environment env;
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> uploadFile(@RequestParam("uploadFile") MultipartFile uploadFile){
		try {
			String fileName=uploadFile.getOriginalFilename();
			String directory = env.getProperty("path.uploadedFiles");
			String uploadFilepath = Paths.get("."+File.separator+directory,fileName).toString();
			
			final BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(uploadFilepath)));
			stream.write(uploadFile.getBytes());
			stream.close();
			
			
		}
		
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}

