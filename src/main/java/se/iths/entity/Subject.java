package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String name;
    @ManyToMany(mappedBy = "subjects", cascade = CascadeType.MERGE)
    private List<Student> students = new ArrayList<>();
    @ManyToOne
    private Teacher teacher;

    public Subject(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.getSubjects().add(this);
    }

    public Subject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
