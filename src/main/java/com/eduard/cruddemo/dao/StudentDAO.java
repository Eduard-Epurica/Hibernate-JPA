package com.eduard.cruddemo.dao;

import com.eduard.cruddemo.entity.Student;

import java.util.List;

//Data access object for interfacing with database
public interface StudentDAO {

    void save(Student aStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String LastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();

}
