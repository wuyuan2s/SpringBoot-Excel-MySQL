package com.jex.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jex.mapper.StudentExcelMapper;
import com.jex.model.Student;
import com.jex.service.StudentExcelService;
import com.jex.util.ExcelUtil;
import com.jex.util.ReadExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SudentExcelServiceImpl extends ServiceImpl<StudentExcelMapper, Student> implements StudentExcelService {
    @Autowired
    StudentExcelMapper importExcelMapper;
    @Override
    @Transactional
    public int readExcel(MultipartFile file) {
        List<Student> list = new ArrayList<Student>();
        int num = 0;
        try{
            list = ReadExcelUtil.readExcelContentz(file);
            System.out.println("读取excel" + list);
            // 小数据量 直接循环插入 数据量大 可以考虑 批量或者 分批批量导入  -- 2020-01-08

            for(Student m : list){
                Integer insert = importExcelMapper.insert(m);
                num += insert;
                System.out.printf("insert");
            }
            System.out.printf("导入数量："+num);
        }catch (Exception e){
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public void exportExcel(HttpServletResponse response) {

        // 定义表头
    String [] tableHeadValue = new String[]{"ID", "学号", "姓名", "班级", "备注"};
    // roles查询结果字段
    String [] tableHeadKey = new String[] {"id", "sno", "name", "grade", "comment"};
    // 定义表数据
    Wrapper<Student> we = new EntityWrapper();
    List<Map> roles = importExcelMapper.selectExportExcel();

        try {
        long lc = System.currentTimeMillis();

        // 大数据量导出

        ExcelUtil.exportBigDataExcel(response, tableHeadKey, tableHeadValue, roles, "软件过滤列表", "xlsx", System.getProperty("user.dir"));
        long l2 = System.currentTimeMillis();

        System.out.println("导出数据时需要多少时间：" + (l2 -lc));
        // .导出1107258条数据。07版excel导出数据时需要时间：30539ms
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
