package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.countryinfo.model.CountryFlags
import com.kodeco.android.countryinfo.model.CountryName


// TODO fill out CountryInfoRow
@Composable
fun CountryInfoRow(name:CountryName, capital:List<String>?,population:Long,area:Double,flags: CountryFlags) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Column(
            modifier=Modifier.
                padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Row {
                Text(text="Name: ")
                Text(text = name.common)
            }
            Row {
                Text(text="Capital: ")
                Text(text=capital?.get(0)?:"There is no capital for this country")
            }


        }
    }
}

// TODO fill out the preview.
@Preview
@Composable
fun CountryInfoRowPreview() { }
