package com.eduard.cruddemo.dao;

import com.eduard.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //Define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    public StudentDAOImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student aStudent) {
        this.entityManager.persist(aStudent);
    }

    @Override
    public Student findById(Integer id){
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll(){
        //create query
        TypedQuery<Student> newQuery = this.entityManager.createQuery("FROM Student", Student.class);

        //return query results
        return newQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String LastName) {
        //create query
        //JPQL named parameters are fixed with a colon:
        //Mainly used as placeholders to be filled in later
        TypedQuery<Student> newQuery = this.entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        //set query parameters
        newQuery.setParameter("theData",LastName);

        //return query results
        return newQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //create new student entity based on received ID
        Student theStudent = this.entityManager.find(Student.class, id);
        //create query
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll(){
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
