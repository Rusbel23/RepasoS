package com.demojavadj.appweb.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;
@Entity
@Table (name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "El nombre es obligatorio")
    @Column(nullable = false, length =20)
    private String name;
    @NotEmpty(message = "El Apellido paterno es obligatorio")
    @Column(name = "first_name", length =50)
    private String firstName;
    @NotEmpty(message = "El Apellido materno es obligatorio")
    @Column(name = "last_name", length =50)
    private String lastName;
    @Column(unique = false, nullable = true,length =20)
    private String email;
    @NotEmpty(message = "El numero es obligatorio")
    @Column(unique = true)
    private String phone;
    @NotEmpty(message = "La dirección es obligatorio")
    private String address;
    private String city;
    private boolean state;
    private String zip;

    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "update_at")
    private Date updateAt;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
