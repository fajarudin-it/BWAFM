package com.indev.bwakotlinlaravel.dummy

class HomeModel (tittle:String, src:String, rating:Float) {

    var tittle = ""
    var src = ""
    var rating = 0f

    init {
        this.tittle = tittle
        this.src = src
        this.rating = rating
    }
}