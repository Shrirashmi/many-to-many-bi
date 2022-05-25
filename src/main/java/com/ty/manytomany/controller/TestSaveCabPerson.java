package com.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Cab;
import com.ty.manytomany.dto.Person;

public class TestSaveCabPerson {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Cab cab1 = new Cab();
		cab1.setDriverName("Arun");
		cab1.setCost(210);
		
		Cab cab2 = new Cab();
		cab2.setDriverName("Bhavith");
		cab2.setCost(110);
		
		Cab cab3 = new Cab();
		cab3.setDriverName("Harish");
		cab3.setCost(160);
		
		List<Cab> cabs1 = new ArrayList<Cab>();
		cabs1.add(cab1);
		cabs1.add(cab2);
		
		List<Cab> cabs2 = new ArrayList<Cab>();
		cabs2.add(cab2);
		cabs2.add(cab3);
		
		List<Cab> cabs3 = new ArrayList<Cab>();
		cabs3.add(cab1);
		cabs3.add(cab2);
		cabs3.add(cab3);
		
		Person person1 = new Person();
		person1.setName("simran");
		person1.setAge(24);
		
		Person person2 = new Person();
		person2.setName("rohit");
		person2.setAge(23);
		
		Person person3 = new Person();
		person3.setName("suhas");
		person3.setAge(24);
		
//		List<Person> persons1 = new ArrayList<Person>();
//		persons1.add(person1);
//		persons1.add(person2);
//		persons1.add(person3);
//		
//		List<Person> persons2 = new ArrayList<Person>();
//		persons2.add(person1);
//		persons2.add(person3);
//		
//		List<Person> persons3 = new ArrayList<Person>();
//		persons3.add(person2);
//		persons3.add(person3);
	
		person1.setCabs(cabs1);
		person2.setCabs(cabs2);
		person3.setCabs(cabs3);
		                                                  /*always assign child to parent else the 3rd table wont have any data*/
//		cab1.setPersons(persons1);
//		cab2.setPersons(persons2);
//		cab3.setPersons(persons3);
		
		entityTransaction.begin();
		entityManager.persist(cab1);
		entityManager.persist(cab2);
		entityManager.persist(cab3);
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityManager.persist(person3);
		entityTransaction.commit();
	}
}
