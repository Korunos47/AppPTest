package com.rollingbits.appptest.model

class UserDataModel {

    data class UserData(
        val name: String,
        val company: String,
        val favorite: Boolean,
        val smallImageURL: String,
        val largeImageURL: String,
        val email: String,
        val website: String,
        val birthday: String,
        val phone: List<UserPhone>,
        val address: List<UserAddress>
    ) {
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
}

