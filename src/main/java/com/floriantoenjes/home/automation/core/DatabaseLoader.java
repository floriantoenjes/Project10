package com.floriantoenjes.home.automation.core;

import com.floriantoenjes.home.automation.control.Control;
import com.floriantoenjes.home.automation.control.ControlRepository;
import com.floriantoenjes.home.automation.device.Device;
import com.floriantoenjes.home.automation.device.EquipmentRepository;
import com.floriantoenjes.home.automation.room.Room;
import com.floriantoenjes.home.automation.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final ControlRepository controls;
    private final EquipmentRepository equipments;
    private final RoomRepository rooms;

    @Autowired
    public DatabaseLoader(ControlRepository controls, EquipmentRepository equipments, RoomRepository rooms) {
        this.controls = controls;
        this.equipments = equipments;
        this.rooms = rooms;
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
    }
}
