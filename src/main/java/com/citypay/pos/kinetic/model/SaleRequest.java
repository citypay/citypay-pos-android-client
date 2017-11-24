/**
 * Kinetic Smart API
 * Kinetic Smart Swagger Implementatin
 *
 * OpenAPI spec version: 1.0.0
 * Contact: dev@citypay.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.citypay.pos.kinetic.model;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class SaleRequest {
  
  @SerializedName("amount")
  private Integer amount = null;
  @SerializedName("uuid")
  private String uuid = null;

  /**
   * The amount to process in the lowest denomination and in the base currency of the device. 100 for instance would process the transaction for £1.00
   **/
  @ApiModelProperty(required = true, value = "The amount to process in the lowest denomination and in the base currency of the device. 100 for instance would process the transaction for £1.00")
  public Integer getAmount() {
    return amount;
  }
  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  /**
   * Can include a unique identifier (uuid) for this transaction, but if none present a new UUID will be assigned and returned. Note, does not have to be a uuid
   **/
  @ApiModelProperty(value = "Can include a unique identifier (uuid) for this transaction, but if none present a new UUID will be assigned and returned. Note, does not have to be a uuid")
  public String getUuid() {
    return uuid;
  }
  public void setUuid(String uuid) {
    this.uuid = uuid;
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
    return (this.amount == null ? saleRequest.amount == null : this.amount.equals(saleRequest.amount)) &&
        (this.uuid == null ? saleRequest.uuid == null : this.uuid.equals(saleRequest.uuid));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.amount == null ? 0: this.amount.hashCode());
    result = 31 * result + (this.uuid == null ? 0: this.uuid.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaleRequest {\n");
    
    sb.append("  amount: ").append(amount).append("\n");
    sb.append("  uuid: ").append(uuid).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
