package com.jex.service;

import com.baomidou.mybatisplus.service.IService;
import com.jex.model.Student;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface StudentExcelService extends IService<Student> {
    int readExcel(MultipartFile file);

    void exportExcel(HttpServletResponse response);

}
