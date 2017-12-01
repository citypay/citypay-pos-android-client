package com.citypay.pos.droid;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import com.google.gson.Gson;

import java.util.List;

public class SharedPreferencesDeviceManager extends HashMapDeviceManager {

    private static final String PREFERENCE_KEY = "devices";
    private final ContextWrapper ctx;
    private final String preferenceFile;
    private boolean loaded = false;
    private final SharedPreferences prefs;


    public SharedPreferencesDeviceManager(String preferenceFile, ContextWrapper ctx) {
        this.preferenceFile = preferenceFile;
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences(preferenceFile, Context.MODE_PRIVATE);
    }

    DeviceArray extract(String str) {
        return new Gson().fromJson(str, DeviceArray.class);
    }

    private void load() {
        String deviceValue = prefs.getString(PREFERENCE_KEY, "[]");
        DeviceArray deviceArray = extract(deviceValue);
        // add to hash map of the super device manager
        for (Device device : deviceArray.getDevices()) {
            super.save(device);
        }
        loaded = true;
    }

    private void store() {
        DeviceArray deviceArray = new DeviceArray();
        Device[] arr = new Device[super.list().size()];
        super.list().toArray(arr);
        deviceArray.setDevices(arr);

        String json = new Gson().toJson(deviceArray);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PREFERENCE_KEY, json);
        editor.commit();
    }

    @Override
    public List<Device> list() {
        if (!loaded) {
            load();
        }
        return super.list();
    }

    @Override
    public Device find(String name) {
        if (!loaded) {
            load();
        }
        return super.find(name);
    }

    @Override
    public Device save(Device device) {
        if (!loaded) {
            load();
        }
        Device d = super.save(device);
        store();
        return d;
    }

    @Override
    public Device delete(String name) {
        if (!loaded) {
            load();
        }
        Device d = super.delete(name);
        store();
        return d;
    }
}
