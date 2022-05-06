package uz.gita.maxwaydemo.data.model.common

import javax.inject.Singleton

@Singleton
data class MyUser(
    var id: String,
    var name: String,
    var surname: String,
    var phone: String,
    var email: String? = null,
    val geoPoint: String? = null,
    val cards: List<CreditCardsData>? = null
) {

    constructor() : this("","","","")
}

