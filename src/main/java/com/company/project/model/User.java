package com.company.project.model;

import javax.persistence.*;

public class User {
    @Column(name = "u_name")
    private String uName;

    @Column(name = "u_destination")
    private String uDestination;

    @Id
    private String uId;

    /**
     * @return u_name
     */
    public String getuName() {
        return uName;
    }

    /**
     * @param uName
     */
    public void setuName(String uName) {
        this.uName = uName;
    }

    /**
     * @return u_destination
     */
    public String getuDestination() {
        return uDestination;
    }

    /**
     * @param uDestination
     */
    public void setuDestination(String uDestination) {
        this.uDestination = uDestination;
    }

    /**
     * @return u_id
     */
    public String getuId() {
        return uId;
    }

    /**
     * @param uId
     */
    public void setuId(String uId) {
        this.uId = uId;
    }
}