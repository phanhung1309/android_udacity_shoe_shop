package com.udacity.shoestore.screens.shoe_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    var shoeName: String = ""
    var shoeSize: String = ""
    var shoeCompany: String = ""
    var shoeDescription: String = ""

    init {
        _shoeList.value = createDefaultShoeList()
    }

    private fun createDefaultShoeList(): List<Shoe> {
        return listOf(
            Shoe(
                "Nike Air Max",
                43.0,
                "Nike",
                "The Nike Air Max is a classic shoe that has been around for decades."
            ),
            Shoe(
                "Adidas Superstar",
                41.0,
                "Adidas",
                "The Adidas Superstar is a popular shoe that has been worn by many celebrities."
            ),
            Shoe(
                "Vans Old Skool",
                42.5,
                "Vans",
                "The Vans Old Skool is a timeless shoe that is perfect for casual wear."
            )
        )
    }

    fun validateShoeDetailInput(): Boolean {
        return shoeName.isNotEmpty() && shoeSize.isNotEmpty() && shoeCompany.isNotEmpty() && shoeDescription.isNotEmpty()
    }

    fun saveShoeDetail() {
        val newShoe = Shoe(shoeName, shoeSize.toDouble(), shoeCompany, shoeDescription, listOf(""))
        val newShoeList = _shoeList.value?.toMutableList() ?: mutableListOf()
        newShoeList.add(newShoe)
        _shoeList.value = newShoeList
    }

    fun resetNewShoeDetails() {
        shoeName = ""
        shoeSize = ""
        shoeCompany = ""
        shoeDescription = ""
    }
}