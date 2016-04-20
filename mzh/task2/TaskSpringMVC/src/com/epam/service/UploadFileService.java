package com.epam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.dao.UploadFileDAO;
import com.epam.model.UploadFile;

@Service
@Transactional
public class UploadFileService {

	@Autowired
	private UploadFileDAO uploadFileDAO;

	public UploadFile get(int id) {
		return uploadFileDAO.get(id);
	}
	
	public List<UploadFile> getUploadFiles() {
		return uploadFileDAO.getUploadFiles();
	}

	public void save(UploadFile uploadFile) throws Exception {
		uploadFileDAO.save(uploadFile);
	}

	public void remove(int id) throws Exception {
		uploadFileDAO.remove(id);
	}
}