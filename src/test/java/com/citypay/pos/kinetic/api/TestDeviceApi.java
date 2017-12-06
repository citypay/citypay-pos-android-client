package com.citypay.pos.kinetic.api;

import com.citypay.pos.kinetic.model.PingResponse;
import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.JsonUtil;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestDeviceApi {


    @Test
    public void testPingResponse() throws ApiException {


        String str = "{ \"ping\": true }";

        Object o = ApiInvoker.deserialize(str, "", PingResponse.class);
        PingResponse pr = (PingResponse) o;
        assertTrue(pr.getPing());

    }
}




