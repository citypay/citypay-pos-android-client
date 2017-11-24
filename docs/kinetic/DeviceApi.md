# DeviceApi

All URIs are relative to *https://ip-XXX-XXX-XXX-XXX.devices.kineticsmart.com/api/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**batteryJsonGet**](DeviceApi.md#batteryJsonGet) | **GET** /battery.json | Request the status of the battery on the device.
[**pingJsonGet**](DeviceApi.md#pingJsonGet) | **GET** /ping.json | Simple function to detect the presence of the device on the network. Typically, only used for system setup validation and testing.


<a name="batteryJsonGet"></a>
# **batteryJsonGet**
> BatteryResponse batteryJsonGet()

Request the status of the battery on the device.

### Example
```java
// Import classes:
//import com.citypay.pos.kinetic.api.DeviceApi;

DeviceApi apiInstance = new DeviceApi();
try {
    BatteryResponse result = apiInstance.batteryJsonGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceApi#batteryJsonGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BatteryResponse**](BatteryResponse.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pingJsonGet"></a>
# **pingJsonGet**
> PingResponse pingJsonGet()

Simple function to detect the presence of the device on the network. Typically, only used for system setup validation and testing.

### Example
```java
// Import classes:
//import com.citypay.pos.kinetic.api.DeviceApi;

DeviceApi apiInstance = new DeviceApi();
try {
    PingResponse result = apiInstance.pingJsonGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DeviceApi#pingJsonGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**PingResponse**](PingResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

