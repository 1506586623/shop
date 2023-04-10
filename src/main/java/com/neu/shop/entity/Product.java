package com.neu.shop.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName product
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 商品编号
     */
    private Integer productNo;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 预览图
     */
    private String image;

    /**
     * 商品描述
     */
    private String productDes;

    /**
     * 商品类型
     */
    private String productType;

    /**
     * 商品价格
     */
    private Double productPrice;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 评论
     */
    private String commit;

    /**
     * 店铺
     */
    private String store;

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
        Product other = (Product) that;
        return (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductNo() == null ? other.getProductNo() == null : this.getProductNo().equals(other.getProductNo()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getProductDes() == null ? other.getProductDes() == null : this.getProductDes().equals(other.getProductDes()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getProductPrice() == null ? other.getProductPrice() == null : this.getProductPrice().equals(other.getProductPrice()))
            && (this.getStock() == null ? other.getStock() == null : this.getStock().equals(other.getStock()))
            && (this.getCommit() == null ? other.getCommit() == null : this.getCommit().equals(other.getCommit()))
            && (this.getStore() == null ? other.getStore() == null : this.getStore().equals(other.getStore()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductNo() == null) ? 0 : getProductNo().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getProductDes() == null) ? 0 : getProductDes().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getProductPrice() == null) ? 0 : getProductPrice().hashCode());
        result = prime * result + ((getStock() == null) ? 0 : getStock().hashCode());
        result = prime * result + ((getCommit() == null) ? 0 : getCommit().hashCode());
        result = prime * result + ((getStore() == null) ? 0 : getStore().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", productNo=").append(productNo);
        sb.append(", productName=").append(productName);
        sb.append(", image=").append(image);
        sb.append(", productDes=").append(productDes);
        sb.append(", productType=").append(productType);
        sb.append(", productPrice=").append(productPrice);
        sb.append(", stock=").append(stock);
        sb.append(", commit=").append(commit);
        sb.append(", store=").append(store);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}