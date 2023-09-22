package com.spring.board.eia.controller;
import com.google.common.collect.Lists;
import com.spring.board.eia.entity.File;
import com.spring.board.eia.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import static com.spring.board.eia.EIAConstant.*;

@Controller
public class FileController {
	@Autowired
	private FileService fileService;

	@GetMapping("/file_list")
	public String downloadFile(Map<String, Object> model) throws IOException {
		Path personFile = Paths.get(PERSON_DOWNLOAD_PATH);
		BasicFileAttributes personFileAttr = Files.readAttributes(personFile, BasicFileAttributes.class);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		File file1 = new File(PERSON_FILE_NAME, "PERSON","Full info of all persons", df.format(personFileAttr.creationTime().toMillis()));

		Path orgFile = Paths.get(ORG_DOWNLOAD_PATH);
		BasicFileAttributes orgFileAttr = Files.readAttributes(orgFile, BasicFileAttributes.class);
		File file2 = new File(ORG_FILE_NAME, "ORGANIZATION","Full info of all organizations", df.format(orgFileAttr.creationTime().toMillis()));

		List<File> fileList = Lists.newArrayList(file1, file2);
		model.put("fileList",fileList);
		return "file_list";
	}

	@GetMapping("/generate_file")
	public String generateFile(Map<String, Object> model) throws IOException {
		fileService.generateFile();
		return downloadFile(model);
	}

	@PostMapping("/do_upload")
	public String doUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fileService.doUpload(request, response);
		return "file_result";
	}

	@GetMapping("/do_download*")
	public String doDownload(@RequestParam("name") String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
		fileService.doDownload(fileName, request, response);
		return "file_result";
	}
}
