package com.technobrain.trips.dto.portal;

import java.sql.Timestamp;


/**
 * Data transfer object for SystemService.getReferenceData() service
 * 
 * @author Emmanuel Comia
 */
public class ReferenceDataType {
    private String code;

    private String description;

    private String status;

    private Timestamp validFrom;

    private Timestamp validTo;

    private Timestamp createdDate;

    private Timestamp updatedDate;

    private String references;

    /**
     * Constructor
     */
    public ReferenceDataType() {
    }

    /**
     * Constructor
     * 
     * @param code
     * @param description
     * @param status
     * @param validFrom
     * @param validTo
     * @param createdDate
     * @param updatedDate
     * @param references
     */
    public ReferenceDataType(String code, String description, String status, 
                             Timestamp validFrom, Timestamp validTo, 
                             Timestamp createdDate, Timestamp updatedDate, 
                             String references) {
        this.code = code;
        this.description = description;
        this.status = status;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.references = references;
    }

    /**
     * Constructor
     * 
     * @param code
     * @param description
     * @param status
     * @param validFrom
     * @param validTo
     * @param createdDate
     * @param updatedDate
     */
    public ReferenceDataType(String code, String description, String status, 
                             Timestamp validFrom, Timestamp validTo, 
                             Timestamp createdDate, Timestamp updatedDate) {
        this.code = code;
        this.description = description;
        this.status = status;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getValidFrom() {
        return validFrom;
    }

    public Timestamp getValidTo() {
        return validTo;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public String getReferences() {
        return references;
    }
}