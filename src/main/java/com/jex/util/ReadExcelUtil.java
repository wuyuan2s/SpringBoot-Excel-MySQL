package com.jex.util;

import com.jex.model.Student;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ReadExcelUtil {
    public static List<Student> readExcelContentz(MultipartFile file) throws Exception {
        List<Student> content = new ArrayList<>();
        Map<String,Integer> map = new HashMap();
        // 上传文件名
        Workbook wb = getWb(file);
        if (wb == null) {
            throw new Exception("Workbook对象为空！");
        }
        Sheet sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        System.out.println("rowNum:" + rowNum);
        Row row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        colNum = colNum - 1;
        System.out.println("colNum:" +colNum);



        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 2; i <= rowNum; i++) {
            Student m = new Student();
            row = sheet.getRow( i);// 拿到当前 行
            for (int j = 0; j < colNum ; j++) {
             // 解析当前行的列
                if(j == 0){
//                    m.setName(row.getCell(j).toString());
                    m.setId(row.getCell(j).toString());
                }else if(j == 1){
                    m.setSno(row.getCell(j).toString());
//                    m.set(row.getCell(j).toString());
                }else if(j == 2){
                    m.setName(row.getCell(j).toString());
                }else if(j == 3){
                    m.setGrade(row.getCell(j).toString());
                }
                else {
                    m.setComment(row.getCell(j).toString());
                }
            }
            content.add(m);
        }
        return content;
    }
    /**
     * 功能描述: str 等于空
     * @date
     * @Param [str]
     * @return boolean
     */
    public static boolean isEmpty(String str){
        return (str==null || "".equals(str) || (str.trim().length() == 0));
    }


    /**
     * 功能描述: str 不等于空
     * @date
     * @Param [str]
     * @return boolean
     */
    public static boolean isNotEmpty(String str){
        return (str!=null && !str.equals(""));
    }

    private static Workbook getWb(MultipartFile mf) {
        String filepath = mf.getOriginalFilename();
        String ext = filepath.substring(filepath.lastIndexOf("."));
        Workbook wb = null;
        try {
            InputStream is = mf.getInputStream();
            if (".xls".equals(ext)) {
                wb = new HSSFWorkbook(is);
            } else if (".xlsx".equals(ext)) {
                wb = new XSSFWorkbook(is);
            } else {
                wb = null;
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        }
        return wb;
    }
}
