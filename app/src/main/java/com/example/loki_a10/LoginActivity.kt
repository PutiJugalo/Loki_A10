package com.example.loki_a10

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loki_a10.databinding.ActivityLoginBinding
import com.example.loki_a10.retrofitModel.Retrofit
import com.example.loki_a10.retrofitModel.UserApi
import com.example.loki_a10.retrofitModel.UserRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

    }
    fun ke_main(view: View) {
        val username = binding.inputUsernameLogin.text.toString()
        val password = binding.inputPasswordLogin.text.toString()

        val client: UserApi = Retrofit().getService()

        val call: Call<UserRequest> = client.login(username, password)

        call.enqueue(object : Callback<UserRequest> {
            override fun onFailure(call: Call<UserRequest>, t: Throwable) {
                Log.d("login-debug", t.localizedMessage)
                Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<UserRequest>, response: Response<UserRequest>) {
                //ambil respon login
                val respon: UserRequest? = response.body();
                if (respon != null && respon.status == "success") {

                    //ambil Token
                    val token = respon.authorisation?.token
                    Log.d("login-debug", username + ":" + password + "|" + token)

                    //Shared Preference
                    val sharedPref =
                        getSharedPreferences("sharedpref", Context.MODE_PRIVATE) ?: return
                    with(sharedPref.edit()) {
                        putString("TOKEN", token)
                        apply()
                    }
                    Toast.makeText(this@LoginActivity, "Selamat Datang", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LoginActivity,"Username/Password Salah",Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}