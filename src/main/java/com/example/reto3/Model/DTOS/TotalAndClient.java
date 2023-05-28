package com.example.reto3.Model.DTOS;

import com.example.reto3.Model.Client;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class TotalAndClient {
    private Long Total;

    private Client client;

    public TotalAndClient(Long total, Client client) {
        this.Total = total;
        this.client = client;
    }
    @JsonProperty(index = 0)
    public Long getTotal() {
        return Total;
    }
    public void setTotal(Long total) {
        this.Total = total;
    }

    @JsonProperty(index = 1)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
