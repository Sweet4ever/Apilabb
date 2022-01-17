package se.iths.entity;


import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String email;
    private String phoneNumber = "None";
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Subject> subjects = new ArrayList<>();

    public Student(String firstName, String lastName, String email, List<Subject> subjects){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.subjects = subjects;
    }
    public Student(){}

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
        subject.getStudents().add(this);
    }

    public List<Subject> getSubjects(){
        return subjects;
    }

    public void setSubjects(List<Subject> subjects){
        this.subjects = subjects;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

