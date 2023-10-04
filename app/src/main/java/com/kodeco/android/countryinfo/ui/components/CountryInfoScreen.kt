package com.kodeco.android.countryinfo.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.countryinfo.model.Country
import com.kodeco.android.countryinfo.networking.CountryApiObject.retrofitService

var currentstatus:Boolean=false
// TODO fill out CountryInfoScreen
@Composable
fun CountryInfoScreen(countryList: List<Country>,status:Boolean) {

        //var logservice:List<Country> = remember {mutableStateListOf<Country>()}
        var logservice:List<Country> by remember {
            mutableStateOf(listOf<Country>())
        }
    currentstatus=status
    if(status){
        LaunchedEffect(Unit){
                try {
                    // some code that can cause an exception.
                    logservice= retrofitService.getCountries().body()?: listOf<Country>()
                    Log.d("api response","first call "+logservice.toString())
                }
                catch (e: Exception) {
                    Log.d("api response",""+e.toString())
                }


            }
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(6.dp)
        ) {
            Log.d("api response","Outside list")
            items(logservice){
                Log.d("api response","each response "+it.toString())
                CountryInfoRow(name=it.name,area=it.area, population =it.population, flags =it.flags, capital = it.capital)
            }
        }
    }else{
        CountryErrorScreen()
    }
}






// TODO fill out the preview.
@Preview
@Composable
fun CountryInfoScreenPreview() { }


