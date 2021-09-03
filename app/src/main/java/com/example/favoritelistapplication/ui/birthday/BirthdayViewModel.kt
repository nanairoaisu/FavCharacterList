package com.example.favoritelistapplication.ui.birthday

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BirthdayViewModel @Inject internal constructor() : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is birthday Fragment"
    }
    val text: LiveData<String> = _text
}