package com.example.midterm.dbcontext;
import com.example.midterm.dao.UserDao;
import com.example.midterm.entity.User;

/**
 *
 * @author Ly Quynh Tran
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UserDao dao = new UserDao();
        Boolean check = dao.login(new User("admin", "abc123"));
        System.out.println(""+check);
        check=dao.registerUser(new User("D", "Nguyen","d@email.com","dadmin","abc123"));
        System.out.println("Insert: "+check);
    }

}
