package uz.gita.maxwaydemo.domain.repository.impl

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.maxwaydemo.app.App
import uz.gita.maxwaydemo.data.model.common.MyUser
import uz.gita.maxwaydemo.data.model.request.RegisterRequest
import uz.gita.maxwaydemo.data.sources.local.mySharedPref.MySharedPref
import uz.gita.maxwaydemo.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val fireStore: FirebaseFirestore,
    private val pref: MySharedPref
) : AuthRepository {

    private val usersRef = fireStore.collection("users")

    override fun regPhoneRequest(registerRequest: RegisterRequest, code: String) = callbackFlow<Boolean> {
        val credential = PhoneAuthProvider.getCredential(registerRequest.code, code)

        var usersList: List<MyUser> = listOf()
        auth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                val currentUser = it.result!!.user
                Log.d("TAG", "repository signInWithCredential:success")

                usersRef.get().addOnSuccessListener { querySnap -> // userList Olvolish
                    usersList = querySnap.map { document ->
                        document.toObject(MyUser::class.java)
                    }
                    Log.d("TAG", "repository senior usersList: " + usersList[0].id + ", " + usersList[1].id)
                    for (i in usersList){
                        if (i.id == currentUser!!.uid) { // agar user oldin reg bo`lgan bo`lsa
                            Log.d("TAG", "repository senior user: ")
                            val seniorUser = MyUser(currentUser.uid, i.name, i.surname, i.phone, i.email, i.geoPoint, i.cards)
                            pref.putUser(seniorUser, "user")
                            App.initUser(pref)
                            trySendBlocking(true)

                        }
                    }
                    if (pref.getUser("user") == null){
                        Log.d("TAG", "repository new user: ")
                        val newUser = MyUser(currentUser?.uid.toString(), registerRequest.name, registerRequest.surname, registerRequest.phone, registerRequest.email)
                        pref.putUser(newUser,"user")
                        App.initUser(pref)

                        usersRef.document(App.myUser!!.id).set(App.myUser!!)
                            .addOnSuccessListener {
                                Log.d("TAG", "repository user set to database success: ")
                            }
                            .addOnFailureListener {
                                Log.d("TAG", "repository user set to database: failed ")
                            }
                        trySendBlocking(true)
                    }
                }
            } else {
                // Sign in failed, display a message and update the UI
                Log.w("TAG", "repository signInWithCredential:failure", it.exception)
                if (it.exception is FirebaseAuthInvalidCredentialsException) {
                    // The verification code entered was invalid
                    trySendBlocking(false)
                }
                // Update UI
            }
        }

        awaitClose {  }
    }.flowOn(Dispatchers.IO)


}