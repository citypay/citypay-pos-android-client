package com.citypay.pos.droid;

import com.android.volley.Response;
import com.citypay.pos.model.DeviceInfo;
import com.citypay.pos.model.Result;

import static com.citypay.pos.droid.DeviceManager.KINETIC_DRIVER;

/**
 * Java device module for working with devices programmatically. The {@link DeviceModule} class only supports
 * asynchronous API calls.
 * <p>
 * The device module will require an initialised {@link DeviceManager} and will check for valid devices on method calls.
 *
 *
 * <code>
 *     DeviceManager dm = ...
 *     DeviceModule module = new DeviceModule(dm);
 *     module.ping("Terminal1", result -> {}, volleyError -> {});
 * </code>
 */
public class DeviceModule extends Module {

    public DeviceModule(DeviceManager deviceManager) {
        super(deviceManager);
    }

    /**
     * Device Ping
     * To monitor or to check whether a device is available, the host can send a simple &#x60;GET&#x60;
     * request to the URL at &#x60;/device/{deviceId}/ping&#x60; to see if the device is responding and available.
     *
     * @param deviceId The name of the target device used by the API.
     */
    public final void ping(String deviceId, final Response.Listener<Result> responseListener, final Response.ErrorListener errorListener) {

        _withDevice(deviceId, errorListener, DriverActionBuilder.newBuilder()
                .with(KINETIC_DRIVER, device -> {
                            initKineticDeviceApi(device).pingJsonGet(pingResponse -> {
                                Result result = new Result();
                                result.setMessage(String.format("Response from %s", device.getAddress()));
                                result.setSuccess(pingResponse.getPing());
                                responseListener.onResponse(result);
                            }, errorListener);
                        }
                ));


    }

    /**
     * Device Information
     * Obtains information regarding the device and to review the current status of a device such as the battery charge, serial number and device type.
     *
     * @param deviceId The name of the target device used by the API.
     */
    public final void deviceInfo(String deviceId, final Response.Listener<DeviceInfo> responseListener, final Response.ErrorListener errorListener) {

        _withDevice(deviceId, errorListener, DriverActionBuilder.newBuilder()
                .with(KINETIC_DRIVER, device -> {
                            initKineticDeviceApi(device).batteryJsonGet(batteryResponse -> {

                                DeviceInfo deviceInfo = new DeviceInfo();
                                deviceInfo.setBatteryCharging(batteryResponse.getCharging());
                                deviceInfo.setBatteryPercentage(batteryResponse.getPercentage());
                                // todo add extra device information
//                                deviceInfo.setBusy();
//                                deviceInfo.setName();
//                                deviceInfo.setPortable();
//                                deviceInfo.setPrinter();
//                                deviceInfo.setSerialno();
                                responseListener.onResponse(deviceInfo);

                            }, errorListener);
                        }
                ));

    }


}
