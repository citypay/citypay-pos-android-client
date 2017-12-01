package com.citypay.pos.droid;

import java.io.Serializable;

/**
 * Defines a device for use in the pos Api
 */
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private DeviceDriver driver;
    private String address;
    private long lastSaved;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConnectionType getConnectionType() {
        return driver.getConnectionType();
    }

    public DeviceDriver getDriver() {
        return driver;
    }

    public void setDriver(DeviceDriver driver) {
        this.driver = driver;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getLastSaved() {
        return lastSaved;
    }

    public void setLastSaved(long lastSaved) {
        this.lastSaved = lastSaved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        if (!name.equals(device.name)) return false;
        if (!driver.equals(device.driver)) return false;
        return address.equals(device.address);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + driver.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
