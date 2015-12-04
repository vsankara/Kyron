package com.technobrain.trips.entity.delegate;

import com.technobrain.trips.core.delegate.BusinessDelegate;


/**
 * Crown Agents 2008
 * 
 * This is a delegate that reduces the coupling between presentation tiers of
 * registration and relevant EJB.
 * 
 * @since $Date: 3/24/2009 10:09:35 AM$
 * @version $Revision: 18$
 * @author $Author: Ashok Dorairaj$
 * 
 * $Log[1]:
 *  18   TRIPS2    1.17        3/24/2009 10:09:35 AM  Ashok Dorairaj  Adding a
 *       reference number field to Transport table
 * $
 * 
 */

public class EntityDelegate extends BusinessDelegate {
    
//    public List<SelectItem> loadEntField(String fieldType) {
//        List entFieldList = getEntityService().getEntFieldByFieldType(fieldType);
//        List<SelectItem> fieldDescList = new ArrayList();
//        for(int fldLen = 0; fldLen < entFieldList.size(); fldLen++) {
//            EntField entField = (EntField) entFieldList.get(fldLen);
//            fieldDescList.add(new SelectItem(entField.getField(),entField.getDescription()));
//        }
//        return fieldDescList;
//    }
// 
//    public List<SelectItem> loadEntFieldById(String fieldType) {
//        List entFieldList = getEntityService().getEntFieldByFieldType(fieldType);
//        List<SelectItem> fieldDescList = new ArrayList();
//        for(int fldLen = 0; fldLen < entFieldList.size(); fldLen++) {
//            EntField entField = (EntField) entFieldList.get(fldLen);
//            fieldDescList.add(new SelectItem(entField.getId().toString(),entField.getDescription()));
//        }
//        return fieldDescList;
//    }
//   
//    public List<SelectItem> loadAllEntField() {
//        List entFieldList = getEntityService().findAllEntField();
//        List<SelectItem> fieldDescList = new ArrayList();
//        for(int fldLen = 0; fldLen < entFieldList.size(); fldLen++) {
//            EntField entField = (EntField) entFieldList.get(fldLen);
//            fieldDescList.add(new SelectItem(entField.getId(),entField.getDescription()));
//        }
//        return fieldDescList;
//    }
//
//    public List<SelectItem> loadAllEntType() {
//        List entTypeList = getEntityService().findAllEntType();
//        List<SelectItem> fieldDescList = new ArrayList();
//        for(int fldLen = 0; fldLen < entTypeList.size(); fldLen++) {
//            EntType entType = (EntType) entTypeList.get(fldLen);
//            fieldDescList.add(new SelectItem(entType.getCode(),entType.getDescription()));
//        }
//        return fieldDescList;
//    }
//    
//    public List<SelectItem> loadEntFieldByType(String code) {
//        List entFieldList = getEntityService().getEntFieldByType(code);
//        List<SelectItem> fieldDescList = new ArrayList();
//        for(int fldLen = 0; fldLen < entFieldList.size(); fldLen++) {
//            EntField entField = (EntField) entFieldList.get(fldLen);
//            fieldDescList.add(new SelectItem(entField.getId(),entField.getDescription()));
//        }
//        return fieldDescList;
//    }
//    
//    public List<SelectItem> findEntTypeByCode(Object code) {
//        EntType entType = getEntityService().getEntTypeByCode(code.toString()); 
//        List <SelectItem> entTypeList = new ArrayList();
//        entTypeList.add(new SelectItem(entType.getCode(), entType.getDescription()));
//        return entTypeList;
//    }
//    
//    public List<SelectItem> findEntFieldById(Object id) {
//        EntField entField = getEntityService().findEntFieldById(new Long(id.toString())); 
//        List <SelectItem> entFieldList = new ArrayList();
//        entFieldList.add(new SelectItem(entField.getId(), entField.getDescription()));
//        return entFieldList;
//    }
//    
//    public List<SelectItem> getEntFieldDescriptionById(Object id) {
//        EntField entField = getEntityService().findEntFieldById(new Long(id.toString())); 
//        List <SelectItem> entFieldList = new ArrayList();
//        entFieldList.add(new SelectItem(entField.getId().toString(),entField.getDescription()));
//        return entFieldList;
//    }
//    
//    public String findEntityNameById(Long id) {
//        return getEntityService().findEntityName(id);
//    }
//    
//    public Long findEntIdFromTIN(String tin) {
//        return getEntityService().findEntIdFromTIN(tin);
//    }
//    
//    public ContainerInputType loadContainerInputType(Long containerId) {
//        if(containerId == null)
//            return null;
//        ContainerInputType inputType = getEntityService().findContainerInputType(containerId);
//        return inputType;
//    }
//    
//    public OrganisationType findOrganisationInputType(Long id) {
//        if(id == null)
//            return null;
//        return getEntityService().findOrganisationInputType(id);
//    }
//    
//    public String findOrganisationLegalName(Long id) {
//        if(id == null)
//            return null;
//        return getEntityService().findOrganisationLegalName(id);
//    }
//    
//    public String saveOrUpdateContainer(ContainerInputType container) throws TripsValidationException {
//        String containerNumber = null;
//        containerNumber = getEntityService().saveOrUpdateContainer(container);
//        if(containerNumber == null)
//            throw new TripsValidationException("ContainerDetails.errorMessage.CannotBeSaved");
//        return containerNumber;    
//    }
//
//    public String saveAircraftTransportInputType(AircraftTransportInputType aircraftTransportInputType) {
//        String refNumber = null;
//        refNumber = getEntityService().saveOrUpdateTransportAircraft(aircraftTransportInputType);
//        return refNumber;
//    }       
//    
//    
//    public String saveVesselTransportInputType(VesselTransportInputType vesselTransportInputType) {
//        String refNumber = null;
//        refNumber = getEntityService().saveOrUpdateTransportVessel(vesselTransportInputType);
//        return refNumber;
//    }       
//
//    public String saveVehicleTransportInputType(VehicleTransportInputType vehicleTransportInputType) {
//        String refNumber = null;
//        refNumber = getEntityService().saveOrUpdateTransportVehicle(vehicleTransportInputType);
//        return refNumber;
//    }       
//
//    public String saveTrainTransportInputType(TrainTransportInputType trainTransportInputType) {
//        String refNumber = null;
//        refNumber = getEntityService().saveOrUpdateTransportTrain(trainTransportInputType);
//        return refNumber;
//    }       
//
//    
//    public AircraftTransportInputType loadAircraftTransportInputType(Long id){
//        return getEntityService().findTransportAircraftInputType(new Long(id.toString())); 
//    }
//    
//
//    public VehicleTransportInputType loadVehicleTransportInputType(Long id){
//        return getEntityService().findTransportVehicleInputType(new Long(id.toString())); 
//    }
//
//
//    public VesselTransportInputType loadVesselTransportInputType(Long id){
//        return getEntityService().findTransportVesselInputType(new Long(id.toString())); 
//    }
//
//    public TrainTransportInputType loadTrainTransportInputType(Long id){
//        return getEntityService().findTransportTrainInputType(new Long(id.toString())); 
//    }
//    
//    /**
//     * Locates the primary address for a entity of whatever type, wraps it to address bean and returns it.
//     * @param primaryKey i.e the ENTITY ID or ENT_ENTITY
//     * @return a entityAddressBean
//     */
////    public EntityAddressBean findPrimaryAddressBean(Long  primaryKey) {
////        EntityAddressSummary addressSummary = null;
////        EntityAddressBean bean = new EntityAddressBean();
////        //TODO - RevAccCleanup - check with Radhika/Uma        
//////        addressSummary =  getEntityService().findEntityPrimaryAddress(primaryKey);
////        if(addressSummary == null)
////            return bean;
////        if(log.isDebugEnabled())log.debug(addressSummary.getStreetName());
////        
////        bean.setStreetName(addressSummary.getStreetName());
////        bean.setCountry(addressSummary.getCountry());
////        bean.setCounty(addressSummary.getCounty());
////        bean.setPostalCode(addressSummary.getPostalCode());
////        bean.setEntityName(addressSummary.getEntityName());
////        bean.setEntityTin(addressSummary.getEntityTin());
////        bean.setCity(addressSummary.getCity());
////        bean.setCountryName(getRefCodeAssemblerService().findRefDescription(addressSummary.getCountry(), DataReference.COUNTRY));
////        return bean;
////    }
//    
//    /**
//     * Locates the address for an entity of whatever type and returns it.
//     * @param entityID the ENTITY ID or ENT_ENTITY
//     * @return
//     */
//     //TODO - RevAccCleanup    
////    public EntityAddressSummary findAddressSummary(Long entityID) {
////        return getEntityService().findEntityPrimaryAddress(entityID);
////    }
//    
//    /**
//     * Finds the entity details with the address summary.
//     * 
//     * @param entityId
//     * @return
//     */
//     //TODO - RevAccCleanup     
////    public EntityDetails findEntityDetails(Long entityId) {
////        return getEntityService().findEntityDetails(entityId);
////    }
//    
//    public CustomsEntityInputType generateCustomsEntityInputType(Long id) {
//        return getEntityService().generateCustomsEntityInputType(id);
//    }
//    
//    public AddressType includeAddressAsCSV(AddressType addrType) {
//        return getEntityService().includeAddressAsCSV(addrType);
//    }
}
