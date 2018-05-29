package mysqlConnect.dababasesClass;

public class Tabkes {
    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getCours_id() {
        return course_id;
    }

    public void setCours_id(String cours_id) {
        this.course_id = cours_id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String class_id;
    private String course_id;
    private String teacher_id;
    private String time;
}
