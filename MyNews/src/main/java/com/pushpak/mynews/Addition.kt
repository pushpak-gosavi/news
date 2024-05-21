package com.pushpak.mynews

data class Addition(val x: Int, val y: Int)

fun Addition.addTwoNumber(): Int {
    return this.x + this.y
}