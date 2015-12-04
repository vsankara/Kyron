package com.technobrain.trips.core.bean;

public class ProductImageBean {
    private byte[] contents;
    private String fileType;
    private Long productId;
    public ProductImageBean() {
    }

    public void setContents(byte[] contents) {
        this.contents = contents;
    }

    public byte[] getContents() {
        return contents;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }
}
