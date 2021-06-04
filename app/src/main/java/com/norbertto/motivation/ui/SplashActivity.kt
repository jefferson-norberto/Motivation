package com.norbertto.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.norbertto.motivation.R
import com.norbertto.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {
    //usado para intanciar a variavel mais tarde, sem isso não consigo
    private lateinit var mSecurityPreference: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurityPreference = SecurityPreferences(this)

        if(supportActionBar != null){
            supportActionBar!!.hide()
        }

        buttonSalve.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        val id = view?.id
        if(id == R.id.buttonSalve){
            //logica de négocio
            handleSave()
        }
    }

    private fun handleSave(){
        val name = editName.text.toString()
        if(name != ""){

            mSecurityPreference.storeString("name", name)
            //iniciando uma nova tela
            startActivity(Intent(this, MainActivity::class.java))
        }else{
            val mensage = Toast.makeText(this, "Informe o seu nome!", Toast.LENGTH_LONG)
            mensage.setGravity(Gravity.CENTER, 0, 0)
            mensage.show()
        }
    }
}