package com.rollingbits.appptest.model

import java.io.Serializable

class UserDataModel(val name: String,
                    val company: String,
                    val smallImageURL: String,
                    val largeImageURL: String,
                    val email: String,
                    val website: String,
                    val birthdate: String,
                    val phone: HashMap<String,UserPhone>,
                    val address: HashMap<String,UserAddress>): Serializable{

    private val favorite: Boolean get() = false

    data class UserPhone(
        val work: String,
        val home: String,
        val mobile: String
    )

    data class UserAddress(
        val street: String,
        val city: String,
        val state: String,
        val country: String,
        val zip: String,
        val latitude: String,
        val longitude: String
    )
}
