package com.airtel.common.words.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airtel.common.words.exception.DataNotFoundException;
import com.airtel.common.words.exception.ServiceException;
import com.airtel.common.words.service.CommonWordsService;
import com.airtel.common.words.service.FileReaderService;

@Service
public class CommonWordsServiceImpl implements CommonWordsService {

	private static Logger LOG = LogManager.getLogger(CommonWordsServiceImpl.class);

	@Autowired
	private FileReaderService fileReaderService;

	@Override
	public List<String> findCommonWords(List<String> filePaths) throws DataNotFoundException, ServiceException {

		Set<String> commonWords = new HashSet<String>();
		List<String> commonWordsList = new ArrayList<String>();
		boolean firstFile = true;

		for (String filePath : filePaths) {

			LOG.info("Reading file from path - " + filePath);

			List<String> wordsInFile = fileReaderService.convertFileToWords(filePath);
			LOG.info("Words found - " + wordsInFile.size());

			if (firstFile) {
				commonWords.addAll(wordsInFile);
			} else {
				commonWords.retainAll(wordsInFile);
			}

			firstFile = false;
		}
		
		commonWordsList.addAll(commonWords);

		return commonWordsList;

	}
}
