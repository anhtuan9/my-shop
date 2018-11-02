package tuantienti.model;

import javax.persistence.*;
import javax.persistence.GenerationType;
import java.io.File;
import java.util.List;

@Entity
@Table(name = "product")
public class product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;


    private String name;
    private Double price;
    private String cmt;
    private String producer;

    @OneToMany(targetEntity = product.class)
    private List<product> productlist;

    public product() {
    }

    public product(String name, Double price, String cmt, String producer) {
        this.name = name;
        this.price = price;
        this.cmt = cmt;
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    public Double getPrice() {
        return price;
    }

    public String getCmt() {
        return cmt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<product> getProductlist() {
        return productlist;
    }

    public void setProductlist(List<product> productlist) {
        this.productlist = productlist;
    }
}