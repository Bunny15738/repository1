package example.hibernate.utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import example.entity.Movie;

public class HibernateUtils {
	public static SessionFactory buildSessionFactory() {
		Configuration conf=new Configuration().configure();
		//Registering movie entity with configuration
		Class<Movie> movieType=Movie.class;
		conf.addAnnotatedClass(movieType);
		SessionFactory sf =conf.buildSessionFactory();
		return sf;
	}

}
