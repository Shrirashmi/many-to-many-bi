package com.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Course;
import com.ty.manytomany.dto.Student;

public class TestSaveStudentCourse {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student student1 = new Student();
		student1.setName("ram");
		student1.setAge(17);
		
		Student student2 = new Student();
		student2.setName("mahi");
		student2.setAge(21);
		
		Student student3 = new Student();
		student3.setName("sahitya");
		student3.setAge(20);
		
		Course course1 = new Course();
		course1.setName("SQL");
		course1.setDuration("1 month");
		
		Course course2 = new Course();
		course2.setName("React");
		course2.setDuration("4 months");
		
		
		List<Student> students1 = new ArrayList();
		students1.add(student1);
		students1.add(student2);
		students1.add(student3);
		
		List<Student> students2 = new ArrayList();
		students2.add(student2);
		students2.add(student3);
		
		
		List<Student> students3 = new ArrayList();
		students3.add(student1);
		students3.add(student3);
		
		course1.setStudents(students1);
		course2.setStudents(students2);
		
		List<Course> courses1 = new ArrayList<Course>();
		courses1.add(course1);
		courses1.add(course2);
		
		student1.setCourses(courses1);
		
		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityTransaction.commit();
		}
}
