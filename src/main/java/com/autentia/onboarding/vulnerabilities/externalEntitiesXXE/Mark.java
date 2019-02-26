package com.autentia.onboarding.vulnerabilities.externalEntitiesXXE;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mark {

    private String studentName;
    private String studentLastName;
    private float mark;

    Mark() {
    }

    public Mark(String studentName, String studentLastName, float mark) {
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.mark = mark;
    }

    public String getStudentName() {
        return studentName;
    }

    void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    String getStudentLastName() {
        return studentLastName;
    }

    void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public float getMark() {
        return mark;
    }

    void setMark(float mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "studentName='" + studentName + '\'' +
                ", studentLastName='" + studentLastName + '\'' +
                ", mark=" + mark +
                '}';
    }
}
