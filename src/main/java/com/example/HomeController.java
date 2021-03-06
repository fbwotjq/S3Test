package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

@Controller
public class HomeController {

	@Autowired S3Wrapper s3Wrapper;
	
	@GetMapping("/")
	@ResponseBody public Map<String, Object> home() {
		Map<String, Object> map = new HashMap<>();
		map.put("result", s3Wrapper.list());
		return map;
	}
	
	@GetMapping("/")
	@ResponseBody public Map<String, Object> listBuckets() {
		
		AWSCredentials credentials = new BasicAWSCredentials("???", "???");
        ClientConfiguration clientConfig = new ClientConfiguration();
        clientConfig.setProtocol(Protocol.HTTP);
        AmazonS3 conn = new AmazonS3Client(credentials, clientConfig);
        conn.setEndpoint("s3-ap-northeast-2.amazonaws.com");
		Map<String, Object> map = new HashMap<>();
		map.put("result", conn.listBuckets());
		return map;
	}
	
}
