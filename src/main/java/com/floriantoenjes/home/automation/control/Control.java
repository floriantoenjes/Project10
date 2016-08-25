package com.floriantoenjes.home.automation.control;

import com.floriantoenjes.home.automation.core.BaseEntity;
import com.floriantoenjes.home.automation.device.Device;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Control extends BaseEntity{
    private String controlName;
    Integer value;
    @ManyToOne
    private Device device;

    protected Control() {
        super();
    }

    public Control(String controlName, Integer value) {
        this();
        this.controlName = controlName;
        this.value = value;
    }

    public String getControlName() {
        return controlName;
    }

    public void setControlName(String controlName) {
        this.controlName = controlName;
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
}