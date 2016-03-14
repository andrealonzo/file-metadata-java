package com.aalonzo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.aalonzo.controller.FileMetadataController;
import com.aalonzo.model.FileAnalysis;
import com.aalonzo.model.UrlError;
import com.fasterxml.jackson.databind.ObjectMapper;


@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024
		* 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileMetadataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected FileMetadataController fileMetadataController = null;

	public FileMetadataServlet() throws ServletException {
		fileMetadataController = new FileMetadataController();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// initialize JSON output writers
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();

		FileAnalysis fileAnalysis = fileMetadataController.analyzeFile(request);
		if (fileAnalysis == null) {
			out.println(mapper.writeValueAsString(new UrlError("Could not find file")));
		} else {
			out.println(mapper.writeValueAsString(fileAnalysis));
		}
	}

}
