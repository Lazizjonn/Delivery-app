package uz.gita.maxwaydemo.data.sources.model.response

data class FoodDataFromNet(
    val id: Int? = 0,
    val categoryID: Int?=0,
    val cost: Int?=0,
    val description: String?="",
    val image: String?="",
    val name: String?=""
)