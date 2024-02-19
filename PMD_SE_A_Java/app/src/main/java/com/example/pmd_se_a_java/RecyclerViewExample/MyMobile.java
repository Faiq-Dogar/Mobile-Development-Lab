package com.example.pmd_se_a_java.RecyclerViewExample;

public class MyMobile {

    private String Name,Company,Price;

    public MyMobile(String name, String company,String price)
    {
        Name = name;
        Company = company;
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public String getCompany() {
        return Company;
    }

    public String getPrice() {
        return Price;
    }
}