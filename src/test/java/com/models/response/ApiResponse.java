package com.models.response;

import io.restassured.response.Response;

public abstract class ApiResponse {
    private Response response;

    public void setResponse(Response response) {
        this.response = response;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public Response getResponse() {
        return response;
    }
}
