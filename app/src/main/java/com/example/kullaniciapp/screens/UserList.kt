package com.example.kullaniciapp.screens

import android.graphics.Color
import android.graphics.Color.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kullaniciapp.model.Address
import com.example.kullaniciapp.model.Company
import com.example.kullaniciapp.model.Geo
import com.example.kullaniciapp.model.User
import com.example.kullaniciapp.ui.theme.KullaniciAppTheme
import com.google.gson.Gson


@Composable
fun UserList(userList: List<User>,navController: NavController) {
    LazyColumn(
        modifier =
            Modifier.fillMaxSize()

    ) {
        itemsIndexed(userList) {index,user ->

            UserRow(user = user,navController = navController, currentIndex = index)


        }
    }
}

@Composable
fun UserRow(user: User,navController: NavController,currentIndex : Int) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .border(BorderStroke(2.dp, MaterialTheme.colorScheme.tertiaryContainer))
            .clickable{
                navController.navigate("detay_ekrani/${currentIndex}")
            }
            .background(color = MaterialTheme.colorScheme.primaryContainer )
            .padding(10.dp)
    ) {
        Column() {
            Text(user.name)
            Text(user.email)
            Text(user.phone)
            Text(user.website)
        }
    }

}


/*
@Preview(showBackground = true)
@Composable
fun UserPreview() {
    KullaniciAppTheme {
        UserList(userList = listOf(
            User(
                id = 1,
                name = "Ahmet",
                username = "Yılmaz",
                email = "william.henry.moody@my-own-personal-domain.com",
                Address("", "", "", "", Geo("","")),
                phone = "123456789",
                website = "www.ahmet.com",
                Company(name = "", catchPhrase = "", bs = "")
            ),
            User(
                id = 3,
                name = "mehmet",
                username = "Yılmaz",
                email = "william.henry.moody@my-own-personal-domain.com",
                Address("", "", "", "", Geo("","")),
                phone = "123456789",
                website = "www.mehmet.com",
                Company(name = "", catchPhrase = "", bs = "")
        )
        ))

    }
}


 */
