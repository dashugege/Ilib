package com.example.administrator.mvp_rr_lib.testcoroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soyoung.coroutines_lib.NetworkService
import com.soyoung.coroutines_lib.Plant
import kotlinx.coroutines.launch

class CoroutinesViewModel : ViewModel() {


    var list = MutableLiveData<Plant>()


     fun getList() {
        viewModelScope.launch {
            val result = NetworkService.instance.allPlants()
            list.value = result
        }

    }


}