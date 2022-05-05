package uz.gita.maxwaydemo.domain.repository.impl

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.onFailure
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.data.sources.model.common.CategoryDataRV
import uz.gita.maxwaydemo.data.sources.model.common.FoodDataRV
import uz.gita.maxwaydemo.data.sources.model.common.IntroData
import uz.gita.maxwaydemo.data.sources.model.response.AdsDataFromNet
import uz.gita.maxwaydemo.data.sources.model.response.CategoryDataFromNet
import uz.gita.maxwaydemo.data.sources.model.response.FoodDataFromNet
import uz.gita.maxwaydemo.domain.repository.MealRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class MealRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : MealRepository {

    private val ads = firestore.collection("ads")
    private val categories = firestore.collection("category")
    private val foods = firestore.collection("foods")


    override fun setDataForIntroFragment(): MutableList<IntroData> {
        val list: MutableList<IntroData> = ArrayList()
        list.add(IntroData(R.color.white, R.drawable.group_1))
        list.add(IntroData(R.color.white, R.drawable.group_2))
        list.add(IntroData(R.color.white, R.drawable.group_3))
        list.add(IntroData(R.color.white, R.drawable.group_4))
        return list
    }

    override fun loadImagesFromFirebase(): ArrayList<Int> {
        val images = ArrayList<Int>()
        images.add(R.drawable.group_1)
        images.add(R.drawable.group_2)
        images.add(R.drawable.group_3)
        images.add(R.drawable.group_4)
        images.add(R.drawable.group_1)
        images.add(R.drawable.group_2)
        return images
    }

    override fun getAllAddsPhotosFromFirebase() = callbackFlow<Result<List<AdsDataFromNet>>> {

        ads.get().addOnSuccessListener { querySnapshot ->
            val data = querySnapshot.map { queryDocumentSnapshot ->
                queryDocumentSnapshot.toObject(AdsDataFromNet::class.java)
            }
            trySendBlocking(Result.success(data)).onFailure { trySendBlocking(Result.failure(Exception(it))) }
        }
            .addOnFailureListener {
                trySendBlocking(Result.failure(it))
            }
        awaitClose {}
    }.flowOn(Dispatchers.IO)

    private fun getAllCategoriesPhotosFromFirebase() = callbackFlow<Result<List<CategoryDataFromNet>>> {
        categories.get().addOnSuccessListener { querySnapshot ->
            val data = querySnapshot.map { queryDocumentSnapshot ->
                queryDocumentSnapshot.toObject(CategoryDataFromNet::class.java)
            }
            trySendBlocking(Result.success(data))
                .onFailure {
                    trySendBlocking(Result.failure(Exception(it)))
                }
        }
            .addOnFailureListener {
                trySendBlocking(Result.failure(it))
            }
        awaitClose {}
    }.flowOn(Dispatchers.IO)

    private fun getAllFoodsPhotosFromFirebase() = callbackFlow<Result<List<FoodDataFromNet>>> {
        foods.get().addOnSuccessListener { querySnapshot ->
            val data = querySnapshot.map { queryDocumentSnapshot ->
                queryDocumentSnapshot.toObject(FoodDataFromNet::class.java)
            }
            trySendBlocking(Result.success(data)
                .onFailure { trySendBlocking(Result.failure(Exception(it))) })
        }

        foods.get().addOnFailureListener {
            trySendBlocking(Result.failure(it))
        }
        awaitClose { }
    }.flowOn(Dispatchers.IO)

    override fun getAllCategoriesForRV(scope: CoroutineScope) = callbackFlow<Result<List<CategoryDataRV>>> {
        val categoryList = ArrayList<CategoryDataFromNet>()
        val foodsList = ArrayList<FoodDataFromNet>()

        getAllCategoriesPhotosFromFirebase().onEach { it ->
            it.onSuccess {
                categoryList.addAll(it)
            }
                .onFailure {  //errorLiveData.value = it.message
                }
        }.launchIn(scope)

        getAllFoodsPhotosFromFirebase().onEach { it ->
            it.onSuccess {
                foodsList.addAll(it)
            }
                .onFailure {  //errorLiveData.value = it.message
                }
        }.launchIn(scope)

        delay(2000)
        val readyData = ArrayList<CategoryDataRV>()

        for (i in 0 until categoryList.size) {
            val readyFoods = ArrayList<FoodDataRV>()
            for (foods in foodsList) {
                if (categoryList[i].id == foods.categoryID) {
                    readyFoods.add(FoodDataRV(foods.name!!, foods.image!!, foods.cost!!, foods.description!!))
                }
            }
            readyData.add(CategoryDataRV(i,categoryList[i].name!!, readyFoods))

        }

        categories.get().addOnSuccessListener {
            trySendBlocking(Result.success(readyData)).onFailure { trySendBlocking(Result.failure(java.lang.Exception(it))) }
        }
            .addOnFailureListener {
                trySendBlocking(Result.failure(it))
            }

        awaitClose {}
    }.flowOn(Dispatchers.IO)

}