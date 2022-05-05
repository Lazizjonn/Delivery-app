package uz.gita.maxwaydemo.data.sources.model.common

data class CategoryDataRV(
    var id: Int,
    var categoryName: String,
    var list: List<FoodDataRV>
)
