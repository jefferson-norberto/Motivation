package com.norbertto.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.norbertto.motivation.R
import com.norbertto.motivation.infra.MotivationConstats
import com.norbertto.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity(), View.OnClickListener {
     private lateinit var mSecurityPreferences: SecurityPreferences

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         //recuperando o nome do usuário pelo sharedPreferences
         mSecurityPreferences = SecurityPreferences(this)
         textName.text = mSecurityPreferences.getString(MotivationConstats.KEY.PERSON_NAME)

         hideActionBar()

         buttonNewPhrase.setOnClickListener(this)
         imageAll.setOnClickListener(this)
         imageHappy.setOnClickListener(this)
         imageMorning.setOnClickListener(this)
    }

     private fun hideActionBar() {
         if(supportActionBar != null){
             supportActionBar!!.hide()
         }
     }

     override fun onClick(view: View?) {
         val id = view?.id
         val listFilter = listOf(R.id.imageAll, R.id.imageHappy, R.id.imageMorning)

         if (id == R.id.buttonNewPhrase){
            handleNewPhrase()
         }else if(id in listFilter){
             handleFilter(id!!)
         }
     }

     private fun handleNewPhrase(){

     }

     private fun handleFilter(id: Int){
         imageAll.setColorFilter(resources.getColor(R.color.colorAccent))
         imageHappy.setColorFilter(resources.getColor(R.color.colorAccent))
         imageMorning.setColorFilter(resources.getColor(R.color.colorAccent))

         when (id){
             R.id.imageAll ->{
                 imageAll.setColorFilter(resources.getColor(R.color.white))
             }
             R.id.imageHappy ->{
                 imageHappy.setColorFilter(resources.getColor(R.color.white))
             }
             R.id.imageMorning ->{
                imageMorning.setColorFilter(resources.getColor(R.color.white))
             }
         }

     }
 }