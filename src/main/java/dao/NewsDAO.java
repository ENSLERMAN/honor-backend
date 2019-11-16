package dao;
import com.honor.back.honorwebapp.HibernateSessionFactory;
import com.honor.back.honorwebapp.News;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("newsDao")
public class NewsDAO implements DAOSkeleton {
    @Override
    public void update(Object updatedObject) {

    }

    @Override
    public void save(Object savedObject) {

    }

    @Override
    public News get(int id) {
        Session session= HibernateSessionFactory.getSession().openSession();
        session.beginTransaction();
        News news=session.get(News.class,id);
        session.getTransaction().commit();
        session.close();
        return news;
    }

    @Override
    public void delete(Object updatedObject) {

    }

    @Override
    public List<News> getAll() {
        Session session=HibernateSessionFactory.getSession().openSession();
        session.beginTransaction();
        List<News> allNews = session.createQuery("From News",News.class).list();
        session.getTransaction().commit();
        session.close();
        return allNews;
    }
}