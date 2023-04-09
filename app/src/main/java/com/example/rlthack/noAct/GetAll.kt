package com.example.rlthack.noAct

import android.content.Context
import android.util.Log
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

fun GetAll(postData: JSONObject, context: Context) {
    val url = "http://192.168.3.36:5000/api/user/login"
    val key = "26a213594e7f4f6e8cd89064d885ea93"

    val requestQueue = Volley.newRequestQueue(context)
    val stringRequest = object : JsonObjectRequest(Method.GET, url, postData, { response ->
        try {
            Log.d("request", response.toString())
        } catch (e : JSONException){
            Log.d("request", e.toString())
        }
    }, {
            error->
        Log.d("request", error.toString())
    }){
        override fun getHeaders(): MutableMap<String, String> {
            val headers = HashMap<String, String>()
            headers["Authorization"] = "Bearer $key"
            headers["Content-Type"] = "application/json"
            return headers
        }
    }
    requestQueue.add(stringRequest)
}