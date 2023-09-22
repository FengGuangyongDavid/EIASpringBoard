package com.spring.board.eia.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface FileService {
    void doUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    void doDownload(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
