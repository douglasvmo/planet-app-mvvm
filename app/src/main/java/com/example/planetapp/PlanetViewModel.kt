package com.example.planetapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData


class PlanetViewModel: ViewModel() {
    private val _planets =  MutableLiveData<List<Planet>>()
    val data: LiveData<List<Planet>> = _planets


    fun getData(){
        val mercury = Planet("Mercury", "0 Moons", R.drawable.mercury)
        val venus = Planet("Venus", "0 Moons", R.drawable.venus)
        val earth = Planet("Earth", "1 Moons", R.drawable.earth)
        val mars = Planet("Mars", "2 Moons", R.drawable.mars)
        val jupiter = Planet("Jupiter", "79 Moons", R.drawable.jupiter)
        val saturn = Planet("Saturn", "83 Moons", R.drawable.saturn)
        val uranus = Planet("Uranus", "27 Moons", R.drawable.uranus)
        val neptune = Planet("Neptune", "14 Moons", R.drawable.neptune)

        _planets.value = listOf(mercury, venus, earth, mars, jupiter, saturn, uranus, neptune)
    }
}