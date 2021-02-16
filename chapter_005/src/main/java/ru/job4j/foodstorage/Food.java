package ru.job4j.foodstorage;

import java.util.Date;

/**
 * Класс продукта Food
 */
public class Food {
   private String name;
    private Date expireDate;
    private Date createDate;
    private Double price;
    private Integer discount;

    /**
     * Конструктор Продукта
     * @param name имя продукта
     * @param expireDate дата окончания срока годности
     * @param createDate дата изготволения продукта
     * @param price цена продукта
     * @param discount скидка
     */
    public Food(String name, Date expireDate, Date createDate, Double price, Integer discount) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }


    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", expireDate=" + expireDate
                + ", createDate=" + createDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}
