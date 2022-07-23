package com.db.trade.tradestore.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * TradeRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-07-23T19:58:22.048+05:30")


public class TradeRequest   {
  @JsonProperty("tradeId")
  private String tradeId = null;

  @JsonProperty("version")
  private Integer version = null;

  @JsonProperty("counterPartyId")
  private String counterPartyId = null;

  @JsonProperty("bookId")
  private String bookId = null;

  @JsonProperty("maturityDate")
  private LocalDate maturityDate = null;

  @JsonProperty("isTradeExpired")
  private Boolean isTradeExpired = null;

  public TradeRequest tradeId(String tradeId) {
    this.tradeId = tradeId;
    return this;
  }

  /**
   * Unique identifier of trade
   * @return tradeId
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of trade")
  @NotNull


  public String getTradeId() {
    return tradeId;
  }

  public void setTradeId(String tradeId) {
    this.tradeId = tradeId;
  }

  public TradeRequest version(Integer version) {
    this.version = version;
    return this;
  }

  /**
   * Version number of the trade
   * @return version
  **/
  @ApiModelProperty(required = true, value = "Version number of the trade")
  @NotNull


  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public TradeRequest counterPartyId(String counterPartyId) {
    this.counterPartyId = counterPartyId;
    return this;
  }

  /**
   * Counter party id of the trade
   * @return counterPartyId
  **/
  @ApiModelProperty(required = true, value = "Counter party id of the trade")
  @NotNull


  public String getCounterPartyId() {
    return counterPartyId;
  }

  public void setCounterPartyId(String counterPartyId) {
    this.counterPartyId = counterPartyId;
  }

  public TradeRequest bookId(String bookId) {
    this.bookId = bookId;
    return this;
  }

  /**
   * Book identifier of the trade
   * @return bookId
  **/
  @ApiModelProperty(required = true, value = "Book identifier of the trade")
  @NotNull


  public String getBookId() {
    return bookId;
  }

  public void setBookId(String bookId) {
    this.bookId = bookId;
  }

  public TradeRequest maturityDate(LocalDate maturityDate) {
    this.maturityDate = maturityDate;
    return this;
  }

  /**
   * Maturity date of the trade
   * @return maturityDate
  **/
  @ApiModelProperty(required = true, value = "Maturity date of the trade")
  @NotNull

  @Valid

  public LocalDate getMaturityDate() {
    return maturityDate;
  }

  public void setMaturityDate(LocalDate maturityDate) {
    this.maturityDate = maturityDate;
  }

  public TradeRequest isTradeExpired(Boolean isTradeExpired) {
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
    TradeRequest tradeRequest = (TradeRequest) o;
    return Objects.equals(this.tradeId, tradeRequest.tradeId) &&
        Objects.equals(this.version, tradeRequest.version) &&
        Objects.equals(this.counterPartyId, tradeRequest.counterPartyId) &&
        Objects.equals(this.bookId, tradeRequest.bookId) &&
        Objects.equals(this.maturityDate, tradeRequest.maturityDate) &&
        Objects.equals(this.isTradeExpired, tradeRequest.isTradeExpired);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tradeId, version, counterPartyId, bookId, maturityDate, isTradeExpired);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TradeRequest {\n");
    
    sb.append("    tradeId: ").append(toIndentedString(tradeId)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    counterPartyId: ").append(toIndentedString(counterPartyId)).append("\n");
    sb.append("    bookId: ").append(toIndentedString(bookId)).append("\n");
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

