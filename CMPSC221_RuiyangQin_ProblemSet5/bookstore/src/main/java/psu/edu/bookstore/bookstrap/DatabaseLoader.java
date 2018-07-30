package psu.edu.bookstore.bookstrap;

import psu.edu.bookstore.model.bookFile.DateTime;
import psu.edu.bookstore.repository.ApplicationUserRepository;
import psu.edu.bookstore.repository.bookstoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private ApplicationUserRepository bookstoreUserRepository;

    @Autowired
    private bookstoreRepository bookstoreRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){

        bookstoreUserRepository.addUser(1L,"rxq5031","abcdQRY#5741",Boolean.FALSE);
        bookstoreUserRepository.addUser(2L, "user", "1234", Boolean.FALSE);
        bookstoreUserRepository.addUser(3L, "mark", "zuckerberg", Boolean.FALSE);
        bookstoreUserRepository.addUser(4L,"admin","12345",Boolean.TRUE);

        DateTime a1 = new DateTime(10,1,1993);
        bookstoreRepository.addBook(13246L,"The Giver", 1385732554L, "Lois Lowry", a1, "fiction",6.99);
        DateTime a2 = new DateTime(8,17,1945);
        bookstoreRepository.addBook(14267L ,"Animal Farm", 1943138427L, "George Orwell", a2, "fiction",7.83);
    }
}
