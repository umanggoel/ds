package design.splitwise.user;

import design.splitwise.exception.DuplicateUserException;
import design.splitwise.exception.UserNotFoundException;
import design.splitwise.model.users.User;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {
    Map<Integer, User> userMap;

    public UserManager() {
        this.userMap = new HashMap<>();
    }

    public void addUser(User user) throws DuplicateUserException {
        if(userMap.containsKey(user.getId())){
            throw new DuplicateUserException();
        }
        userMap.put(user.getId(), user);
    }

    public void deleteUser(Integer userId) throws UserNotFoundException {
        if(!userMap.containsKey(userId)){
            throw new UserNotFoundException();
        }
        userMap.remove(userId);
    }

    public List<User> getAllUsers(){
        return (List<User>) userMap.values();
    }
}
