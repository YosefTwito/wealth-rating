package com.example.wealthrating.rich;

import javax.persistence.*;

@Entity
@Table
public class Rich {

    @Id
    @SequenceGenerator(
            name = "rich_sequence",
            sequenceName = "rich_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rich_sequence"
    )
    private Long generatedID;
    private Long identity;
    private String firstName;
    private String lastName;
    private Long fortune;

    public Rich() {
    }

    public Rich(Long generatedID, Long identity, String firstName, String lastName, Long fortune) {
        this.generatedID = generatedID;
        this.identity = identity;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fortune = fortune;
    }

    public Rich(Long ID, String firstName, String lastName, Long fortune) {
        this.identity = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fortune = fortune;
    }

    public Long getGeneratedID() {
        return generatedID;
    }

    public void setGeneratedID(Long Id) {
        this.generatedID = Id;
    }

    public Long getIdentity() {
        return identity;
    }

    public void setIdentity(Long identity) {
        this.identity = identity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getFortune() {
        return fortune;
    }

    public void setFortune(Long fortune) {
        this.fortune = fortune;
    }

    @Override
    public String toString() {
        return "Rich{" +
                "Id=" + identity +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fortune=" + fortune +
                '}';
    }
}
