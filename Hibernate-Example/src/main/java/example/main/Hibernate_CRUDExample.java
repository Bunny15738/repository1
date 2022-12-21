package example.main;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import example.entity.Course;

public class Hibernate_CRUDExample {
	private static void create() {
		Configuration conf=new Configuration();//Looks for hibernate.properties
		//This conf will upgrade
		conf=conf.configure();//looks for hibernate.cfg.xml
		//Building sessionFactory
		SessionFactory factory=conf.buildSessionFactory();
		//Building session
		Session session=factory.openSession();
		
		//Building a transaction
		Transaction tx=session.beginTransaction();//Here transaction starts
		Course crs=new Course("C","C Prog",5,2000);
		Course crs1=new Course("C++","C++ Prog",8,4000);
		
		session.save(crs);//This results into DMl INSERT//Persistence State
		session.save(crs1);
		tx.commit();//THis will commit transaction
		session.close();//Closing Session
		factory.close();//Closing SessionFactory
		System.out.println("Course Created Successfully");
		
	}
	
	private static void select() {
		//FOr selecting record no Transaction required
		//It is done by sessions load() method
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		//Building session
		Session session=factory.openSession();
		Class<Course> ctype=Course.class;
		Serializable course="HB";
		Course foundCourse =session.load(ctype, course);
		System.out.println("Course Found:"+foundCourse);
		//select * from course_master where course_id="HB"
		session.close();
		factory.close();
		
	}
	
	private static void update() {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		//Building session
		Session session=factory.openSession();
		Class<Course> ctype=Course.class;
		Serializable course="HB";
		Course foundCourse =session.load(ctype, course);
		Transaction tx=session.beginTransaction();
		//Making some changes in course
		foundCourse.setName("LiberNate");
		foundCourse.setFees(7000);
		tx.commit();//THis will reflect changes to database
		session.close();
		factory.close();
	}
//	private static void showall() {
//		SessionFactory factory=new Configuration().configure().buildSessionFactory();
//		Session session=factory.openSession();
//		List<Course> lst= session.createQuery("select a.courseId,a.name from Course a").getResultList();
//		for(Course cs:lst) {
//			System.out.println(cs);
//		}
//	}
	
	private static void delete() {
		//Load courseId and then delete
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		//Building session
		Session session=factory.openSession();
		Class<Course> ctype=Course.class;
		Serializable course="C";
		Course foundCourse =session.load(ctype, course);
		Transaction tx=session.beginTransaction();
		//Deleting entity that has been loaded
		session.delete(foundCourse);
		tx.commit();
		session.close();
		factory.close();
	}

	private static void retrieveAgain() {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		//Building session
		Session session=factory.openSession();
		Class<Course> ctype=Course.class;
		Serializable course="C++";
		Course foundCourse =session.load(ctype, course);
		String csId=foundCourse.getCourseId();
		System.out.println("Course ID:"+csId);
		System.out.println("Course ID:"+csId);
		System.out.println("Course ID:"+csId);
		System.out.println("Course ID:"+csId);
		System.out.println("Course Name:"+foundCourse.getName());
	}
	
	private static void retrieveOnceAgain() {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		//Building session
		Session session=factory.openSession();
		Class<Course> ctype=Course.class;
		Serializable course="C++";
		Course foundCourse =session.load(ctype, course);
		System.out.println("Actual Class Name:"+foundCourse.getClass().getName());
	}

	public static void main(String[] args) {
		//create();
		select();
		//update();
		//delete();
		retrieveAgain();
		retrieveOnceAgain();
		//showall();

	}

}
