package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
   TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsersCar() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User where car_id !=null");
      return query.getResultList();
   }

   @Override
   public List<User> UserFromModelAndSeriaCar(String modelCar,int SeriesCar){
      Query query =sessionFactory.getCurrentSession().createQuery("from User where car.model = :paramName and car.series = "+SeriesCar+"");
      query.setParameter("paramName",modelCar);
      return query.getResultList();
   }

}
