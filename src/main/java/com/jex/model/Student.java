package com.jex.model;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *  *
 * @author Jex
 * @since 2020-01-08
 */
@Data
@TableName("tb_student")
public class Student implements Serializable {

    private static final long serialVersionUID = 3830224111111558537L;

    private String id;
    private String sno;
    private String name;
    private String grade;
    private String comment;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
