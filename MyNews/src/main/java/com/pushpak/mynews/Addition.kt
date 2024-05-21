package com.pushpak.mynews

data class Addition(val x: Int, val y: Int)

fun Addition.addTwoNumber(addition: Addition): Int {
    return addition.x + addition.y
}