package com.ivoronline.compose_viewmodel_initializemodel

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

//GLOBAL MODEL INSTANCE
var myViewModel: MyViewModel? = null

//==========================================================
// MAIN ACTIVITY
//==========================================================
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    myViewModel = MyViewModel(applicationContext as Application)
    setContent {
      Column {
        MyCounter()
        MyCounter()
      }
    }
  }
}

//==========================================================
// COUNTER (Use global Model Instance)
//==========================================================
@Composable
fun MyCounter() {
  Button({
    myViewModel?.increase(10)                                             //Call Model Functions
    myViewModel?.concat  (" hi")                                          //Call Model Functions
  }) {
    Text("(Count, Name) = (${myViewModel?.count}, ${myViewModel?.name})") //Display State Variables
  }
}

