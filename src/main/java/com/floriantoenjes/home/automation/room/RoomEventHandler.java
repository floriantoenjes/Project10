package com.floriantoenjes.home.automation.room;

import com.floriantoenjes.home.automation.user.User;
import com.floriantoenjes.home.automation.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Room.class)
public class RoomEventHandler {
    private final UserRepository users;

    @Autowired
    public RoomEventHandler(UserRepository users) {
        this.users = users;
    }

    @HandleBeforeCreate
    public void addAdminBasedOnLoggedInUser(Room room) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByName(username);
        room.addAdministrator(user);
    }
}
