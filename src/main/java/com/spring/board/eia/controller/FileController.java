package com.spring.board.eia.controller;
import com.spring.board.eia.service.FileService;
import com.spring.board.eia.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class FileController {

	@Autowired
	private PersonService personService;

	@Autowired
	private FileService fileService;

	@GetMapping("/file_upload")
	public String uploadFile(Map<String, Object> model) {
		return "file_upload";
	}

	@GetMapping("/file_download")
	public String downloadFile(Map<String, Object> model) {
		return "file_download";
	}

	@PostMapping("/do_upload")
	public String doUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fileService.doUpload(request, response);
		return "file_result";
	}

	@GetMapping("/do_download")
	public String doDownload(HttpServletRequest request, HttpServletResponse response) throws IOException {
		fileService.doDownload(request, response);
		return "file_result";
	}
}
