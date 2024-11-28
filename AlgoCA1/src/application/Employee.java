/*
* AlgoCA1 :
* Andrew Rickerby :
* C23344333 :
* Description of class :class represents attributes for name, code, course, and years of experience, along with methods to access and modify these details.
*/


package application;

public class Employee {
    private String name;
    private String code;
    private String course;
    private int years;

    public Employee() {
        this.name = "";
        this.code = "";
        this.course = "";
        this.years = 0;
    }

    public Employee(String name, String code, String course, int years) {
        this.name = name;
        this.code = code;
        this.course = course;
        this.years = years;
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
    
    public int getYears() {
        return years;
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

    public void setYears(int years) {
        this.years = years;
    }
    @Override
    public String toString() {
        return "name: " + name + "\n" +
               "emplyee code: " + code + "\n" +
               "course: " + course + "\n" +
        	   "years of experience:" + years;
    }
}
