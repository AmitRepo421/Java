package com.techlabs.project.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransactionType {
    CREDIT, DEBIT, TRANSFER;
    
//    @JsonCreator
//    public static TransactionType fromString(String value) {
//        return TransactionType.valueOf(value.toUpperCase());
//    }
//
//    @JsonValue
//    public String toJson() {
//        return this.name();
//    }
}
