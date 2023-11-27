package com.knubisoft.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanRequest {

    @JsonProperty("client.id")
    private String clientId;

    private Long loanAmount;
}


