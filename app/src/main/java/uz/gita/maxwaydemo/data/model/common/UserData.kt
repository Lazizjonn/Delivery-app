package uz.gita.maxwaydemo.data.model.common

import javax.inject.Singleton

@Singleton
data class UserData(
    val id: Int,
    val name: String? = null,
    val surname: String? = null,
    val phone: String? = null,
    val email: String? = null,
    val geoPoint: String? = null,
    val cards: List<CreditCardsData>? = null
)


