package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.service.StudentService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    StudentService studentService;

    public Subject createSubject(Subject subject){
        entityManager.persist(subject);
        return subject;
    }

    public void updateSubject(Subject subject) {
        entityManager.merge(subject);
    }

    public Subject addStudentToSubject(Long subjectId, Long studentId) {
        Subject foundSubject = entityManager.find(Subject.class ,subjectId);
        Student foundStudent = entityManager.find(Student.class, studentId);
        foundSubject.addStudent(foundStudent);
        entityManager.persist(foundSubject);
        return foundSubject;
    }

    public List<Subject> getSubjectData(Long id) {
        return entityManager
                .createQuery("SELECT s FROM Subject s WHERE s.id = :id", Subject.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<Subject> getAll(){
        return entityManager.createQuery("SELECT i from Subject i", Subject.class).getResultList();
    }
}
