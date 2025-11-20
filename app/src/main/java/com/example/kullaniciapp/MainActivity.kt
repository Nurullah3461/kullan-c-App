package com.example.kullaniciapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kullaniciapp.model.User
import com.example.kullaniciapp.screens.DetailScreen
import com.example.kullaniciapp.screens.UserList
import com.example.kullaniciapp.ui.theme.KullaniciAppTheme
import com.example.kullaniciapp.viewmodel.UserViewModel
import com.google.gson.Gson
import kotlin.jvm.java

class MainActivity : ComponentActivity() {

    private val viewModel : UserViewModel by viewModels<UserViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            KullaniciAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {

                        NavHost(navController = navController, startDestination = "liste_ekrani") {
                            composable("liste_ekrani") {
                                viewModel.getUsers()
                                UserList(userList = viewModel.userList.value, navController = navController)
                            }

                            composable("detay_ekrani/{secilenKullanıcı}",
                                arguments = listOf(
                                    navArgument("secilenKullanıcı"){
                                        type = NavType.StringType
                                    }
                                )
                            ) {
                                val kullanıcıString = remember{
                                    it.arguments?.getString("secilenKullanıcı")

                                }

                                val secilenKullanıcı = Gson().fromJson(kullanıcıString, User::class.java)
                                DetailScreen(user = secilenKullanıcı )
                            }

                        }


                    }
                }
            }
        }
    }
}



