package com.floriantoenjes.home.automation.core;

import com.floriantoenjes.home.automation.control.Control;
import com.floriantoenjes.home.automation.control.ControlRepository;
import com.floriantoenjes.home.automation.equipment.Equipment;
import com.floriantoenjes.home.automation.equipment.EquipmentRepository;
import com.floriantoenjes.home.automation.room.Room;
import com.floriantoenjes.home.automation.room.RoomRepository;
import com.floriantoenjes.home.automation.value.Value;
import com.floriantoenjes.home.automation.value.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final ControlRepository controls;
    private final EquipmentRepository equipments;
    private final RoomRepository rooms;
    private final ValueRepository values;

    @Autowired
    public DatabaseLoader(ControlRepository controls, EquipmentRepository equipments, RoomRepository rooms,
                          ValueRepository values) {
        this.controls = controls;
        this.equipments = equipments;
        this.rooms = rooms;
        this.values = values;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Room room = new Room("Kitchen", 125);

        Equipment thermostat = new Equipment("Thermostat");

        Control control = new Control("currentTemperature");
        control.addValue(new Value(68.0));

        Control control2 = new Control("currentHumidity");
        control2.addValue(new Value(86.5));

        thermostat.addControl(control);
        thermostat.addControl(control2);
        room.addEquipment(thermostat);

        rooms.save(room);
    }
}
