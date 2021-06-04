/**
 * Calsse usada para manipular o shared preference da minha aplicação
 * com isso posso salvar os dados para usar em outras telas
 * **/

package com.norbertto.motivation.infra

import android.content.Context

class SecurityPreferences(val context: Context) {
    //assim eu consigo salvar dados pequenos que não mudam no meu app para trabalhar em outra tela
    //o Context.MODE_PRIVATE faz com que as informações não sejam acessadas por outros apps
    private val mSharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String){
        mSharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String{
        //usando um operador elvis ?: não é preciso usar o else no retorno
        //a função getString() do shared preference passa a chave, e caso essa chave
        //não seja encontrata você define o que passar como no exemplo usamos uma string vazia ""
        return mSharedPreferences.getString(key, "") ?: ""
    }
}