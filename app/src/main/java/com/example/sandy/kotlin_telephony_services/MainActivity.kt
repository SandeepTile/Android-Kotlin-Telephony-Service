package com.example.sandy.kotlin_telephony_services

import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tManager=getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        var list= mutableListOf<String>()

        list.add(tManager.imei)
        list.add(tManager.dataNetworkType.toString())
        list.add(tManager.simSerialNumber)
        list.add(tManager.simOperatorName)
        list.add(tManager.simCountryIso)


        // CONNECTIVITY_SERVICE

        var cManager=getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if(cManager.activeNetworkInfo!=null)
            list.add(cManager.activeNetworkInfo.isConnected.toString())
        else
            list.add("false")
        var myadapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,list)
        lv1.adapter=myadapter
    }
}
