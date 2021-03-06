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

package io.swagger.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Date;
import com.citypay.pos.model.*;

public class JsonUtil {
  public static GsonBuilder gsonBuilder;

  static {
    gsonBuilder = new GsonBuilder();
    gsonBuilder.serializeNulls();
    gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
      public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return new Date(json.getAsJsonPrimitive().getAsLong());
      }
    });
  }

  public static Gson getGson() {
    return gsonBuilder.create();
  }

  public static String serialize(Object obj){
    return getGson().toJson(obj);
  }

  public static <T> T deserializeToList(String jsonString, Class cls){
    return getGson().fromJson(jsonString, getListTypeForDeserialization(cls));
  }

  public static <T> T deserializeToObject(String jsonString, Class cls){
    return getGson().fromJson(jsonString, getTypeForDeserialization(cls));
  }

  public static Type getListTypeForDeserialization(Class cls) {
    String className = cls.getSimpleName();
    
    if ("DeviceInfo".equalsIgnoreCase(className)) {
      return new TypeToken<List<DeviceInfo>>(){}.getType();
    }
    
    if ("PrintRequest".equalsIgnoreCase(className)) {
      return new TypeToken<List<PrintRequest>>(){}.getType();
    }
    
    if ("Receipt".equalsIgnoreCase(className)) {
      return new TypeToken<List<Receipt>>(){}.getType();
    }
    
    if ("Result".equalsIgnoreCase(className)) {
      return new TypeToken<List<Result>>(){}.getType();
    }
    
    if ("ReversalRequest".equalsIgnoreCase(className)) {
      return new TypeToken<List<ReversalRequest>>(){}.getType();
    }
    
    if ("SaleRequest".equalsIgnoreCase(className)) {
      return new TypeToken<List<SaleRequest>>(){}.getType();
    }
    
    if ("SaleResponse".equalsIgnoreCase(className)) {
      return new TypeToken<List<SaleResponse>>(){}.getType();
    }
    
    if ("SuccessResponse".equalsIgnoreCase(className)) {
      return new TypeToken<List<SuccessResponse>>(){}.getType();
    }
    
    if ("TransactionData".equalsIgnoreCase(className)) {
      return new TypeToken<List<TransactionData>>(){}.getType();
    }
    
    if ("TransactionProgress".equalsIgnoreCase(className)) {
      return new TypeToken<List<TransactionProgress>>(){}.getType();
    }
    
    if ("TransactionResult".equalsIgnoreCase(className)) {
      return new TypeToken<List<TransactionResult>>(){}.getType();
    }
    
    return new TypeToken<List<Object>>(){}.getType();
  }

  public static Type getTypeForDeserialization(Class cls) {
    String className = cls.getSimpleName();
    
    if ("DeviceInfo".equalsIgnoreCase(className)) {
      return new TypeToken<DeviceInfo>(){}.getType();
    }
    
    if ("PrintRequest".equalsIgnoreCase(className)) {
      return new TypeToken<PrintRequest>(){}.getType();
    }
    
    if ("Receipt".equalsIgnoreCase(className)) {
      return new TypeToken<Receipt>(){}.getType();
    }
    
    if ("Result".equalsIgnoreCase(className)) {
      return new TypeToken<Result>(){}.getType();
    }
    
    if ("ReversalRequest".equalsIgnoreCase(className)) {
      return new TypeToken<ReversalRequest>(){}.getType();
    }
    
    if ("SaleRequest".equalsIgnoreCase(className)) {
      return new TypeToken<SaleRequest>(){}.getType();
    }
    
    if ("SaleResponse".equalsIgnoreCase(className)) {
      return new TypeToken<SaleResponse>(){}.getType();
    }
    
    if ("SuccessResponse".equalsIgnoreCase(className)) {
      return new TypeToken<SuccessResponse>(){}.getType();
    }
    
    if ("TransactionData".equalsIgnoreCase(className)) {
      return new TypeToken<TransactionData>(){}.getType();
    }
    
    if ("TransactionProgress".equalsIgnoreCase(className)) {
      return new TypeToken<TransactionProgress>(){}.getType();
    }
    
    if ("TransactionResult".equalsIgnoreCase(className)) {
      return new TypeToken<TransactionResult>(){}.getType();
    }
    
    return new TypeToken<Object>(){}.getType();
  }

};
