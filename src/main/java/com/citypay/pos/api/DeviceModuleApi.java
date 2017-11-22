/**
 * CityPay POS API
 * CityPay Point of Sale API for payment with card present devices including EMV readers and contactless POS readers.  The API is available from https://github.com/citypay/citypay-pos-api  The API makes it simple to add EMV and contactless card acceptance to iOS, Android, Tablet and desktop applicaitons using a HTTPS protocol. It segregates the complexity of payment processing from the sales environment and eliminates any necessity for the target system to handle card data. 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: dev@citypay.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.citypay.pos.api;

import io.swagger.client.ApiInvoker;
import io.swagger.client.ApiException;
import io.swagger.client.Pair;

import com.citypay.pos.model.*;

import java.util.*;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.citypay.pos.model.DeviceInfo;
import com.citypay.pos.model.Result;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class DeviceModuleApi {
  String basePath = "https://pos.citypay.com/citypay-pos-api/1.0.0";
  ApiInvoker apiInvoker = ApiInvoker.getInstance();

  public void addHeader(String key, String value) {
    getInvoker().addDefaultHeader(key, value);
  }

  public ApiInvoker getInvoker() {
    return apiInvoker;
  }

  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }

  public String getBasePath() {
    return basePath;
  }

  /**
  * Device Information
  * Obtains information regarding the device and to review the current status of a device such as the battery charge, serial number and device type. 
   * @param deviceId The name of the target device used by the API.
   * @return DeviceInfo
  */
  public DeviceInfo deviceInfo (String deviceId) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
    Object postBody = null;
    // verify the required parameter 'deviceId' is set
    if (deviceId == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'deviceId' when calling deviceInfo",
        new ApiException(400, "Missing the required parameter 'deviceId' when calling deviceInfo"));
    }

    // create path and map variables
    String path = "/device/{deviceId}/info".replaceAll("\\{" + "deviceId" + "\\}", apiInvoker.escapeString(deviceId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();
    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
    }

    String[] authNames = new String[] {  };

    try {
      String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
      if (localVarResponse != null) {
         return (DeviceInfo) ApiInvoker.deserialize(localVarResponse, "", DeviceInfo.class);
      } else {
         return null;
      }
    } catch (ApiException ex) {
       throw ex;
    } catch (InterruptedException ex) {
       throw ex;
    } catch (ExecutionException ex) {
      if (ex.getCause() instanceof VolleyError) {
        VolleyError volleyError = (VolleyError)ex.getCause();
        if (volleyError.networkResponse != null) {
          throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
        }
      }
      throw ex;
    } catch (TimeoutException ex) {
      throw ex;
    }
  }

      /**
   * Device Information
   * Obtains information regarding the device and to review the current status of a device such as the battery charge, serial number and device type. 
   * @param deviceId The name of the target device used by the API.
  */
  public void deviceInfo (String deviceId, final Response.Listener<DeviceInfo> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

    // verify the required parameter 'deviceId' is set
    if (deviceId == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'deviceId' when calling deviceInfo",
        new ApiException(400, "Missing the required parameter 'deviceId' when calling deviceInfo"));
    }

    // create path and map variables
    String path = "/device/{deviceId}/info".replaceAll("\\{format\\}","json").replaceAll("\\{" + "deviceId" + "\\}", apiInvoker.escapeString(deviceId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();



    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

    String[] authNames = new String[] {  };

    try {
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((DeviceInfo) ApiInvoker.deserialize(localVarResponse,  "", DeviceInfo.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Device Ping
  * To monitor or to check whether a device is available, the host can send a simple &#x60;GET&#x60; request to the URL at &#x60;/device/{deviceId}/ping&#x60; to see if the device is responding and available. 
   * @param deviceId The name of the target device used by the API.
   * @return Result
  */
  public Result ping (String deviceId) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
    Object postBody = null;
    // verify the required parameter 'deviceId' is set
    if (deviceId == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'deviceId' when calling ping",
        new ApiException(400, "Missing the required parameter 'deviceId' when calling ping"));
    }

    // create path and map variables
    String path = "/device/{deviceId}/ping".replaceAll("\\{" + "deviceId" + "\\}", apiInvoker.escapeString(deviceId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();
    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
    }

    String[] authNames = new String[] {  };

    try {
      String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
      if (localVarResponse != null) {
         return (Result) ApiInvoker.deserialize(localVarResponse, "", Result.class);
      } else {
         return null;
      }
    } catch (ApiException ex) {
       throw ex;
    } catch (InterruptedException ex) {
       throw ex;
    } catch (ExecutionException ex) {
      if (ex.getCause() instanceof VolleyError) {
        VolleyError volleyError = (VolleyError)ex.getCause();
        if (volleyError.networkResponse != null) {
          throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
        }
      }
      throw ex;
    } catch (TimeoutException ex) {
      throw ex;
    }
  }

      /**
   * Device Ping
   * To monitor or to check whether a device is available, the host can send a simple &#x60;GET&#x60; request to the URL at &#x60;/device/{deviceId}/ping&#x60; to see if the device is responding and available. 
   * @param deviceId The name of the target device used by the API.
  */
  public void ping (String deviceId, final Response.Listener<Result> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

    // verify the required parameter 'deviceId' is set
    if (deviceId == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'deviceId' when calling ping",
        new ApiException(400, "Missing the required parameter 'deviceId' when calling ping"));
    }

    // create path and map variables
    String path = "/device/{deviceId}/ping".replaceAll("\\{format\\}","json").replaceAll("\\{" + "deviceId" + "\\}", apiInvoker.escapeString(deviceId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();



    String[] contentTypes = {
      "application/json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

    String[] authNames = new String[] {  };

    try {
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((Result) ApiInvoker.deserialize(localVarResponse,  "", Result.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
}
