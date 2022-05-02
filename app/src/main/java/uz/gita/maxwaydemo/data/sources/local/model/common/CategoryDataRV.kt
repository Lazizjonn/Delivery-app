package uz.gita.maxwaydemo.data.sources.local.model.common

data class CategoryDataRV(
    var id: Int,
    var categoryName: String,
    var list: List<FoodDataRV>
)
