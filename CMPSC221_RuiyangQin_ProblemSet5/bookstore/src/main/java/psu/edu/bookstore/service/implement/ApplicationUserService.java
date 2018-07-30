package psu.edu.bookstore.service.implement;

import psu.edu.bookstore.model.bookstoreUser;

public interface ApplicationUserService {
    bookstoreUser findUserByUsername(String username);
}
