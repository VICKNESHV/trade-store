package com.db.trade.tradestore.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * TradeResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-07-23T19:58:22.048+05:30")


public class TradeResponse   {
  @JsonProperty("tradeId")
  private String tradeId = null;

  @JsonProperty("version")
  private Integer version = null;

  @JsonProperty("counterPartyId")
  private String counterPartyId = null;

  @JsonProperty("bookId")
  private String bookId = null;

  @JsonProperty("tradeCreatedDate")
  private LocalDate tradeCreatedDate = null;

  @JsonProperty("maturityDate")
  private LocalDate maturityDate = null;

  @JsonProperty("isTradeExpired")
  private Boolean isTradeExpired = null;

  public TradeResponse tradeId(String tradeId) {
    this.tradeId = tradeId;
    return this;
  }

  /**
   * Unique identifier of trade
   * @return tradeId
  **/
  @ApiModelProperty(value = "Unique identifier of trade")


  public String getTradeId() {
    return tradeId;
  }

  public void setTradeId(String tradeId) {
    this.tradeId = tradeId;
  }

  public TradeResponse version(Integer version) {
    this.version = version;
    return this;
  }

  /**
   * Version number of the trade
   * @return version
  **/
  @ApiModelProperty(value = "Version number of the trade")


  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public TradeResponse counterPartyId(String counterPartyId) {
    this.counterPartyId = counterPartyId;
    return this;
  }

  /**
   * Counter party id of the trade
   * @return counterPartyId
  **/
  @ApiModelProperty(value = "Counter party id of the trade")


  public String getCounterPartyId() {
    return counterPartyId;
  }

  public void setCounterPartyId(String counterPartyId) {
    this.counterPartyId = counterPartyId;
  }

  public TradeResponse bookId(String bookId) {
    this.bookId = bookId;
    return this;
  }

  /**
   * Book identifier of the trade
   * @return bookId
  **/
  @ApiModelProperty(value = "Book identifier of the trade")


  public String getBookId() {
    return bookId;
  }

  public void setBookId(String bookId) {
    this.bookId = bookId;
  }

  public TradeResponse tradeCreatedDate(LocalDate tradeCreatedDate) {
    this.tradeCreatedDate = tradeCreatedDate;
    return this;
  }

  /**
   * Date when the trade was executed
   * @return tradeCreatedDate
  **/
  @ApiModelProperty(value = "Date when the trade was executed")

  @Valid

  public LocalDate getTradeCreatedDate() {
    return tradeCreatedDate;
  }

  public void setTradeCreatedDate(LocalDate tradeCreatedDate) {
    this.tradeCreatedDate = tradeCreatedDate;
  }

  public TradeResponse maturityDate(LocalDate maturityDate) {
    this.maturityDate = maturityDate;
    return this;
  }

  /**
   * Maturity date of the trade
   * @return maturityDate
  **/
  @ApiModelProperty(value = "Maturity date of the trade")

  @Valid

  public LocalDate getMaturityDate() {
    return maturityDate;
  }

  public void setMaturityDate(LocalDate maturityDate) {
    this.maturityDate = maturityDate;
  }

  public TradeResponse isTradeExpired(Boolean isTradeExpired) {
    this.isTradeExpired = isTradeExpired;
    return this;
  }

  /**
   * Get isTradeExpired
   * @return isTradeExpired
  **/
  @ApiModelProperty(value = "")


  public Boolean isIsTradeExpired() {
    return isTradeExpired;
  }

  public void setIsTradeExpired(Boolean isTradeExpired) {
    this.isTradeExpired = isTradeExpired;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TradeResponse tradeResponse = (TradeResponse) o;
    return Objects.equals(this.tradeId, tradeResponse.tradeId) &&
        Objects.equals(this.version, tradeResponse.version) &&
        Objects.equals(this.counterPartyId, tradeResponse.counterPartyId) &&
        Objects.equals(this.bookId, tradeResponse.bookId) &&
        Objects.equals(this.tradeCreatedDate, tradeResponse.tradeCreatedDate) &&
        Objects.equals(this.maturityDate, tradeResponse.maturityDate) &&
        Objects.equals(this.isTradeExpired, tradeResponse.isTradeExpired);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeId, version, counterPartyId, bookId, tradeCreatedDate, maturityDate, isTradeExpired);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TradeResponse {\n");
    
    sb.append("    tradeId: ").append(toIndentedString(tradeId)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    counterPartyId: ").append(toIndentedString(counterPartyId)).append("\n");
    sb.append("    bookId: ").append(toIndentedString(bookId)).append("\n");
    sb.append("    tradeCreatedDate: ").append(toIndentedString(tradeCreatedDate)).append("\n");
    sb.append("    maturityDate: ").append(toIndentedString(maturityDate)).append("\n");
    sb.append("    isTradeExpired: ").append(toIndentedString(isTradeExpired)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

