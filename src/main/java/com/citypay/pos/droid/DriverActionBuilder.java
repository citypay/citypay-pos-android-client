package com.citypay.pos.droid;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Package utility class for building driver actions such as
 * <code>DriverActionBuilder.newBuilder().with("driver", device -> {})</code>
 */
class DriverActionBuilder {

    static DriverActionBuilder newBuilder() {
        return new DriverActionBuilder();
    }

    private Map<String, Consumer<Device>> _map = new HashMap<>();

    private DriverActionBuilder() {
    }

    DriverActionBuilder with(String driver, Consumer<Device> consumer) {
        _map.put(driver, consumer);
        return this;
    }

    Set<Map.Entry<String, Consumer<Device>>> entrySet() {
        return _map == null ? new HashSet<>() : _map.entrySet();
    }

    int size() {
        return _map.size();
    }
}
