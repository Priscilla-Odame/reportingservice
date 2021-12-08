package reportingservice.dto;

import reportingservice.entities.Order;
import reportingservice.enums.Side;
import reportingservice.enums.Status;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class OrderDto {

    private String id;

    private String product;

    private int quantity;

    private Double price;

    private Side side;

    @Enumerated(EnumType.STRING)
    private Status status;

    public OrderDto(String id, String product, int quantity, Double price, Side side, Status status) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.side = side;
        this.status = status;
    }

    public OrderDto() {
    }

    public String getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }



}
