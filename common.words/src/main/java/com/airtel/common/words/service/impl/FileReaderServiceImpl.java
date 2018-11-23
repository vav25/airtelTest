package com.airtel.common.words.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.airtel.common.words.exception.DataNotFoundException;
import com.airtel.common.words.exception.ServiceException;
import com.airtel.common.words.service.FileReaderService;

@Service
public class FileReaderServiceImpl implements FileReaderService {

	private static Logger LOG = LogManager.getLogger(FileReaderServiceImpl.class);

	@Override
	public List<String> convertFileToWords(String path) throws DataNotFoundException, ServiceException {

		if (null == path) {

			LOG.error("File path found null!");

			throw new DataNotFoundException("Path found blank!");
		}

		BufferedReader reader = null;

		List<String> words = new ArrayList<String>();

		try {

			reader = new BufferedReader(new FileReader(path));

			reader.lines().forEach(line -> {

				String[] wordsArray = line.replaceAll("[^a-zA-Z0-9\\s+]", "").toLowerCase().split(" ");
				words.addAll(java.util.Arrays.asList(wordsArray));

			});

		} catch (IOException e) {

			LOG.error("Can not read data from path - " + path + " due to exception - " + e.getMessage());
			throw new ServiceException(
					"Can not read data from path - " + path + " due to exception - " + e.getMessage());

		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {

					LOG.error("Can not close Buffered Reader - " + e.getMessage());

				}
			}
		}

		return words;
	}

}
