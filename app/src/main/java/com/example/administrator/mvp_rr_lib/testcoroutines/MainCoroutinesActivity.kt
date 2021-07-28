package com.example.administrator.mvp_rr_lib.testcoroutines

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.administrator.mvp_rr_lib.R

class MainCoroutinesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_coroutines)


        var viewModel = CoroutinesViewModel()
        viewModel.getList()



        viewModel.list.observe(this){
            it?.let {
               print(it)
            }
        }




    }
}


