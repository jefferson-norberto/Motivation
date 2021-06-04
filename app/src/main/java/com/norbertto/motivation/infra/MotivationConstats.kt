/**
 * Classe usada para criar as constantes da minha aplicação
 * **/

package com.norbertto.motivation.infra

//Para não ser instaciada usa o private constructor()
class MotivationConstats private constructor(){
    object KEY{
        val PERSON_NAME = "name"
    }

    object PHRASEFILTER{
        val ALL = 1
        val HAPPY = 2
        val MORNING = 3
    }
}