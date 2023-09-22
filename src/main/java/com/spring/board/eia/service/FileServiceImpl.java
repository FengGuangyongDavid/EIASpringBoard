package com.spring.board.eia.service;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class FileServiceImpl implements FileService{
    @Override
    public void doUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<FileItem> fileItems = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            for (FileItem fileItem : fileItems) {
                if (!fileItem.isFormField()) {
                    String name = new File(fileItem.getName()).getName();
                    fileItem.write(new File("c:/eia/upload" + File.separator + name));
                }
            }
            request.setAttribute("eia_message", "File uploaded successfully");
        } catch (Exception ex) {
            request.setAttribute("eia_message", "File upload failed due to " + ex);
        }
    }

    @Override
    public void doDownload(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String file = "test.txt";
        String path = "c:/eia/download/";
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + file + "\"");
        FileInputStream fileInputStream = new FileInputStream(path + file);

        int i;
        while ((i = fileInputStream.read()) != -1) {
            out.write(i);
        }
        fileInputStream.close();
        out.close();
    }
}
