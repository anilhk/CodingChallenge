package com.thinkhr.challenge.reader.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class FileReaderTest {

	
	private FileReader fileReader;
	
	@Before
	public void setUp() {
		fileReader = new FileReader();
		ReflectionTestUtils.setField(fileReader, "fileName", "src/test/resources/words_alpha.txt" );

	}
	
	@Test
	public void fileExists() throws Exception {
		assertTrue(fileReader.fileExists());
	}
	
	@Test
	public void filedoesNotExists() throws Exception {
		
		ReflectionTestUtils.setField(fileReader, "fileName", "src/test/resources/words_alph.txt" );
		assertFalse(fileReader.fileExists());

	}
	
	@Test
	public void getTotalNumberOfLinesTest() throws Exception {
		
		assertEquals(fileReader.getTotalNumberOfLines(),new Integer(3));
		
	}
	
	@Test
	public void getRandomWordTest() throws IOException {
		assertEquals(fileReader.getRandomWord(2),"sunil");
		assertEquals(fileReader.getRandomWord(1),"anil");
		assertEquals(fileReader.getRandomWord(3),"renu");
		
	}
	
	
}
