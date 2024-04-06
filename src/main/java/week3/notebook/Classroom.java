package week3.notebook;
//学生成绩的数据结构
//表达一个班级的很多学生的很多门课的成绩
//1.通过学生的姓名，可以找到他所有的成绩，而每一门课的成绩，由课程名称和分数构成。
//2.找出某一门课的全部学生的成绩

import java.util.HashMap;

//Classroom类表示一个班级，维护一个学生姓名和学生对象的映射
public class Classroom {
    private HashMap<String,Student> students;
    public Classroom() {
        students = new HashMap<>();
    }
    public void addStudent(String name) {
        students.put(name, new Student(name));
    }
    public void addGrade(String name,String course,double score){
        if(students.get(name)!=null){
            students.get(name).addGrade(course,score);
        }
    }
    public double getGrade(String name,String course){
        if(students.get(name)!=null){
            return students.get(name).getGrade(course);
        }
        return 0;
    }
    public HashMap<String,Double> getGrades(String name){
        if(students.get(name)!=null){
            return students.get(name).getGrades();
        }
        return new HashMap<>();
    }
    public HashMap<String,Double> getCourseGrades(String course){
        HashMap<String,Double> courseGrades = new HashMap<String,Double>();
        for(String name : students.keySet()){
            Student student = students.get(name);
            Double grade = student.getGrade(course);
            if(grade!=0.0){
                courseGrades.put(name, grade);
            }
        }
        return courseGrades;
    }

    public static void main(String[] args) {
        Classroom classroom = new Classroom();
        classroom.addStudent("John");
        classroom.addStudent("Jane");
        classroom.addStudent("Jack");
        classroom.addGrade("John","历史",78.2);
        classroom.addGrade("John","数学",88.2);
        classroom.addGrade("Jane","历史",99);
        classroom.addGrade("Jane","数学",99);
        classroom.addGrade("Jack","历史",99);
        System.out.println(classroom.getGrade("John","历史"));
        System.out.println(classroom.getGrades("John"));
        HashMap<String,Double> courseGrades1 = classroom.getCourseGrades("数学");
        System.out.println(courseGrades1);
    }
}
//Student类表示一个学生，每个学生有一个姓名和一组课程成绩（课程名称：成绩）
class Student{
    private String name;
    private HashMap<String,Double> grades;//课程名称：成绩
    public Student(String name){
        this.name = name;
        this.grades = new HashMap<>();
    }
    public String getName() {
        return name;
    }
    public void addGrade(String name, double score){
        grades.put(name, score);
    }
    public double getGrade(String course){
        if(grades.containsKey(course)){
            return grades.get(course);
        }
        return 0;
    }
    public HashMap<String,Double> getGrades() {
        return grades;
    }
}
