package se.iths;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleDataGenerator {
    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void generateData() {
        // Teachers
        var teacher1 = new Teacher("Kalle");
        var teacher2 = new Teacher("Klara");
        // Students
        var student1 = new Student("Joakim", "von Anka", "jva@ankeborg.com");
        var student2 = new Student("Kajsa", "Anka", "kajsa@ankeborg.com");
        var student3 = new Student("Alexander", "Lukas", "a_lukas@ankeborg.com");
        // Subjects
        var subject1 = new Subject("Matte");
        var subject2 = new Subject("Engelska");
        var subject3 = new Subject("Svenska");
        var subject4 = new Subject("Fysik");
        var subject5 = new Subject("Kemi");
        var subject6 = new Subject("Geografi");
        teacher1.addSubject(subject1);
        teacher1.addSubject(subject2);
        teacher1.addSubject(subject3);
        teacher2.addSubject(subject4);
        teacher2.addSubject(subject5);
        teacher2.addSubject(subject6);
        student1.addSubject(subject1);
        student1.addSubject(subject2);
        student1.addSubject(subject6);
        student2.addSubject(subject3);
        student2.addSubject(subject4);
        student2.addSubject(subject5);
        student3.addSubject(subject1);
        student3.addSubject(subject4);
        student3.addSubject(subject6);
        em.persist(teacher1);
        em.persist(teacher2);
        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
    }
}
