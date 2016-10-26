package com.demo.service;

/**
 * Created by keitsi on 16-10-21.
 */

import com.demo.dao.UserInfoDao;
import com.demo.entity.UserInfoEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private UserInfoDao userInfoDao;

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    @Transactional
    public void add(UserInfoEntity user) {
        this.userInfoDao.add(user);
    }

    @Transactional
    public void update(UserInfoEntity user) {
        this.userInfoDao.update(user);
    }

    @Transactional
    public void remove(int id) {
        this.userInfoDao.remove(id);
    }

    @Transactional
    public List<UserInfoEntity> getAll() {
        return this.userInfoDao.getAll();
    }

    @Transactional
    public UserInfoEntity getById(int id) {
        return this.userInfoDao.getById(id);
    }

    @Transactional
    public UserInfoEntity getByName(String name)
    {
        return this.userInfoDao.getByName(name);
    }

}