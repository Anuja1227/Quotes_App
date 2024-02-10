package eu.mandy.quotescomposeapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import eu.mandy.quotescomposeapp.models.Quote

object DataManager {

    var data= emptyArray<Quote>()
    var currentQuote:Quote?=null
    var currentPage = mutableStateOf(Pages.LISTING)
    var isDataLoaded= mutableStateOf(false)

    fun loadAssetsFromFile(context:Context){
        val inputStress = context.assets.open("quotes.json")
        val size: Int= inputStress.available()
        val buffer = ByteArray(size)
        inputStress.read(buffer)
        inputStress.close()
        val json= String(buffer,Charsets.UTF_8)
        val gson= Gson()
        data= gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value=true
    }
    fun switchPages(quote: Quote?){
        if(currentPage.value== Pages.LISTING){
            currentQuote=quote
            currentPage.value=Pages.DETAIL
    }
        else{
            currentPage.value=Pages.LISTING
        }

    }
}