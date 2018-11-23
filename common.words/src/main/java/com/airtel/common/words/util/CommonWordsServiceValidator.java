package com.airtel.common.words.util;

import java.util.List;

import com.airtel.common.words.exception.RequestNotValidException;

public class CommonWordsServiceValidator {

	public static void validateRequest(List<String> filePaths) throws RequestNotValidException {

		if (null == filePaths || filePaths.size() < 2) {

			throw new RequestNotValidException("Input file paths can not be null. At least two files must be provied!");
		}
	}
}
