package com.autentia.cursolgtm.externalEntitiesXXE;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mark {

    private String studentName;
    private String studentLastName;
    private float mark;

    public Mark() {

    }

    public Mark(String studentName, String studentLastName, float mark) {
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.mark = mark;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
}
