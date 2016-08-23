package com.floriantoenjes.home.automation.core;

import com.floriantoenjes.home.automation.control.Control;
import com.floriantoenjes.home.automation.equipment.Equipment;
import com.floriantoenjes.home.automation.room.Room;
import com.floriantoenjes.home.automation.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final RoomRepository rooms;

    @Autowired
    public DatabaseLoader(RoomRepository rooms) {
        this.rooms = rooms;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Room room = new Room("Kitchen", 125);
        Equipment thermostat = new Equipment("Thermostat");
        thermostat.addControl(new Control("currentTemperature", 68.0));
        room.addEquipment(thermostat);
        rooms.save(room);
    }
}
