package com.github.MrPatronO.carworkshop.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClientDto {

    private int clientId;
    @NotBlank(message = "Name may not be blank")
    private String name;
    @NotBlank(message = "Email may not be blank")
    private String email;
    @NotBlank(message = "Phone number may not be blank")
    @Size(max = 11)
    private int phoneNumber;

    @Size(max = 10)
    private String nip;
    @NotBlank(message = "Address may not be blank")
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
