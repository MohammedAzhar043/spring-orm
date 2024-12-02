package com.spring.jdbc.SpringOrm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.SpringOrm.Dao.StudentDao;
import com.spring.jdbc.SpringOrm.entities.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		/*
		 * Student s = new Student(2, "Mohammed Azam", "mysore"); int count =
		 * studentDao.insert(s);
		 * 
		 * System.out.println("The number of count is : " + count);
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean go = true;
		while (go) {

			System.out.println("Press 1 for add new student");
			System.out.println("Press 2 for display all students");
			System.out.println("Press 3 for details of a single student");
			System.out.println("Press 4 for deleting the student");
			System.out.println("Press 5 for updating the student");
			System.out.println("Press 6 for exit");
			try {

				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
					// adding a new student
					System.out.println("enter the user id");
					int uid = Integer.parseInt(br.readLine());

					System.out.println("enter the user name ");
					String name = br.readLine();

					System.out.println("enter the user city ");
					String city = br.readLine();

					Student s = new Student();
					s.setStudentId(uid);
					s.setStudentName(name);
					s.setStudentCity(city);

					int count = studentDao.insert(s);
					System.out.println("The number of student added " + count);
					System.out.println("********************************************************");
					break;
				case 2:
					// displaying all the details of all the students
					System.out.println("***********************************");
					List<Student> allStudent = studentDao.getAllStudent();

					for (Student stu : allStudent) {
						System.out.println("Name : " + stu.getStudentName());
						System.out.println("Id : " + stu.getStudentId());
						System.out.println("City : " + stu.getStudentCity());
						System.out.println("***********************************");
					}
					System.out.println("***********************************");
					break;
				case 3:
					// displaying the single student
					System.out.println("enter the user id");
					int userid = Integer.parseInt(br.readLine());
					Student student = studentDao.getStudent(userid);

					System.out.println("Name : " + student.getStudentName());
					System.out.println("Id : " + student.getStudentId());
					System.out.println("City : " + student.getStudentCity());
					System.out.println("***********************************");

					break;

				case 4:
					// deleting the student
					System.out.println("enter the user id to be deleted");
					int useridDelete = Integer.parseInt(br.readLine());
					studentDao.delete(useridDelete);
					System.out.println("deleted......");
					System.out.println("***********************************");
					break;
				case 5:
					// updating the student

					System.out.println("enter the user id to be updated");
					int useridUpdate = Integer.parseInt(br.readLine());

					System.out.println("enter the user name to be updated");
					String updatedName = br.readLine();

					System.out.println("enter the user city to be updated ");
					String updatedCity = br.readLine();

					Student s1 = new Student();
					s1.setStudentId(useridUpdate);
					s1.setStudentName(updatedName);
					s1.setStudentCity(updatedCity);

					studentDao.update(s1);
					System.out.println("done.....");
					System.out.println("***********************************");
					break;

				case 6:
					// exit
					go = false;
					break;
				default:
					System.out.println("please use a vaild input");

				}

			} catch (Exception e) {
				System.out.println("invalid input! try with another input");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("thank u for using my application...");

	}
}
