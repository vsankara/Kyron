package com.technobrain.trips.dto;

//package com.crownagents.trips.dto;
//
//import com.crownagents.trips.core.message.IndividualType;
//import com.crownagents.trips.core.message.OrganisationType;
//
//import java.util.Calendar;
//
//public class TaxPayerDTO implements DataTransferObject {
//    private Long id;
//    private String tin;
//    private String surname;
//    private String firstName;
//    private Calendar dateOfBirth;
//    private String previousLastName;
//    private String placeOfBirth;
//    private boolean individual;
//    private boolean organisation;
//    private String tradingName;
//    private String name;
//    private String status;
//    private String duplicateStatus;
//    private Boolean approvedDuplicate;
//	private String title;
//    
//    public TaxPayerDTO() {
//    }
//    
//    public TaxPayerDTO(IndividualType individualType,String tin) {
//        this.id = individualType.getId();
//        this.tin = tin;
//        this.surname = individualType.getLastName();
//        this.firstName = individualType.getFirstName();
//        this.setName(individualType.getTitle() + " " + individualType.getFirstName() + " "+individualType.getLastName() );
////        this.dateOfBirth = individualType.getDateOfBirth();
//        this.previousLastName = individualType.getPreviousLastName();
//        this.placeOfBirth = individualType.getPlaceOfBirth();
//        this.individual = true;
//        this.organisation = false;
//        this.status = individualType.getStatus();
//		this.title = individualType.getTitle();
//    }
//    
//    public TaxPayerDTO(OrganisationType organisationType,String tin) {
//        this.id = organisationType.getId();
//        this.tin = tin;
//        this.name = organisationType.getLegalName();      
//        this.individual = false;
//        this.organisation = true;
//        this.status = organisationType.getStatus();
//    }
//
//    public void setTin(String tin) {
//        this.tin = tin;
//    }
//
//    public String getTin() {
//        return tin;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setDateOfBirth(Calendar dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public Calendar getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setPreviousLastName(String previousLastName) {
//        this.previousLastName = previousLastName;
//    }
//
//    public String getPreviousLastName() {
//        return previousLastName;
//    }
//
//    public void setPlaceOfBirth(String placeOfBirth) {
//        this.placeOfBirth = placeOfBirth;
//    }
//
//    public String getPlaceOfBirth() {
//        return placeOfBirth;
//    }
//
//    public void setTradingName(String tradingName) {
//        this.tradingName = tradingName;
//    }
//
//    public String getTradingName() {
//        return tradingName;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setIndividual(boolean individual) {
//        this.individual = individual;
//    }
//
//    public boolean isIndividual() {
//        return individual;
//    }
//
//    public void setOrganisation(boolean organisation) {
//        this.organisation = organisation;
//    }
//
//    public boolean isOrganisation() {
//        return organisation;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
// 
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setApprovedDuplicate(Boolean approvedDuplicate) {
//        this.approvedDuplicate = approvedDuplicate;
//    }
//
//    public Boolean getApprovedDuplicate() {
//        return approvedDuplicate;
//    }
//
//    public void setDuplicateStatus(String duplicateStatus) {
//        this.duplicateStatus = duplicateStatus;
//    }
//
//    public String getDuplicateStatus() {
//        return duplicateStatus;
//    }
//	
//	public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//}
