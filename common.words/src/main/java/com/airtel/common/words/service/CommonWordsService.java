package com.airtel.common.words.service;

import java.util.List;

import com.airtel.common.words.exception.DataNotFoundException;
import com.airtel.common.words.exception.ServiceException;

public interface CommonWordsService {

	List<String> findCommonWords(List<String> filePaths) throws DataNotFoundException, ServiceException;

}
