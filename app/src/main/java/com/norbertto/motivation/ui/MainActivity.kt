 package com.norbertto.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.norbertto.motivation.R
import com.norbertto.motivation.infra.MotivationConstats
import com.norbertto.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {
     private lateinit var mSecurityPreferences: SecurityPreferences

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSecurityPreferences = SecurityPreferences(this)
        textName.text = mSecurityPreferences.getString(MotivationConstats.KEY.PERSON_NAME)
    }
}