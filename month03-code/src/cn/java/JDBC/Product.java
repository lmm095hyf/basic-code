package cn.java.JDBC;

import java.util.Objects;

/**
 *
 create table product(
 productcode int,
 pname Varchar(32),
 quantity int
 );
 */
public class Product {
    private int productcode;
    private String pname;
    private int quantity;

    public int getProductcode() {
        return productcode;
    }

    public void setProductcode(int productcode) {
        this.productcode = productcode;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productcode=" + productcode +
                ", pname='" + pname + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productcode == product.productcode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productcode);
    }
}
