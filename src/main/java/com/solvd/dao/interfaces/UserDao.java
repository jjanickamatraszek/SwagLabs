package com.solvd.dao.interfaces;

import com.solvd.model.Order;
import com.solvd.model.User;

import java.util.List;

public interface UserDao {
    User getById(int id);
}
