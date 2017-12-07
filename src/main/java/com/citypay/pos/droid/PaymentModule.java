package com.citypay.pos.droid;


import com.android.volley.Response;
import com.citypay.pos.model.*;

import static com.citypay.pos.droid.DeviceManager.KINETIC_DRIVER;

/**
 * Java payment module for working with device payments programmatically. The {@link PaymentModule} class only supports
 * asynchronous API calls.
 * <p>
 * The device module will require an initialised {@link DeviceManager} and will check for valid devices on method calls.
 * <p>
 * <code>
 * DeviceManager dm = ...
 * PaymentModule module = new PaymentModule(dm);
 * module.ping("Terminal1", result -> {}, volleyError -> {});
 * </code>
 */
public class PaymentModule extends Module {

    public PaymentModule(DeviceManager deviceManager) {
        super(deviceManager);
    }

    private com.citypay.pos.kinetic.model.SaleRequest adapt(SaleRequest body) {
        com.citypay.pos.kinetic.model.SaleRequest request = new com.citypay.pos.kinetic.model.SaleRequest();
        request.setAmount(body.getAmount());
        request.setUuid(body.getIdentifier());
        return request;
    }

    private SaleResponse adapt(com.citypay.pos.kinetic.model.SaleResponse response) {
        SaleResponse dest = new SaleResponse();
        dest.setIdentifier(response.getUuid());
        dest.setSuccess(response.getSuccess());
        dest.setDescription(response.getDescription());
        return dest;
    }



    /**
     * Sale Transaction
     * Initiates a new sale to a device. The action will contact the device and request a transaction start including the amount and a unique reference to track the transaction through it&#39;s lifecycle.
     *
     * @param body
     */
    public void sale(SaleRequest body, final Response.Listener<SaleResponse> responseListener, final Response.ErrorListener errorListener) {

        preconditionCheck(body, "body cannot be null");
        preconditionCheckListener(responseListener);

        _withDevice(body.getDevice(), errorListener, DriverActionBuilder.newBuilder()
                .with(KINETIC_DRIVER, device -> initKineticPaymentApi(device).saleJsonPost(adapt(body), saleResponse -> {
                    responseListener.onResponse(adapt(saleResponse));
                }, errorListener))
        );

    }

    /**
     * Receipt Print
     * Reprint a merchant or customer receipt for a transaction that exists on the device (i.e. has not been cleared by End of Day process).
     * @param body
     */
    public void receipt (TransactionProgress body, final Response.Listener<TransactionResult> responseListener, final Response.ErrorListener errorListener) {
        throw new UnsupportedOperationException();
    }

    /**
     * Refund Transaction
     * Initiates a new refund to a device. The action will contact the device and request a transaction start including the amount and a unique reference to track the transaction through it&#39;s lifecycle.
     * @param body
     */
    public void refund (SaleRequest body, final Response.Listener<SaleResponse> responseListener, final Response.ErrorListener errorListener) {
        throw new UnsupportedOperationException();
    }


    /**
     * Reversal Tranasction
     * Initiates a reversal to a device. No confirmation is made and the transaction reversal process is run.
     * @param body
     */
    public void reversal (ReversalRequest body, final Response.Listener<SaleResponse> responseListener, final Response.ErrorListener errorListener) {
        throw new UnsupportedOperationException();
    }


    /**
     * Transaction Status
     * Request the status of a transaction in progress or a complete transaction using the identifier as the reference. Depending on the state of the transaction, the response will indicate if it is not found, in progress (and the current stage in the transaction workflow) or complete (with all transaction data).
     * @param body
     */
    public void transaction (TransactionProgress body, final Response.Listener<TransactionResult> responseListener, final Response.ErrorListener errorListener) {
        throw new UnsupportedOperationException();
    }

}
