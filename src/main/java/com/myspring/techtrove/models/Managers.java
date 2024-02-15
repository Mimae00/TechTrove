package com.myspring.techtrove.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity(name = "manager")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Managers {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manager_id;

    private String manager_name;
    private String manager_work_title;
    private String manager_email;
    private String manager_phone_number;
    private String manager_full_address;


    public Long getManager_id() {
        return manager_id;
    }

    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getManager_work_title() {
        return manager_work_title;
    }

    public void setManager_work_title(String manager_work_title) {
        this.manager_work_title = manager_work_title;
    }

    public String getManager_email() {
        return manager_email;
    }

    public void setManager_email(String manager_email) {
        this.manager_email = manager_email;
    }

    public String getManager_phone_number() {
        return manager_phone_number;
    }

    public void setManager_phone_number(String manager_phone_number) {
        this.manager_phone_number = manager_phone_number;
    }

    public String getManager_full_address() {
        return manager_full_address;
    }

    public void setManager_full_address(String manager_full_address) {
        this.manager_full_address = manager_full_address;
    }
}
