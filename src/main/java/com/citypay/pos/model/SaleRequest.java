/**
 * CityPay POS API
 * CityPay Point of Sale API for payment with card present devices including EMV readers and contactless POS readers.  The API makes it simple to add EMV and contactless card acceptance to iOS, Android, Tablet and desktop applicaitons using a HTTPS protocol. It segregates the complexity of payment processing from the sales environment and eliminates any necessity for the target system to handle card data. 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: dev@citypay.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.citypay.pos.model;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

/**
 * A request for a sale
 **/
@ApiModel(description = "A request for a sale")
public class SaleRequest {
  
  @SerializedName("device")
  private String device = null;
  @SerializedName("amount")
  private Integer amount = null;
  @SerializedName("identifier")
  private String identifier = null;

  /**
   * The name of the target device used by the API. The device will be setup prior to the sale but allows targeting of multiple devices.
   **/
  @ApiModelProperty(required = true, value = "The name of the target device used by the API. The device will be setup prior to the sale but allows targeting of multiple devices.")
  public String getDevice() {
    return device;
  }
  public void setDevice(String device) {
    this.device = device;
  }

  /**
   * The amount to process in the lowest denomination and in the base currency of the device. 4798 for instance would process the transaction for £47.98
   **/
  @ApiModelProperty(required = true, value = "The amount to process in the lowest denomination and in the base currency of the device. 4798 for instance would process the transaction for £47.98")
  public Integer getAmount() {
    return amount;
  }
  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  /**
   * An identifier or reference for the sale as taken by the point of sale system. This should be used to cross reference transactions after it has processed. The value should be unique and will be used to check on the processing of the transaction.
   **/
  @ApiModelProperty(required = true, value = "An identifier or reference for the sale as taken by the point of sale system. This should be used to cross reference transactions after it has processed. The value should be unique and will be used to check on the processing of the transaction.")
  public String getIdentifier() {
    return identifier;
  }
  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SaleRequest saleRequest = (SaleRequest) o;
    return (this.device == null ? saleRequest.device == null : this.device.equals(saleRequest.device)) &&
        (this.amount == null ? saleRequest.amount == null : this.amount.equals(saleRequest.amount)) &&
        (this.identifier == null ? saleRequest.identifier == null : this.identifier.equals(saleRequest.identifier));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.device == null ? 0: this.device.hashCode());
    result = 31 * result + (this.amount == null ? 0: this.amount.hashCode());
    result = 31 * result + (this.identifier == null ? 0: this.identifier.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaleRequest {\n");
    
    sb.append("  device: ").append(device).append("\n");
    sb.append("  amount: ").append(amount).append("\n");
    sb.append("  identifier: ").append(identifier).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}