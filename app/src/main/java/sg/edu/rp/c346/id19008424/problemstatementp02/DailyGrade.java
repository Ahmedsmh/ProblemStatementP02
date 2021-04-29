package sg.edu.rp.c346.id19008424.problemstatementp02;

import java.io.Serializable;

public class DailyGrade implements Serializable {
    private String grade;

    public DailyGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
