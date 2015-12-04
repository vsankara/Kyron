package com.technobrain.trips.script.model;

import com.technobrain.trips.core.model.BaseNormalModelObject;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @ Crown Agents 2010
 *
 * Model class representing the table "SCR_COMM_SCRIPT".
 * 
 * @since       $Date: $
 * @version     $Revision: $
 * @author      $Author: Uma shankar kathinokkula$
 * 
 */
@Entity
@NamedQuery(name = "ScrCommScript.findAll", 
            query = "select o from ScrCommScript o")
@Table(name = "SCR_COMM_SCRIPT")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "USAGE_TYPE")
@DiscriminatorValue("Other")
public class ScrCommScript extends BaseNormalModelObject {
    @Column(name = "IS_UPDATED")
    private String isScriptUpdated;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "SCR_COMM_SCRIPT_SEQ")
    @SequenceGenerator(name = "SCR_COMM_SCRIPT_SEQ", 
                       sequenceName = "SCR_COMM_SCRIPT_SEQ", 
                       allocationSize = 1)
    @Column(nullable = false)
    private Long id;
    private char[] script;
    @Column(name = "SCRIPT_NAME")
    private String scriptName;
    @Column(name = "USAGE_TYPE", nullable = false)
    private String usageType;
    private String valid;

    public ScrCommScript() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public char[] getScript() {
        return script;
    }

    public void setScript(char[] script) {
        this.script = script;
    }

    public String getScriptName() {
        return scriptName;
    }

    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getUsageType() {
        return usageType;
    }

    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }

    public void setIsScriptUpdated(String isScriptUpdated) {
        this.isScriptUpdated = isScriptUpdated;
    }

    public String getIsScriptUpdated() {
        return isScriptUpdated;
    }
}
