package test.com.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel : ViewModel() {
    val message = MutableLiveData<String>()
    fun sendMessage(msg:String){
        message.value = msg
    }
}