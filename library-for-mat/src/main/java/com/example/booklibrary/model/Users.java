package com.example.booklibrary.model;

import javax.persistence.*;

@Entity
@Table(name = "users_")
public class Users {
    private Integer id;
    private String firstName;
    private String lastName;
    private String mobile_no;
    private Integer userCount;
    public Users() {
    }

    public Users(Integer id, String firstName, String lastName,String mobile_no) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile_no=mobile_no;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column
    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
    @Column()
    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {

        this.userCount = userCount;
    }
}
