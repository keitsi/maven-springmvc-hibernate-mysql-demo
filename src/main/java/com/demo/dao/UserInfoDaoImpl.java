package com.demo.dao;

/**
 * Created by keitsi on 16-10-21.
 */

import com.demo.entity.UserInfoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public void add(UserInfoEntity user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("Person saved successfully, Person Details=" + user);
    }

    public void update(UserInfoEntity user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("Person updated successfully, Person Details=" + user);
    }

    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserInfoEntity user = (UserInfoEntity) session.load(UserInfoEntity.class, new Integer(id));
        if (null != user) {
            session.delete(user);
        }
        logger.info("Person deleted successfully, person details=" + user);
    }

    @SuppressWarnings("unchecked")
    public List<UserInfoEntity> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserInfoEntity> userList = session.createQuery("from UserInfoEntity ").list();
        for (UserInfoEntity user : userList) {
            logger.info("Person List::" + user);
        }
        return userList;
    }

    public UserInfoEntity getById(int id)
    {
        Session session = this.sessionFactory.getCurrentSession();
        UserInfoEntity user = (UserInfoEntity) session.load(UserInfoEntity.class, new Integer(id));
        logger.info("Person loaded successfully, Person details=" + user);
        return user;
    }

    public UserInfoEntity getByName(String name){
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from UserInfoEntity where userName = :userName ");
        query.setParameter("userName", name);
        List list = query.list();
        if (list.size()>0){
            return (UserInfoEntity) list.get(0);
        }else {
            return null;
        }
    }

}