package com.github.MrPatronO.carworkshop.models;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private int phoneNumber;

    private String nip;
    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "client")
    private List<Repair> repairs;

    public Client() {
    }

    Client(Long clientId, String name, String email, int phoneNumber, String nip, String address, List<Repair> repairs) {
        this.clientId = clientId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.nip = nip;
        this.address = address;
        this.repairs = repairs;
    }


    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientId == client.clientId && phoneNumber == client.phoneNumber && name.equals(client.name) && email.equals(client.email) && nip.equals(client.nip) && address.equals(client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.clientId, this.name, this.email, this.phoneNumber, this.nip, this.address);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", nip='" + nip + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}