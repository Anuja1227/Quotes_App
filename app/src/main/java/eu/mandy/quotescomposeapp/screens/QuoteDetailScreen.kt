package eu.mandy.quotescomposeapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import eu.mandy.quotescomposeapp.DataManager
import eu.mandy.quotescomposeapp.R
import eu.mandy.quotescomposeapp.models.Quote


@Composable
fun QuoteDetail(quote: Quote){

    BackHandler() {
        DataManager.switchPages(null)
    }

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3)
                    )
                )
            )) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation= CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.padding(32.dp)
        ) {
            Column(
                verticalArrangement= Arrangement.Center,
                // horizontalAlignment = Alignment.CenterHorizontally,
                modifier= Modifier
                    .padding(16.dp, 24.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                Image(painter = painterResource(id = R.drawable.img),
                    colorFilter = ColorFilter.tint(Color.Black),
                    contentDescription = "Quote",
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180F)
                )
                Text(text = quote.text,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    style= MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text =quote.author,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    style= MaterialTheme.typography.titleMedium)


            }

        }
    }
}