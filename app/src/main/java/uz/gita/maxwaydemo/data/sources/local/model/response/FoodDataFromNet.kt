package uz.gita.maxwaydemo.data.sources.local.model.response

data class FoodDataFromNet(
    val id: Int,
    val categoryID: Int,
    val cost: Int,
    val description: String,
    val image: String,
    val name: String
)