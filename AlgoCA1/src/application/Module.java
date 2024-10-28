package application;

public class Module {
    private String name;
    private String code;
    private String course;

    public Module() {
        this.name = "";
        this.code = "";
        this.course = "";
    }

    public Module(String name, String code, String course) {
        this.name = name;
        this.code = code;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "name: " + name + "\n" +
               "emplyee code: " + code + "\n" +
               "course: " + course;
    }
}
