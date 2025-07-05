package com.project.CarRentalApplication.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
@Component
public class UserList {
    @Autowired
    UserDetails userDetails;
    private List<UserDetails> users = new ArrayList<>();
    public void adduser(UserDetails userDetails) {
        users.add(userDetails);
    }

    public List<UserDetails> getAllUsers()
    {
        return users;
    }

    public UserDetails getUser(String userId)
    {
        for(UserDetails user : users)
        {
            if(user.getUserId().equals(userId))
            {
                return user;
            }
        }

        return null;
    }
    public Boolean deleteUser(String userId){

        Boolean found = Boolean.FALSE;
        List<UserDetails> userDummyList = new ArrayList<>();
        userDummyList.addAll(users);
        for(UserDetails user: userDummyList)
        {
            if(user.getUserId().equals(userId))
            {
                users.remove(user);
                found = Boolean.TRUE;
            }
        }

        return found;
    }

    public void updateUser(String userId, UserDetails user)
    {
//        List<UserDetails> dummyUsers = new ArrayList<>(users);
        for(UserDetails user1 : users)
        {
            if(user1.getUserId().equals(user.getUserId()))
            {
                user1.setUserFullName(user.getUserFullName());
                user1.setEmailId(user.getEmailId());
                user1.setDrivingLiscence(user.getDrivingLiscence());
            }
        }
    }


}
