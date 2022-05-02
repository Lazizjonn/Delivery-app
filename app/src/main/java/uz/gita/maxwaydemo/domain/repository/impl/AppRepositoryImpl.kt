package uz.gita.maxwaydemo.domain.repository.impl

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.onFailure
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import uz.gita.maxwaydemo.R
import uz.gita.maxwaydemo.data.sources.local.model.common.IntroData
import uz.gita.maxwaydemo.data.sources.local.model.response.AdsDataFromNet
import uz.gita.maxwaydemo.data.sources.local.model.response.CategoryDataFromNet
import uz.gita.maxwaydemo.data.sources.local.model.response.FoodDataFromNet
import uz.gita.maxwaydemo.domain.repository.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : AppRepository {

    private val ads = firestore.collection("ads")
    private val categories = firestore.collection("category")
    private val foodsRef = firestore.collection("foods")


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
            .addOnFailureListener { trySendBlocking(Result.failure(it)) }
        awaitClose {}
    }.flowOn(Dispatchers.IO)

    override fun getAllCategoriesPhotosFromFirebase() = callbackFlow<Result<List<CategoryDataFromNet>>> {
        categories.get().addOnSuccessListener { querySnapshot ->
            val data = querySnapshot.map { queryDocumentSnapshot ->
                queryDocumentSnapshot.toObject(CategoryDataFromNet::class.java)
            }
            trySendBlocking(Result.success(data)).onFailure { trySendBlocking(Result.failure(java.lang.Exception(it))) }
        }
            .addOnFailureListener { trySendBlocking(Result.failure(it)) }
            awaitClose { }

    }.flowOn(Dispatchers.IO)

    override fun getAllFoodsPhotosFromFirebase() = channelFlow<Result<List<FoodDataFromNet>>> {
        foodsRef.get().addOnSuccessListener { snapList ->
            val foodList = snapList.map { snapItem ->
                snapItem.toObject(FoodDataFromNet::class.java)
            }
            trySendBlocking(Result.success(foodList)
                .onFailure { trySendBlocking(Result.failure(java.lang.Exception(it))) })
        }

        foodsRef.get().addOnFailureListener {
            trySendBlocking(Result.failure(java.lang.Exception(it)))
        }
        awaitClose { }
    }.flowOn(Dispatchers.IO)

       /* foodsRef.addSnapshotListener { querySnapshot,exception ->
            if (exception == null){
//                emit(Result.failure<Exception>(exception!!))
                return@addSnapshotListener
            }

            if (querySnapshot != null){
                for(item in querySnapshot ){
                var food = item.toObject(FoodDataFromNet::class.java)
                    if (!mFoodList.contains(food)){
                        mFoodList.add(food)
                    }
                }
                suspend {
                    emit(Result.success(mFoodList))
                }
            }
        }*/


}