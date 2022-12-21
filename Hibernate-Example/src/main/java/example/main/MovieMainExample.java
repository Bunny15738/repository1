package example.main;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import example.entity.Movie;
import example.entity.MovieTitleAndyear;
import example.hibernate.utilities.HibernateUtils;

public class MovieMainExample {
	private static void create() {
		SessionFactory factory = HibernateUtils.buildSessionFactory();
		Session session = factory.openSession();
		Movie currentMovie = new Movie("M6", "DDLJ", "Romance", 2002);
		// Movie currentMovie1=new Movie("M3","Mr.India","Fantasy",1999);
		// Movie currentMovie2=new Movie("M4","Border","Inspirational",1997);
		// Movie currentMovie3=new Movie("M5","Teesri Aankh","suspense",1980);
		Transaction tx = session.beginTransaction();
		session.save(currentMovie);
		tx.commit();
		session.close();
		factory.close();
	}

	private static void hqlUsingFromClause() {
		SessionFactory factory = HibernateUtils.buildSessionFactory();
		Session session = factory.openSession();
		// Building Query in HQL
		String hqlQuery = "from Movie m";

		// Obtaining ref of type Query
		Query<Movie> qrMovie = session.createQuery(hqlQuery);
		// Obtaing list of movie object from this query ref
		List<Movie> allMovie = qrMovie.list();
		System.out.println("Printing All Movies:");
		for (Movie currentMovie : allMovie) {
			System.out.println(currentMovie);
		}
		session.close();
		factory.close();
	}

	private static void hqlUsingSelectClause() {
		SessionFactory factory = HibernateUtils.buildSessionFactory();
		Session session = factory.openSession();
		// Building Query in HQL
		String hqlQuery = "select m.title,m.year from Movie m";

		// Obtaining ref of type Query
		// column datatype can be anything so we are not aware of it so take list of
		// object
		Query<Object[]> qrMovie = session.createQuery(hqlQuery);
		List<Object[]> movieList = qrMovie.list();
		System.out.println("Printing selected Data:");
		for (Object[] obj : movieList) {
			System.out.println("Title:" + obj[0] + ", Year:" + obj[1]);
		}
		session.close();
		factory.close();

	}

	private static void hqlUsingConstructorExpr() {
		SessionFactory factory = HibernateUtils.buildSessionFactory();
		Session session = factory.openSession();
		// Building Query in HQL
		String hqlQuery = "select new example.entity.MovieTitleAndyear(m.title,m.year) from Movie m";
		Query<MovieTitleAndyear> qr = session.createQuery(hqlQuery);
		List<MovieTitleAndyear> movData = qr.list();
		for (MovieTitleAndyear movie : movData) {
			System.out.println(movie.getTitle() + " , " + movie.getYear());
		}
		session.close();
		factory.close();

	}

	private static void hqlUsingCriteria() {
		SessionFactory factory = HibernateUtils.buildSessionFactory();
		Session session = factory.openSession();
		// Obtaining ref od type criteria
		Criteria cr = session.createCriteria(Movie.class);
		List<Movie> allmovies = cr.list();
		for (Movie mv : allmovies) {
			System.out.println(mv);
		}
		session.close();
		factory.close();
	}
	
	private static void hqlUsingCriteriaWithRestriction() {
		SessionFactory factory = HibernateUtils.buildSessionFactory();
		Session session = factory.openSession();
		// Obtaining ref od type criteria
		Criteria cr = session.createCriteria(Movie.class);
		//Adding some restriction to fetch those movies between 1969 and 1981
		cr.add(Restrictions.between("year", 1969, 1981));
		List<Movie> allmovies = cr.list();
		for (Movie mv : allmovies) {
			System.out.println(mv);
		}
		session.close();
		factory.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create();
		// hqlUsingFromClause();
		// hqlUsingSelectClause();
		//hqlUsingConstructorExpr();
		hqlUsingCriteria();
		//hqlUsingCriteriaWithRestriction();

	}

}
