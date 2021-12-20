package com.example.wealthrating.rich;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

    private Long id;

    @JsonProperty("personalInfo")
    private personalInfo personInfo;

    @JsonProperty("financialInfo")
    private financialInfo financInfo;

    public Person() {
    }

    public Person(Long id, String fName, String lName, String city, Long cash, int numOfAssets) {
        this.id = id;
        this.personInfo = new personalInfo(fName, lName, city);
        this.financInfo = new financialInfo(cash, numOfAssets);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public personalInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(personalInfo personInfo) {
        this.personInfo = personInfo;
    }

    public financialInfo getFinancInfo() {
        return financInfo;
    }

    public void setFinancInfo(financialInfo financInfo) {
        this.financInfo = financInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", personInfo=" + personInfo +
                ", financInfo=" + financInfo +
                '}';
    }
}
