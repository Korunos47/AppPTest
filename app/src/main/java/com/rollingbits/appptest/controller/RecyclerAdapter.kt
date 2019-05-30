package com.rollingbits.appptest.controller

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.rollingbits.appptest.R
import com.rollingbits.appptest.extensions.inflate
import com.rollingbits.appptest.model.UserDataModel
import com.rollingbits.appptest.view.DetailUserView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class RecyclerAdapter(private val user: List<UserDataModel>):
    RecyclerView.Adapter<RecyclerAdapter.UserHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): UserHolder {
        val inflatedView = p0.inflate(R.layout.recyclerview_item, false)
        return UserHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return user.size
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val userData = user[position]
        holder.bindUser(userData)
    }

    class UserHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener{
        private var view: View = v
        private lateinit var userData: UserDataModel

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val context = itemView.context
            val showDetailUserIntent = Intent(context, DetailUserView::class.java)
            showDetailUserIntent.putExtra("data",userData)
            showDetailUserIntent.putExtra("position",adapterPosition)

            context.startActivity(showDetailUserIntent)
        }

        fun bindUser(userData: UserDataModel) {
            this.userData = userData

            view.nameTV.text = userData.name
            view.companyTV.text = userData.company
            view.emailTV.text = userData.email
            view.websiteTV.text = userData.website

            if(checkInternetConnection(itemView.context))
                Picasso.get().load(userData.smallImageURL).into(view.userAvatar)
        }

        private fun checkInternetConnection(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
            return activeNetwork?.isConnectedOrConnecting == true
        }
    }
}