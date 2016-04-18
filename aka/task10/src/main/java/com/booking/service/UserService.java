package com.booking.service;

import com.booking.bean.User;
import org.springframework.stereotype.Service;

/**
 * Created by TheFa on 17.04.16.
 */
@Service
public class UserService {

    public User createUser(final String firstName, final String lastName) {
        return new User(firstName, lastName);
    }
}
