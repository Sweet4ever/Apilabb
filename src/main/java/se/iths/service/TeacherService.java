package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    public Teacher findTeacherById(Long id){
        return entityManager.find(Teacher.class, id);
    }

    public Teacher createTeacher(Teacher teacher){
        entityManager.persist(teacher);
        return teacher;
    }

    public void updateTeacher(Teacher teacher) {
        entityManager.merge(teacher);
    }

    public List<Teacher> getAll(){
        return entityManager.createQuery("SELECT i from Teacher i", Teacher.class).getResultList();
    }

    public ArrayList getSpecifiedStudentsPerSubjectAndTeacher(Long subjectId, Long teachId){
        Subject subject = entityManager.find(Subject.class, subjectId);
        Teacher teacher = entityManager.find(Teacher.class, teachId);
        List<Student> students = subject.getStudents();

        ArrayList list = new ArrayList();
        list.add(subject);
        list.add(teacher);

        return list;
    }
}
