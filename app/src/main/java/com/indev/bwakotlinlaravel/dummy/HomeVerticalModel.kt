package com.indev.bwakotlinlaravel.dummy

class HomeVerticalModel (tittle:String, price:String, src:String, rating:Float) {

    var tittle = ""
    var price = ""
    var src = ""
    var rating = 0f

    init {
        this.tittle = tittle
        this.price = price
        this.src = src
        this.rating = rating
    }
}