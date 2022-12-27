package com.example.loki_a10

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loki_a10.databinding.ActivityEditProfilBinding
import com.example.loki_a10.retrofitModel.Retrofit
import com.example.loki_a10.retrofitModel.UpdateProfilResponse
import com.example.loki_a10.retrofitModel.UserApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class editprofil : AppCompatActivity() {
    lateinit var binding : ActivityEditProfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getNama = intent.getStringExtra("Nama")
        val getEmail = intent.getStringExtra("Email")

        binding.textEditNamadiEditProfil.setText(getNama)
        binding.textEditEmaildiEditProfil.setText(getEmail)

    }

    fun ubahProfilClicked(view: View) {
        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?: return
        val token = sharedPref.getString("TOKEN",null)

        val name = binding.textEditNamadiEditProfil.text.toString()
        val email = binding.textEditEmaildiEditProfil.text.toString()

        val client: UserApi = Retrofit().getService()
        val call: Call<UpdateProfilResponse> = client.updateProfile(token = "Bearer $token", name, email)
        Log.d("update-debug", "$name|$email|Bearer $token")

        call.enqueue(object: Callback<UpdateProfilResponse> {
            override fun onFailure(call: Call<UpdateProfilResponse>, t: Throwable) {
                Log.d("update-debug",t.localizedMessage)
            }
            override fun onResponse(call: Call<UpdateProfilResponse>, response: Response<UpdateProfilResponse>) {
                Log.d("update-debug", "response : $response")

                val respon: UpdateProfilResponse? = response.body()
                if (respon != null && respon.status == "success" ) {

                    Log.d("update-debug", "$name:$email|$token|$respon")

                    Toast.makeText(this@editprofil, "Profil Berhasil Diubah", Toast.LENGTH_SHORT).show()

                    intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    Toast.makeText(this@editprofil, "Salah", Toast.LENGTH_SHORT).show()
                }
            }
        })

    }
}