package com.norbertto.motivation.infra

import android.content.Context

class SecurityPreferences(val context: Context) {
    //assim eu consigo salvar dados pequenos que não mudam no meu app para trabalhar em outra tela
    //o Context.MODE_PRIVATE faz com que as informações não sejam acessadas por outros apps
    private val mSharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String){
        mSharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String){

    }
}