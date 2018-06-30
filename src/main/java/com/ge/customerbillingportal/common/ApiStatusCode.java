package com.ge.customerbillingportal.common;

/**
 * @author Nitin K.
 * Utility class containing methods to return status code of APIs with description
 */
public class ApiStatusCode {

    private Integer statusCode;
    private String description;

    public ApiStatusCode(Integer statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Status 200, Correct API return status
     */
    public static ApiStatusCode STATUS_200_OK = new ApiStatusCode(200, null);


    /**
     * Status 1000, Undefined exception
     */
    public static ApiStatusCode STATUS_1000_UNDEFINED_EXCEPTION = new ApiStatusCode(1000, "undefined exception");


}
