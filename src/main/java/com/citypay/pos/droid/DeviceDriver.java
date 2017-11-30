package com.citypay.pos.droid;

public class DeviceDriver {

    private final String name;
    private final ConnectionType connectionType;

    public DeviceDriver(String name, ConnectionType connectionType) {
        this.name = name;
        this.connectionType = connectionType;
    }

    public String getName() {
        return name;
    }

    public ConnectionType getConnectionType() {
        return connectionType;
    }
}
