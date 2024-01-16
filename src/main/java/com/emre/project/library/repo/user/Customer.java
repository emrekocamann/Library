package com.emre.project.library.repo.user;

import lombok.Getter;


@Getter
public class Customer extends SystemUser{

    private  final  String firstname;
    private  final  String lastname;
    private  final  String address;
    private  final  String postcode;
    private  final  String city;
    private  final  String email;



    public Customer(Integer id, String username, String password, String firstname, String lastname, String address, String postcode, String city, String email) {
        super(id, username, password);
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.postcode = postcode;
        this.city = city;
        this.email = email;
    }


}
