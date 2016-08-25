package com.floriantoenjes.home.automation.core;

import com.floriantoenjes.home.automation.control.Control;
import com.floriantoenjes.home.automation.control.ControlRepository;
import com.floriantoenjes.home.automation.device.Device;
import com.floriantoenjes.home.automation.device.EquipmentRepository;
import com.floriantoenjes.home.automation.room.Room;
import com.floriantoenjes.home.automation.room.RoomRepository;
import com.floriantoenjes.home.automation.user.User;
import com.floriantoenjes.home.automation.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final RoomRepository rooms;
    private final UserRepository users;

    @Autowired
    public DatabaseLoader(RoomRepository rooms, UserRepository users) {
        this.rooms = rooms;
        this.users = users;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Room room = new Room("Kitchen", 125);

        Device thermostat = new Device("Thermostat");

        Control control = new Control("currentTemperature", 68);

        Control control2 = new Control("currentHumidity", 95);

        thermostat.addControl(control);
        thermostat.addControl(control2);
        room.addDevice(thermostat);

        rooms.save(room);

        User user = new User("Florian", "Tönjes", "ftoenjes", "password", new String[]{"ROLE_USER", "ROLE_ADMIN"});
        User user2 = new User("Kein", "Admin", "noadmin", "password", new String[]{"ROLE_USER"});

        users.save(user);
        users.save(user2);
    }
}
