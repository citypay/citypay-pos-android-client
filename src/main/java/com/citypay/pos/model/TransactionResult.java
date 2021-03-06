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

package com.citypay.pos.model;

import com.citypay.pos.model.TransactionData;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class TransactionResult {
  
  @SerializedName("status")
  private String status = null;
  @SerializedName("identifier")
  private String identifier = null;
  @SerializedName("is_complete")
  private Boolean isComplete = null;
  @SerializedName("data")
  private TransactionData data = null;

  /**
   * A description of the status of a transaction
   **/
  @ApiModelProperty(value = "A description of the status of a transaction")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * The indentifier uniquely identifying the transaction
   **/
  @ApiModelProperty(value = "The indentifier uniquely identifying the transaction")
  public String getIdentifier() {
    return identifier;
  }
  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  /**
   * A boolean value stating whether the transaction has completed. The value will be false if the transaction is in progress. Should the value be true, a property containing the transaction details is made available.
   **/
  @ApiModelProperty(value = "A boolean value stating whether the transaction has completed. The value will be false if the transaction is in progress. Should the value be true, a property containing the transaction details is made available.")
  public Boolean getIsComplete() {
    return isComplete;
  }
  public void setIsComplete(Boolean isComplete) {
    this.isComplete = isComplete;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public TransactionData getData() {
    return data;
  }
  public void setData(TransactionData data) {
    this.data = data;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionResult transactionResult = (TransactionResult) o;
    return (this.status == null ? transactionResult.status == null : this.status.equals(transactionResult.status)) &&
        (this.identifier == null ? transactionResult.identifier == null : this.identifier.equals(transactionResult.identifier)) &&
        (this.isComplete == null ? transactionResult.isComplete == null : this.isComplete.equals(transactionResult.isComplete)) &&
        (this.data == null ? transactionResult.data == null : this.data.equals(transactionResult.data));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.status == null ? 0: this.status.hashCode());
    result = 31 * result + (this.identifier == null ? 0: this.identifier.hashCode());
    result = 31 * result + (this.isComplete == null ? 0: this.isComplete.hashCode());
    result = 31 * result + (this.data == null ? 0: this.data.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionResult {\n");
    
    sb.append("  status: ").append(status).append("\n");
    sb.append("  identifier: ").append(identifier).append("\n");
    sb.append("  isComplete: ").append(isComplete).append("\n");
    sb.append("  data: ").append(data).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
