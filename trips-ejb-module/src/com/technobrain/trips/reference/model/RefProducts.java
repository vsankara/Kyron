package com.technobrain.trips.reference.model;

//package com.crownagents.trips.reference.model;
//
//import com.technobrain.trips.core.message.ProductInputType;
//
//import com.crownagents.trips.core.model.BaseNormalModelObject;
//
//import java.io.Serializable;
//
//import java.sql.Timestamp;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;import com.crownagents.trips.core.model.BaseNormalModelObject;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQuery;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//@Entity
//@NamedQuery(name = "RefProducts.findAll", 
//    query = "select o from RefProducts o")
//@Table(name = "REF_PRODUCTS")
//public class RefProducts extends BaseNormalModelObject {
//    private String brand;
//    @Column(name="CHEMICAL_NAME")
//    private String chemicalName;
//    @Column(name="COMMODITY_CODE")
//    private String commodityCode;
//    @Column(name="COMMON_NAME")
//    private String commonName;
//    @Column(name="COUNTRY_OF_ORIGIN")
//    private String countryOfOrigin;
//     
//    private String sensitive;
//    private String discontinued;     
//     
//    private String currency;
//    private String description;
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
//                    generator = "REF_PRODUCTS_SEQ")
//    @SequenceGenerator(name = "REF_PRODUCTS_SEQ", sequenceName = "REF_PRODUCTS_SEQ", 
//                       allocationSize = 1)
//    @Column(nullable = false)
//    private Long id;
//    private String origin;
//    @Column(name="SCIENTIFIC_NAME")
//    private String scientificName;
//    @Column(name="TRADE_MARK")
//    private String tradeMark;
//    private String units;
//     
//    public RefProducts() {
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public String getChemicalName() {
//        return chemicalName;
//    }
//
//    public void setChemicalName(String chemicalName) {
//        this.chemicalName = chemicalName;
//    }
//
//    public String getCommodityCode() {
//        return commodityCode;
//    }
//
//    public void setCommodityCode(String commodityCode) {
//        this.commodityCode = commodityCode;
//    }
//
//    public String getCommonName() {
//        return commonName;
//    }
//
//    public void setCommonName(String commonName) {
//        this.commonName = commonName;
//    }
//
//    public String getCountryOfOrigin() {
//        return countryOfOrigin;
//    }
//
//    public void setCountryOfOrigin(String countryOfOrigin) {
//        this.countryOfOrigin = countryOfOrigin;
//    }
//
//    public String getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(String currency) {
//        this.currency = currency;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getOrigin() {
//        return origin;
//    }
//
//    public void setOrigin(String origin) {
//        this.origin = origin;
//    }
//
//    public String getScientificName() {
//        return scientificName;
//    }
//
//    public void setScientificName(String scientificName) {
//        this.scientificName = scientificName;
//    }
//
//    public String getTradeMark() {
//        return tradeMark;
//    }
//
//    public void setTradeMark(String tradeMark) {
//        this.tradeMark = tradeMark;
//    }
//
//    public String getUnits() {
//        return units;
//    }
//
//    public void setUnits(String units) {
//        this.units = units;
//    }
//
//    public void setSensitive(String sensitive) {
//        this.sensitive = sensitive;
//    }
//
//    public String getSensitive() {
//        return sensitive;
//    }
//
//    public void setDiscontinued(String discontinued) {
//        this.discontinued = discontinued;
//    }
//
//    public String getDiscontinued() {
//        return discontinued;
//    }
//}
