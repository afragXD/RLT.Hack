package com.example.rlthack.noAct

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.*
import kotlin.collections.HashMap

fun GetAll(context: Context) {
    val url = "http://80.78.253.91:3000/load_info"

    val requestQueue = Volley.newRequestQueue(context)

    var map = HashMap<Int, String>()

    val sRequest =  StringRequest(
        Request.Method.GET,
        url,
        {response->
            try {
                val t1 = JSONObject(response)
                val arr = JSONArray(t1.getString("for_month_chart"))

                for (index in 0 until arr.length()){
                    map[arr.getJSONObject(index).getInt("month_termination")] = arr.getJSONObject(index).getString("count")
                }
                SearchRep.map = map
                Log.d("GGLog", SearchRep.map.toString())
            }catch (error: JSONException){
                Log.d("GGLog", "error: $error")
            }
        },
        {
            Log.d("GGLog", "VError: $it")
        }
    )
    requestQueue.add(sRequest)
}