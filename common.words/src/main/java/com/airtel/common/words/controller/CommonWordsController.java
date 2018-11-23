package com.airtel.common.words.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.airtel.common.words.service.CommonWordsService;
import com.airtel.common.words.util.CommonWordsServiceValidator;

@RestController
public class CommonWordsController {
	
	private static Logger LOG = LogManager.getLogger(CommonWordsController.class);

	@Autowired
	private CommonWordsService commonWordsService;

	@PostMapping("/airtel/api/v1/commonwords")
	public List<String> findCommonWords(@RequestBody List<String> filePaths) throws Throwable {
		
		String methodName = "findCommonWords";
		
		LOG.info("Enetering method - " + methodName);

		CommonWordsServiceValidator.validateRequest(filePaths);

		List<String> commonWords =  commonWordsService.findCommonWords(filePaths);
		
		LOG.info("Common Words found - " + commonWords.size());
		
		LOG.info("Exiting method - " + methodName);
		
		return commonWords;

	}

}
