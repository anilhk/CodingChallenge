package com.thinkhr.challenge.reader.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.thinkhr.challenge.reader.Reader;

/**
 * 
 * @author anil
 *  
 *  FileReader performs the following functions to 
 *  
 *  
 */
@Component
public class FileReader implements Reader {

	@Value("${file.name}")
	private String fileName;

	private static final Logger logger = LoggerFactory.getLogger(FileReader.class);

	/**
	 *  checks if the file exists on the path specified by {@link #fileName} variable. 
	 *  returns true if exists else false.
	 */
	@Override
	public boolean fileExists() throws URISyntaxException {

		Path path = Paths.get(fileName);
		logger.debug("fileName = " +fileName);
		return Files.exists(path, new LinkOption[] { LinkOption.NOFOLLOW_LINKS });

	}

	/**
	 *  Retrieves the total number of lines in the file specified by the {@link #fileName} variable.
	 */
	@Override
	public Integer getTotalNumberOfLines() throws IOException {

		int noOfLines = 0;

		try (FileChannel channel = FileChannel.open(Paths.get(fileName), StandardOpenOption.READ)) {
			ByteBuffer byteBuffer = channel.map(MapMode.READ_ONLY, 0, channel.size());
			while (byteBuffer.hasRemaining()) {
				byte currentByte = byteBuffer.get();
				if (currentByte == '\n')
					noOfLines++;
			}
		}
	
		return noOfLines;
	}

	/**
	 * given a line number returns the word present on the line. 
	 */
	@Override
	public String getRandomWord(Integer number) throws IOException {

		String line = "";

		try (Stream<String> all_lines = Files.lines(Paths.get(fileName))) {
			line = all_lines.skip(number - 1).findFirst().get();
		}
		return line;
	}

}
