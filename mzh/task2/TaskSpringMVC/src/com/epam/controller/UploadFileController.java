package com.epam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.epam.model.UploadFile;
import com.epam.service.UploadFileService;

@Controller
public class UploadFileController {

	@Autowired
	private UploadFileService uploadFileService;

	@RequestMapping(value = "/files", method = RequestMethod.GET)
	public String files(Model model) {
		try {
			model.addAttribute("files", uploadFileService.getUploadFiles());
		} catch (Exception exception) {
			return "error";
		}
		return "files";
	}

	@RequestMapping(value = "/file", method = RequestMethod.GET)
	public String uploadFilePage() {
		return "file";
	}

	@RequestMapping(value = "/file", method = RequestMethod.POST)
	public String uploadFile(HttpServletRequest request, @RequestParam CommonsMultipartFile uploadFile) {
		UploadFile file = new UploadFile();
		file.setName(uploadFile.getOriginalFilename());
		file.setType(uploadFile.getContentType());
		file.setContent(uploadFile.getBytes());
		try {
			uploadFileService.save(file);
		} catch (Exception exception) {
			return "error";
		}
		return "redirect:/files";
	}

	@RequestMapping(value = "/file/{id}", method = RequestMethod.GET)
	public void downloadFile(@PathVariable Integer id, HttpServletResponse response) throws Exception {
		UploadFile uploadFile = uploadFileService.get(id);
		response.setContentType(uploadFile.getType());
		response.setContentLength(uploadFile.getContent().length);
		response.setHeader("Content-Disposition", "attachment; filename=\"" + uploadFile.getName() + "\"");
		FileCopyUtils.copy(uploadFile.getContent(), response.getOutputStream());
	}

	@RequestMapping(value = "/file/{id}/remove")
	public String remove(@PathVariable Integer id) {
		try {
			uploadFileService.remove(id);
		} catch (Exception exception) {
			return "error";
		}
		return "redirect:/files";
	}
}
