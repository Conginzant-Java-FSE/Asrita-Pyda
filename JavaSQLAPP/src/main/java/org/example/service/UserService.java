package org.example.service;
import org.example.dao.UserDao;
import org.example.model.UserModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserService {

    private UserDao userDao;
    private BCryptPasswordEncoder encoder;

    public UserService(){
        this.userDao=new UserDao();
        this.encoder=new BCryptPasswordEncoder();
    }
    public UserModel login(String userName, String password){
        UserModel user =userDao.findByUserName(userName);
        if (user==null){
            return null;
        }
        if(!"ACTIVE".equalsIgnoreCase(user.getStatus())){
            return null;
        }
        boolean passwordMatch = encoder.matches(
                password, user.getPassword());
        if (passwordMatch){
            return user;
        }
        return null;
    }
    public boolean register(UserModel user, String rawPassword) {
        if (rawPassword == null || rawPassword.isEmpty()) return false;
        String hashedPassword = encoder.encode(rawPassword);
        user.setPassword(hashedPassword);
        user.setStatus("ACTIVE");
        return userDao.save(user);
    }

}
