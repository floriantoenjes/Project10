package com.floriantoenjes.home.automation.control;

import com.floriantoenjes.home.automation.user.User;
import com.floriantoenjes.home.automation.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Control.class)
public class ControlEventHandler {
    private UserRepository users;

    @Autowired
    public ControlEventHandler(UserRepository users) {
        this.users = users;
    }

    @HandleBeforeCreate
    public void addAdminBasedOnLoggedInUser(Control control) {
        User user = getUser();
        control.setLastModifiedBy(user);
    }

    private User getUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return users.findByName(username);
    }

    @HandleBeforeSave
    public void addLastModifiedAsLoggedInUser(Control control) {
        User user = getUser();
        control.setLastModifiedBy(user);
    }


}
