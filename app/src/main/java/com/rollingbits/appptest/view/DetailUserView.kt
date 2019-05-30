package com.rollingbits.appptest.view

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rollingbits.appptest.R
import com.rollingbits.appptest.model.UserDataModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detailuserview.*
import java.util.*
import kotlin.collections.ArrayList

class DetailUserView: AppCompatActivity(){
    private lateinit var userData: UserDataModel
    private var position: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailuserview)

        userData = intent.getSerializableExtra("data") as UserDataModel
        position = intent.getIntExtra("position",0)

        nameTV.text = userData.name
        companyTV.text = userData.company
        emailTV.text = userData.email
        websiteTV.text = userData.website
        birthdateTV.text = userData.birthdate
        phoneWorkTV.text = userData.phone["work"].toString()

        //phoneWorkTV.text =userData.phone.getValue(userData.phone.)
        phoneHomeTV.text = userData.phone["home"].toString()
        phoneMobileTV.text = userData.phone["mobile"].toString()
        streetTV.text = userData.address["street"].toString()
        cityTV.text = userData.address["city"].toString()
        stateTV.text = userData.address["state"].toString()
        countryTV.text = userData.address["country"].toString()
        zipTV.text = userData.address["zip"].toString()
        latitudeTV.text = userData.address["latitude"].toString()
        longitudeTV.text = userData.address["longitude"].toString()

        if(checkInternetConnection(this))
            if(userData.largeImageURL.isNotEmpty()) {
                Picasso.get().load(userData.largeImageURL).into(avatarIV)
            }
    }

    private fun checkInternetConnection(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
}