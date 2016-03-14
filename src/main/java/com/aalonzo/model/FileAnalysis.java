package com.aalonzo.model;

public class FileAnalysis {
	private String fileSize;
	private String mimetype;
	private String filename;
	public FileAnalysis(String fileSize, String mimetype, String filename) {
		this.fileSize = fileSize;
		this.mimetype = mimetype;
		this.filename = filename;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getMimetype() {
		return mimetype;
	}
	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	

}
