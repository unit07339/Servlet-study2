package com.korai.servletstudy2.repository;

import com.korai.servletstudy2.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static UserRepository instance;
    private int lastId;
    private List<User> users;

    private UserRepository() {
        lastId = 1;
        users = new ArrayList<>();
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void insert(User user) {
        user.setId(lastId++);
        users.add(user);
    }

    public User findByUsername(String username) {
//        중복체크
//        for (User user : users) {
//            if (user.getUsername().equals(username)) {
//                return user;
//            }
//        }
//        return null;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return users.get(i);
            }
        }
        return null;
    }

    public User findById(int id) { // equals은 문자열 비교, int는 == 으로 비교

//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getId() == id) {
//                return users.get(i);
//            }
//        }
//        return null;


//        for (User user : users) {
//            if (user.getId() == id) {
//                return user;
//            }
//        }
//        return null;

        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseGet(() -> null);
    }

    public List<User> findAll() {
        return users.stream().map(user -> new User(user)).toList();
    }

}
