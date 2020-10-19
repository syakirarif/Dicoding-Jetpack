package com.syakir.myviewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.text.DecimalFormat

class MainViewModel : ViewModel() {

    companion object {
        private const val API_KEY = "cbc218ad086b0bb6b03cd863f7700aba"
    }

    val listWeathers = MutableLiveData<ArrayList<WeatherItems>>()

    // request API
    internal fun setWeather(cities: String) {

        val client = AsyncHttpClient()
        val listItems = ArrayList<WeatherItems>()
        val url =
            "https://api.openweathermap.org/data/2.5/group?id=$cities&units=metric&appid=$API_KEY"

        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>,
                responseBody: ByteArray
            ) {
                try {
                    val result = String(responseBody)
                    val responseObject = JSONObject(result)
                    val list = responseObject.getJSONArray("list")


                    for (i in 0 until list.length()) {
                        val weather = list.getJSONObject(i)
                        val weatherItems = WeatherItems()
                        weatherItems.id = weather.getInt("id")
                        weatherItems.name = weather.getString("name")
                        weatherItems.currentWeather =
                            weather.getJSONArray("weather").getJSONObject(0).getString("main")
                        weatherItems.description = weather.getJSONArray("weather").getJSONObject(0)
                            .getString("description")

                        val tempInKelvin = weather.getJSONObject("main").getDouble("temp")
                        val tempInCelcius = tempInKelvin - 273
                        weatherItems.temperature = DecimalFormat("##.##").format(tempInCelcius)
                        listItems.add(weatherItems)
                    }

                } catch (e: Exception) {
                    Log.e("Exception", "onSuccess: ")
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>,
                responseBody: ByteArray,
                error: Throwable
            ) {
                Log.e("onFailure", error.message.toString())
            }

        })
    }

    internal fun getWeathers(): LiveData<ArrayList<WeatherItems>> {
        return listWeathers
    }
}