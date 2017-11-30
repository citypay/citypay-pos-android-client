package com.citypay.pos.droid;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Contains a registry of {@link DeviceDriver}s that are configured within the API
 */
public class DeviceDriverRegistry {

    private static Map<String, DeviceDriver> map = new HashMap<>();

    static {
        map.put("Kinetic/IP", new DeviceDriver("kinetic",  ConnectionType.IP));
        map.put("Kinetic/BT", new DeviceDriver("kinetic",  ConnectionType.BLUETOOTH));
    }

    public static DeviceDriver getDeviceDriver(String name) {
        return map.get(name);
    }

    public static Set<String> getAllDriverNames() {
        return new TreeSet<>(map.keySet());
    }

}
