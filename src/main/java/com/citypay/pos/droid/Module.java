package com.citypay.pos.droid;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.citypay.pos.kinetic.api.DeviceApi;
import com.citypay.pos.kinetic.api.PaymentApi;

import java.util.Map;
import java.util.function.Consumer;

/**
 * An abstraction of a module used in the pos api to obtain and use devices.
 */
public abstract class Module {

    private final DeviceManager deviceManager;

    Module(DeviceManager deviceManager) {
        this.deviceManager = deviceManager;
    }

    void preconditionCheck(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
    }

    protected void preconditionCheckListener(Response.Listener<?> listener) {
        preconditionCheck(listener, "Response listener not provided");
    }

    private void preconditionCheckErrorListener(Response.ErrorListener listener) {
        preconditionCheck(listener, "Response listener not provided");
    }

    DeviceApi initKineticDeviceApi(Device device) {
        preconditionCheck(device, "Device cannot be null");
        DeviceApi api = new DeviceApi();
        api.setBasePath(device.getAddress());
        return api;
    }

    PaymentApi initKineticPaymentApi(Device device) {
        preconditionCheck(device, "Device cannot be null");
        PaymentApi paymentApi = new PaymentApi();
        paymentApi.setBasePath(device.getAddress());
        return paymentApi;
    }



    protected void handle(final Response.ErrorListener errorListener, String str, Object... args) {
        errorListener.onErrorResponse(new VolleyError(String.format(str, args)));
    }

    /**
     * Utility method for actioning against a device id and actioning a driver action. Should a driver not be found
     * or is unsupported by the driver, the method will provide error handling internally
     *
     * @param deviceId      the device id to run the action against
     * @param errorListener an error listener to push failures to
     * @param actions       a {@link DriverActionBuilder} who's actions will be run
     */
    void _withDevice(final String deviceId,
                     final Response.ErrorListener errorListener,
                     final DriverActionBuilder actions) {

        preconditionCheckErrorListener(errorListener);

        if (deviceId == null || deviceId.trim().length() == 0) {
            handle(errorListener, "Invalid deviceId");
            return;
        }

        Device device = deviceManager.find(deviceId);
        if (device == null) {
            errorListener.onErrorResponse(new VolleyError("Device not found"));
        } else {
            if (actions != null && actions.size() > 0) {
                for (Map.Entry<String, Consumer<Device>> entry : actions.entrySet()) {
                    if (entry.getKey().equals(device.getDriver())) {
                        entry.getValue().accept(device);
                        return;
                    }
                }
            } else {
                handle(errorListener, "No actions available for device '%s'", deviceId);
            }
            handle(errorListener, "\"%s\" Invalid device driver or action not supported", deviceId);
        }
    }

}
