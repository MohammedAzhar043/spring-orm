package com.spring.jdbc.SpringOrm.Dao;

import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jdbc.SpringOrm.entities.Student;

public class StudentDao {

	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public int insert(Student student) {

		Integer i = (Integer) this.template.save(student);
		return i;
	}

	// get the single data
	public Student getStudent(int studentId) {

		Student student = this.template.get(Student.class, studentId);
		return student;
	}

	// getting all the details of the students
	public List<Student> getAllStudent() {

		List<Student> students = this.template.loadAll(Student.class);
		return students;
	}

	// deleting the student
	@Transactional
	public void delete(int studentId) {

		Student student = this.template.get(Student.class, studentId);
		this.template.delete(student);
	}

	@Transactional
	public void update(Student student) {

		this.template.update(student);
	}
}
