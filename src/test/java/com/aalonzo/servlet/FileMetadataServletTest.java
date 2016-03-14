package com.aalonzo.servlet;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import com.aalonzo.controller.FileMetadataController;
import com.aalonzo.model.FileAnalysis;

public class FileMetadataServletTest {

	HttpServletResponse response;
	HttpServletRequest request;
	StringWriter stringWriter;
	PrintWriter writer;

	@Before
	public void setUp() throws IOException {
		// create mock objects
		response = mock(HttpServletResponse.class);
		request = mock(HttpServletRequest.class);
		stringWriter = new StringWriter();
		writer = new PrintWriter(stringWriter);
		when(response.getWriter()).thenReturn(writer);
	}

	@Test
	public void testDoPost() throws ServletException, IOException, ClassNotFoundException, SQLException {

		FileMetadataController fileMetadataController = mock(FileMetadataController.class);

		String fileSize = "10";
		String mimetype = "mimetype";
		String filename = "filename";

		FileAnalysis fileAnalysis = new FileAnalysis(fileSize, mimetype, filename);

		String expectedOutput = "{\"fileSize\":\"" + fileSize + "\",\"mimetype\":\"" + mimetype
				+ "\",\"filename\":\"" + filename + "\"}\n";

		when(fileMetadataController.analyzeFile(any(HttpServletRequest.class))).thenReturn(fileAnalysis);
		

		FileMetadataServlet servlet = new FileMetadataServlet();
		servlet.fileMetadataController = fileMetadataController;
		servlet.doPost(request, response);
		
		assertTrue(stringWriter.toString().equals(expectedOutput));

	}

}
