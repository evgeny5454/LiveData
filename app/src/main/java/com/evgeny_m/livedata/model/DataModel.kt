package com.evgeny_m.livedata.model

data class DataModel(
    var text : String = ""
)
{
    fun saveData(text: String){
        this.text = text

    }

    fun loadData() : String {
        return this.text
    }
}
