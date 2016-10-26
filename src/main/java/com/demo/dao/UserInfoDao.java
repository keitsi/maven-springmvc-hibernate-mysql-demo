package com.demo.dao;

/**
 * Created by keitsi on 16-10-21.
 */

import com.demo.entity.UserInfoEntity;

import java.util.List;

public interface UserInfoDao {

    void add(UserInfoEntity p);

    void update(UserInfoEntity p);

    void remove(int id);

    List<UserInfoEntity> getAll();

    UserInfoEntity getById(int id);

    UserInfoEntity getByName(String name);

}