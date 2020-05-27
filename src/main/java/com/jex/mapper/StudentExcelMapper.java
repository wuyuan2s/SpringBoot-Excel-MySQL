package com.jex.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jex.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface StudentExcelMapper extends BaseMapper<Student> {
    List<Map> selectExportExcel();
}
