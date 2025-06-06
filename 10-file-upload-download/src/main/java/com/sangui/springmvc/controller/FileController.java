package com.sangui.springmvc.controller;


import jakarta.servlet.ServletConnection;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.util.UUID;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-06
 * @Description:
 * @Version: 1.0
 */
@Controller
public class FileController {
    // 文件上传
    @RequestMapping(value = "/fileup",method = RequestMethod.POST)
    public String fileupMethod(@RequestParam("fileName") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        // 获取文件真实名字，带后缀
        String originalFilename = multipartFile.getOriginalFilename();
        // 获取文件后缀
        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));

        // 输入流，负责读用户端的文件
        InputStream in = multipartFile.getInputStream();
        // 封装成带有缓存区的输入流
        BufferedInputStream bis = new BufferedInputStream(in);

        // 输出流
        ServletContext application = request.getServletContext();
        String realPath = application.getRealPath(File.separator + "upload");
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        //File destFile = new File(file.getAbsolutePath() + File.separator + originalFilename);
        File destFile = new File(file.getAbsolutePath() + File.separator + UUID.randomUUID() + fileType);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

        // 一边读 一边写
        byte[] bytes = new byte[1024 * 10];
        int readCount = 0;
        while ((readCount = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, readCount);
        }
        bos.flush();
        bos.close();
        bis.close();

        return "ok";
    }

    // 文件下载
    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadFile(HttpServletResponse response, HttpServletRequest request) throws IOException {
        File file = new File(request.getServletContext().getRealPath("/upload") + "/1.jpeg");
        // 创建响应头对象
        HttpHeaders headers = new HttpHeaders();
        // 设置响应内容类型
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 设置下载文件的名称
        headers.setContentDispositionFormData("attachment", file.getName());

        // 下载文件
        return new ResponseEntity<byte[]>(Files.readAllBytes(file.toPath()), headers, HttpStatus.OK);
    }
}
