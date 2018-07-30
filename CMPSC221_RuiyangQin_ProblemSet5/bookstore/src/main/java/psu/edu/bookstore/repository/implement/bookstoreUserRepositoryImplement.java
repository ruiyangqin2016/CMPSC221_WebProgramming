package psu.edu.bookstore.repository.implement;

import psu.edu.bookstore.repository.ApplicationUserRepository;
import psu.edu.bookstore.model.bookstoreUser;
import com.google.common.collect.MoreCollectors;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class bookstoreUserRepositoryImplement implements ApplicationUserRepository {

    private List<bookstoreUser> bookstoreUserList = new ArrayList<>();

    @Override
    public bookstoreUser findUserByUserName(String username){
        return bookstoreUserList.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .collect(MoreCollectors.onlyElement());
    }

    @Override
    public bookstoreUser addUser(Long id, String username, String password, Boolean admin){
        bookstoreUser user = new bookstoreUser(id,username,password,admin);
        bookstoreUserList.add(user);
        return user;
    }
}
