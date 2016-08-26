package com.floriantoenjes.home.automation.control;

import com.floriantoenjes.home.automation.core.BaseEntity;
import com.floriantoenjes.home.automation.device.Device;
import com.floriantoenjes.home.automation.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Control extends BaseEntity{
    private String name;
    Integer value;
    @ManyToOne
    private Device device;
    @ManyToOne
    private User lastModifiedBy;

    protected Control() {
        super();
    }

    public Control(String name, Integer value, User lastModifiedBy) {
        this();
        this.name = name;
        this.value = value;
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}