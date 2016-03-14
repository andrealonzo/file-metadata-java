package com.aalonzo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.aalonzo.model.FileAnalysis;

/**
 * Contains all the business logic for the app
 * @author aalonzo
 *
 */
public class FileMetadataController {


	public FileAnalysis analyzeFile(HttpServletRequest request) throws IOException, ServletException {
		Part filePart = request.getPart("file");
		if(filePart == null){
			return null;
		}
		String fileSize= Long.toString(filePart.getSize());
		String mimetype = filePart.getContentType();
		String filename = filePart.getSubmittedFileName();
		FileAnalysis fileAnalysis = new FileAnalysis(fileSize, mimetype, filename);
		return fileAnalysis;
	}


}