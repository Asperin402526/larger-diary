package com.example.largerdiary

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.largerdiary.data.TbUser
import com.example.largerdiary.data.User
import com.example.largerdiary.domain.model.Activity
import com.example.largerdiary.ui.theme.LargerDiaryTheme
import com.example.pinksqlit.TableSqlit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       TableSqlit.connect(this, TbUser, nameDb = "Luks")

        TbUser.insert(User(null,"папа"))

        val users = TbUser.select
            .orderByAsc(TbUser.ID)
            .getEntity( offset = 2)

       Log.w("PinkSqlit",users.toString() )

        enableEdgeToEdge()
        setContent {
            LargerDiaryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Activity.get().Rendering(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
