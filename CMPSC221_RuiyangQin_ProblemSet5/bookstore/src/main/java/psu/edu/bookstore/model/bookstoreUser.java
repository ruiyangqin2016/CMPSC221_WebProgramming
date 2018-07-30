package psu.edu.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class bookstoreUser {

    protected Long id;
    protected String username;
    protected String password;
    protected Boolean Admin;

}
