package com.example.composetasks

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListDemo(){
    LazyColumnDemo()


}
@Composable
fun LazyColumnDemo(){
var myList = getAllPlaces()
    LazyColumn(content = {
        itemsIndexed(myList, itemContent = {
            index, item ->  PlacesItem(item = item)
        })
    })
}
@Composable
fun PlacesItem(item: Places){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        Image(painter = painterResource(id = item.imageRes), contentDescription ="",
            modifier = Modifier
                .clip(CircleShape)
                .size(60.dp)
                .scale(1.0f))
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(text = item.placeName, style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold))
            Text(text = item.place, style = TextStyle(fontSize = 18.sp))
        }

    }

}