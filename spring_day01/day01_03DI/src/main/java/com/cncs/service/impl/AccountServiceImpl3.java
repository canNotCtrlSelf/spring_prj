package com.cncs.service.impl;

import com.cncs.service.AccountService;

import java.util.*;

public class AccountServiceImpl3 implements AccountService {
    private String[] myStrs;
    private List<String> myList;
    private Map<String,String> myMap;
    private Set<Integer> mySet;
    private Properties myProperties;

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMySet(Set<Integer> mySet) {
        this.mySet = mySet;
    }

    public void setMyProperties(Properties myProperties) {
        this.myProperties = myProperties;
    }

    @Override
    public void save() {
        System.out.println(Arrays.toString(myStrs));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProperties);
    }
}
