package com.thinkhr.challenge.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.thinkhr.challenge.reader.impl.FileReader;

@RunWith(MockitoJUnitRunner.class)
public class RandomWordServiceImplTest {

	
	@InjectMocks
	private RandomWordServiceImpl randomWordServiceImpl;
	
	@Mock
	private FileReader fileReader;
	
	@Test 
	public void getRandomWordTest() throws Exception {
		
		when(fileReader.fileExists()).thenReturn(true);
		when(fileReader.getTotalNumberOfLines()).thenReturn(3);
		when(fileReader.getRandomWord(anyInt())).thenReturn("anil");
		assertEquals(randomWordServiceImpl.getRandomWord(),"anil");
		
		when(fileReader.getTotalNumberOfLines()).thenReturn(2);
		when(fileReader.getRandomWord(anyInt())).thenReturn("sunil");
		assertEquals(randomWordServiceImpl.getRandomWord(),"sunil");

		
		when(fileReader.getTotalNumberOfLines()).thenReturn(1);
		when(fileReader.getRandomWord(anyInt())).thenReturn("renu");
		assertEquals(randomWordServiceImpl.getRandomWord(),"renu");

	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getRandomWordTestIllegalArgumentException() throws Exception {
		
		when(fileReader.fileExists()).thenReturn(true);
		when(fileReader.getTotalNumberOfLines()).thenReturn(0);
		randomWordServiceImpl.getRandomWord();
		
	}
	
	
	@Test(expected=FileNotFoundException.class)
	public void getRandomWordTestException() throws Exception  {
		
		when(fileReader.fileExists()).thenReturn(false);
		randomWordServiceImpl.getRandomWord();
		
	}
	
}
