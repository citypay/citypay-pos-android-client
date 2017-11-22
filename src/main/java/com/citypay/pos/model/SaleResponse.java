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

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class SaleResponse {
  
  @SerializedName("success")
  private Boolean success = null;
  @SerializedName("identifier")
  private String identifier = null;
  @SerializedName("description")
  private String description = null;

  /**
   * Defines whether the sale was successfully created
   **/
  @ApiModelProperty(required = true, value = "Defines whether the sale was successfully created")
  public Boolean getSuccess() {
    return success;
  }
  public void setSuccess(Boolean success) {
    this.success = success;
  }

  /**
   * The identifier presented to the sale request
   **/
  @ApiModelProperty(required = true, value = "The identifier presented to the sale request")
  public String getIdentifier() {
    return identifier;
  }
  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  /**
   * Description should the sale request not be accepted
   **/
  @ApiModelProperty(value = "Description should the sale request not be accepted")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SaleResponse saleResponse = (SaleResponse) o;
    return (this.success == null ? saleResponse.success == null : this.success.equals(saleResponse.success)) &&
        (this.identifier == null ? saleResponse.identifier == null : this.identifier.equals(saleResponse.identifier)) &&
        (this.description == null ? saleResponse.description == null : this.description.equals(saleResponse.description));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.success == null ? 0: this.success.hashCode());
    result = 31 * result + (this.identifier == null ? 0: this.identifier.hashCode());
    result = 31 * result + (this.description == null ? 0: this.description.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaleResponse {\n");
    
    sb.append("  success: ").append(success).append("\n");
    sb.append("  identifier: ").append(identifier).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
