package uz.gita.contactappretrofit.utils

import androidx.viewbinding.ViewBinding

fun <T : ViewBinding> T.myApply(block: T.() -> Unit) {
    block(this)
}