package com.thinkhr.challenge.reader;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * 
 * @author anil
 * 
 * Defines a layer of abstraction to the File API.
 *
 */
public interface Reader {

	boolean fileExists() throws URISyntaxException;
	
	Integer getTotalNumberOfLines() throws IOException;
	
	String getRandomWord(Integer number) throws IOException;
}
