package com.github.MrPatronO.carworkshop.dtos;

public class ClientDto {

    private int clientId;

    private String name;

    private String email;

    private int phoneNumber;

    private String nip;

    private String address;


    public long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = Math.toIntExact(clientId);
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
}
