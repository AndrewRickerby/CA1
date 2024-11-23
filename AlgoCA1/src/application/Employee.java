/*
* AlgoCA1 :
* Andrew Rickerby :
* C23344333 :
* Description of class :
*/


package application;

public class Employee {
    private String name;
    private String code;
    private String course;

    public Employee() {
        this.name = "";
        this.code = "";
        this.course = "";
    }

    public Employee(String name, String code, String course) {
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
