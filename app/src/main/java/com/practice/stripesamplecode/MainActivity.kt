package com.practice.stripesamplecode

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest

class MainActivity : AppCompatActivity() {
    private val publicKey: String =
        "pk_test_51KX0F9HGvD51Gy8EqoOiU51RnxlK1zzdBKxifB2zNMQxbJolmGnxxkLshqKjys5ojGoVJ9TTFip3WIa4enHZEzLy00ndXyaxqA"
    private val privateKey: String =
        "sk_test_51KX0F9HGvD51Gy8E5pMGc2U7sCMVBZ4DS7qSre2Vq6cnHXB3KwZGmr9wqRC9FyErGUbMEvo9voTFXDKaE5TUyYIs001QjrghOO"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://api.stripe.com/v1/customers"

        val request = object : StringRequest(Request.Method.POST, url, Response.Listener<String> {
            Log.d("abcdda", "" + it);

        }, Response.ErrorListener {
            Toast.makeText(applicationContext, "" + it, Toast.LENGTH_LONG).show()
            Log.d("abcdda", "" + it);

        }) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Authorization"] =  "Bearer sk_test_51KX0F9HGvD51Gy8E5pMGc2U7sCMVBZ4DS7qSre2Vq6cnHXB3KwZGmr9wqRC9FyErGUbMEvo9voTFXDKaE5TUyYIs001QjrghOO"

                return super.getHeaders()
            }
        }
        request.retryPolicy = DefaultRetryPolicy(
            DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
            0,
            1f
        )

        VolleySingleton.getInstance(this).addToRequestQueue(request)


    }

}