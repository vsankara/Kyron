package com.technobrain.trips.dropdownhelper;

import com.technobrain.trips.dto.CodeAndDescription;

import java.util.List;

import javax.ejb.Local;

@Local
public interface DropDownHelperLocal {
    List<CodeAndDescription> getDropDownList(String listName);

}
