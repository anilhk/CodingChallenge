package com.thinkhr.challenge.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thinkhr.challenge.reader.Reader;
import com.thinkhr.challenge.service.RandomWordService;

@Component
public class RandomWordServiceImpl implements RandomWordService {

	@Autowired
	private Reader reader;

	private static final Logger logger = LoggerFactory.getLogger(RandomWordServiceImpl.class);

	@Override
	public String getRandomWord() throws IOException, URISyntaxException {

		if (!reader.fileExists()) {
			throw new FileNotFoundException("File does not exists");
		}

		Integer totalLines = reader.getTotalNumberOfLines();
		logger.debug("total number of lines in the files " + totalLines);
		
		if (totalLines <=0) {
			throw new IllegalArgumentException("File is empty with no records");
		}

		Random random = new Random();
		Integer line = random.nextInt(totalLines);
		logger.debug("Random number selected  " + line);

		String word = reader.getRandomWord(line);
		logger.debug("random word from the file is" + word);

		return word;

	}

}
