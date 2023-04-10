package com.neu.shop.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 
 * @TableName equipment
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipment implements Serializable {
    /**
     * 
     */
    private String equipmentNumber;

    /**
     * 
     */
    private String equipmentType;

    /**
     * 
     */
    private String equipmentProduct;

    /**
     * 
     */
    private String equipmentWear;

    /**
     * 
     */
    private String equipmentIntroduction;

    private static final long serialVersionUID = 1L;


    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Equipment other = (Equipment) that;
        return (this.getEquipmentNumber() == null ? other.getEquipmentNumber() == null : this.getEquipmentNumber().equals(other.getEquipmentNumber()))
            && (this.getEquipmentType() == null ? other.getEquipmentType() == null : this.getEquipmentType().equals(other.getEquipmentType()))
            && (this.getEquipmentProduct() == null ? other.getEquipmentProduct() == null : this.getEquipmentProduct().equals(other.getEquipmentProduct()))
            && (this.getEquipmentWear() == null ? other.getEquipmentWear() == null : this.getEquipmentWear().equals(other.getEquipmentWear()))
            && (this.getEquipmentIntroduction() == null ? other.getEquipmentIntroduction() == null : this.getEquipmentIntroduction().equals(other.getEquipmentIntroduction()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEquipmentNumber() == null) ? 0 : getEquipmentNumber().hashCode());
        result = prime * result + ((getEquipmentType() == null) ? 0 : getEquipmentType().hashCode());
        result = prime * result + ((getEquipmentProduct() == null) ? 0 : getEquipmentProduct().hashCode());
        result = prime * result + ((getEquipmentWear() == null) ? 0 : getEquipmentWear().hashCode());
        result = prime * result + ((getEquipmentIntroduction() == null) ? 0 : getEquipmentIntroduction().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", equipmentNumber=").append(equipmentNumber);
        sb.append(", equipmentType=").append(equipmentType);
        sb.append(", equipmentProduct=").append(equipmentProduct);
        sb.append(", equipmentWear=").append(equipmentWear);
        sb.append(", equipmentIntroduction=").append(equipmentIntroduction);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}