package com.floriantoenjes.home.automation.room;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.floriantoenjes.home.automation.core.BaseEntity;
import com.floriantoenjes.home.automation.device.Device;
import com.floriantoenjes.home.automation.user.User;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room extends BaseEntity{
    private String name;

    @Range(min = 0, max = 1000, message = "Cannot be higher than 1000")
    private Integer area;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Device> devices;
    @JsonIgnore
    @ManyToMany
    private List<User> administrators;

    protected Room() {
        super();
        devices = new ArrayList<>();
        administrators = new ArrayList<>();
    }

    public Room(String name, Integer area) {
        this();
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void addDevice(Device device) {
        device.setRoom(this);
        devices.add(device);
    }

    public List<User> getAdministrators() {
        return administrators;
    }

    public void addAdministrator(User administrator) {
        administrators.add(administrator);
    }
}
