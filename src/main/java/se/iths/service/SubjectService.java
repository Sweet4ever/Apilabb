package se.iths.service;

import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    public Subject createSubject(Subject subject){
        entityManager.persist(subject);
        return subject;
    }

    public void updateSubject(Subject subject) {
        entityManager.merge(subject);
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
