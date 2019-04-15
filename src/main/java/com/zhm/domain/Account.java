package com.zhm.domain;

import java.io.Serializable;

/**
 * @author lzmtx
 * @date 2019/4/11 - 12:06
 */
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Double money;

    public Account() {
        super();
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
