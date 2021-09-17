package com.example.favoritelistapplication.ui.favRegister

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class FavRegisterViewModel @Inject internal constructor() : ViewModel() {
    private val _birthday: MutableLiveData<String> = MutableLiveData()
    val birthday: LiveData<String> = _birthday

    private val _anniversary: MutableLiveData<String> = MutableLiveData()
    val anniversary: LiveData<String> = _anniversary

    fun registerBirthday(month: Int, date: Int){
        _birthday.value = "${month}月${date}日"

    }

    fun registerAnniversary(year: Int, month: Int, date: Int){
        _anniversary.value = "${year}年${month}月${date}日"

    }
}