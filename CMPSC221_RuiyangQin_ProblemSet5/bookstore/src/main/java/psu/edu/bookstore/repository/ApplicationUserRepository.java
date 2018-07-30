package psu.edu.bookstore.repository;

import psu.edu.bookstore.model.bookstoreUser;

public interface ApplicationUserRepository {

    bookstoreUser findUserByUserName(String username);
    bookstoreUser addUser(Long id, String username, String password, Boolean admin);

}
