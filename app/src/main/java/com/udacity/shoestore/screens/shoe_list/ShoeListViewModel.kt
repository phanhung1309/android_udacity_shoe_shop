package com.udacity.shoestore.screens.shoe_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = listOf(
            Shoe(
                "ULTRABOOST LIGHT SHOES",
                43.0,
                "Adidas",
                "Experience epic energy with the new Ultraboost Light, our lightest Ultraboost ever. The magic lies in the Light BOOST midsole, a new generation of adidas BOOST. Its unique molecule design achieves the lightest BOOST foam to date. With hundreds of BOOST capsules bursting with energy and ultimate cushioning and comfort, some feet really can have it all.",
                listOf("https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/3d0fbb4a6cb847c39783af870085d852_9366/Ultraboost_Light_Shoes_Black_GY9351.jpg")
            ),
            Shoe(
                "NMD_R1 PRIMEBLUE SHOES",
                45.0,
                "Adidas",
                "Pack your bag, lace up and get going. City adventures beckon in these NMD_R1 shoes. An update to an acclaimed '80s runner from the adidas archive, these modern trainers have a soft, stretchy knit upper and energy-returning Boost cushioning for all-day comfort. Bold colour and signature midsole plugs make a statement, so wherever you're headed, you're sure to show up in style.\n" +
                        "\n" +
                        "This product is made with Primeblue, a high-performance recycled material made in part with Parley Ocean Plastic. 50% of the upper is textile, 75% of the textile is Primeblue yarn. No virgin polyester.",
                listOf("https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/dcada9c149294d6dac99ad0800cb5fe5_9366/NMD_R1_Primeblue_Shoes_Black_GZ9257.jpg")
            ),
            Shoe(
                "FLUIDFLOW 3.0 SHOES",
                42.5,
                "Adidas",
                "Life doesn't stand still. Now you won't have to either with these ultra-modern adidas sneakers in your lineup. The soft knit upper is lined for comfort, and lightweight Bounce cushioning keeps you going and going. Sporty yet refined, these sneakers transcend dress codes.",
                listOf("https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/12d46264a94c439f81f25c8af33a1201_9366/Fluidflow_3.0_Shoes_White_IG9841.jpg")

            )
        )
    }
}