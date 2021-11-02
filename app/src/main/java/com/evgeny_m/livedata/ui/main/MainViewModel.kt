package com.evgeny_m.livedata.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evgeny_m.livedata.model.DataModel

class MainViewModel : ViewModel() {

    private var resultMutableLiveData = MutableLiveData<String>()
    var liveData: LiveData<String> = resultMutableLiveData
    private val data = DataModel()

    init {
        Log.e("AAA", "ViewModel Created")
    }

    override fun onCleared() {
        Log.e("AAA", "ViewModel Cleared!")
        super.onCleared()

    }

    fun save(text: String) {
        data.saveData(text)
        resultMutableLiveData.value = text
    }

    fun load() {
        val text = data.loadData()
        resultMutableLiveData.value = text
    }
}