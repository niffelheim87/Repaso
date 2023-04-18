package com.ompava.p2_master_detail_series.Model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ompava.p2_master_detail_series.R
import java.io.BufferedReader
import java.io.InputStreamReader

data class SerieModel(
    var id: Int,
    var name: String,
    var language: String,
    var genres: Array<String>,
    var status: String,
    var premiered: String,
    var officialSite: String,
    var rating: Float,
    var image: String,
    var summary: String
){
    companion object{
        var listSerie:MutableList<SerieModel> = mutableListOf()

        fun loadSeries(context: Context) {
            val raw = context.resources.openRawResource(R.raw.datos_json)
            val rd = BufferedReader(InputStreamReader(raw))

            val listType = object : TypeToken<MutableList<SerieModel>>() {}.type
            val gson = Gson()

            listSerie = gson.fromJson(rd, listType)
        }

        fun getSeries(): MutableList<SerieModel>{

            return listSerie
        }

        fun getSerieById(mId: Int?):SerieModel?{
            val serie = getSeries().filter { serie ->
                serie.id==mId
            }

            return  serie[0]?:null
        }

        fun getFirstID():Int{
            return getSeries()[0].id
        }
    }
}
