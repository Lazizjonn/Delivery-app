package uz.gita.maxwaydemo.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import uz.gita.maxwaydemo.R

class LanguageDialog : BottomSheetDialogFragment() {

    private var clickRussianLanguageListener: (() -> Unit)? = null
    private var clickUzbekLanguageListener: (() -> Unit)? = null
    private var clickEnglishLanguageListener: (() -> Unit)? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.language_dialog, container)
    }







    fun setRussianLanguageListener(block: () -> Unit) {
        clickRussianLanguageListener = block
    }
    fun setUzbekLanguageListener(block: () -> Unit) {
        clickUzbekLanguageListener = block
    }
    fun setEnglishLanguageListener(block: () -> Unit) {
        clickEnglishLanguageListener = block
    }

}