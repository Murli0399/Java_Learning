package usecases;

import javax.persistence.EntityManager;

import model.College;
import model.Student;
import util.EMUtils;

public class InsertData {
	public static void main(String[] args) {
		College college1 = new College();
		college1.setCollageName("SN College");
		college1.setCollageAddress("Khandwa");

		Student stu1 = new Student("Murli", "8462858556", "murli@gmail.com", college1);
		college1.getStudents().add(stu1);
		Student stu2 = new Student("Rahul", "9898758746", "rahul@gmail.com", college1);
		college1.getStudents().add(stu2);
		Student stu3 = new Student("Vikash", "4875487548", "vikash@gmail.com", college1);
		college1.getStudents().add(stu3);
		Student stu4 = new Student("Mohit", "4455858556", "mohit@gmail.com", college1);
		college1.getStudents().add(stu4);

		College college2 = new College();
		college2.setCollageName("Dadaji College");
		college2.setCollageAddress("Indore");

		Student stud1 = new Student("Murli", "8462858556", "murli@gmail.com", college2);
		college2.getStudents().add(stud1);
		Student stud2 = new Student("Rahul", "9898758746", "rahul@gmail.com", college2);
		college2.getStudents().add(stud2);
		Student stud3 = new Student("Vikash", "4875487548", "vikash@gmail.com", college2);
		college2.getStudents().add(stud3);
		Student stud4 = new Student("Mohit", "4455858556", "mohit@gmail.com", college2);
		college2.getStudents().add(stud4);

		EntityManager em = EMUtils.getEntityManager();
		em.getTransaction().begin();
		em.persist(college1);
		em.persist(college2);
		em.getTransaction().commit();
		em.close();
	}
}
