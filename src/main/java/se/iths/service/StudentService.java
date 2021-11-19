package se.iths.service;

import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public Student createStudent(Student student){
        entityManager.persist(student);
        return student;
    }

    public Student findStudentById(Long id){
        return entityManager.find(Student.class, id);
    }

    public List<Student> getAllStudents(){
        return entityManager.createQuery("SELECT i from Student i", Student.class).getResultList();
    }

    public Response deleteStudentById(Long id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
        return Response.ok().build();
    }

    public Student updateFirstName(Long id, String first){
        Student student = entityManager.find(Student.class, id);
        student.setFirstName(first);
        return student;
    }

    public Student updateLastName(Long id, String last){
        Student student = entityManager.find(Student.class, id);
        student.setLastName(last);
        return student;
    }

    public Student updatePhone(Long id, String number){
        Student student = entityManager.find(Student.class, id);
        student.setPhoneNumber(number);
        return student;
    }

    public Student updateEmail(Long id, String mail){
        Student student = entityManager.find(Student.class, id);
        student.setEmail(mail);
        return student;
    }

    public List getStudentByLastName(String lastName) {
        Query query = entityManager.createQuery("SELECT i from Student i where i.lastName = :lastName");
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }
}
