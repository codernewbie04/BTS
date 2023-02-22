package com.submission.bts.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.submission.bts.model.DummyData
import com.submission.bts.model.TempatWisata

class HomeViewModel : ViewModel() {

    private val _data = MutableLiveData<ArrayList<TempatWisata>>().apply {
        value = DummyData.dummy
    }
    val rvcWisata : LiveData<ArrayList<TempatWisata>> = _data
}