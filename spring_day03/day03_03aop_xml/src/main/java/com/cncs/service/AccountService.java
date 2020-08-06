package com.cncs.service;

public interface AccountService {

    void save();

    void update(int money);

    boolean delete();

    String find(int id);
}
