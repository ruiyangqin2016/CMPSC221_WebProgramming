package psu.edu.bookstore.service.implement;


import psu.edu.bookstore.model.bookstoreUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import psu.edu.bookstore.repository.ApplicationUserRepository;

@Service
public class ApplicationUserServiceImplement implements ApplicationUserService {

    @Autowired
    private ApplicationUserRepository bookstoreUserRepository;

    @Override
    public bookstoreUser findUserByUsername(String username){
        return bookstoreUserRepository.findUserByUserName(username);
    }

}
