package com.example.loki_a10

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.loki_a10.databinding.FragmentThirdBinding
import com.example.loki_a10.retrofitModel.LogoutResponse
import com.example.loki_a10.retrofitModel.Retrofit
import com.example.loki_a10.retrofitModel.User
import com.example.loki_a10.retrofitModel.UserApi
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding?= null
    private val binding get() = _binding!!

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var auth : Firebase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPref = requireActivity().applicationContext.getSharedPreferences(
            "sharedpref",
            Context.MODE_PRIVATE
        ) ?: return
        val token = sharedPref.getString("TOKEN", null)

        Log.d("profile", token.toString())
        super.onCreate(savedInstanceState)
        _binding = FragmentThirdBinding.inflate(layoutInflater)

        val client: UserApi = Retrofit().getService()
        val call: Call<User> = client.profile("Bearer " + token)

        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                val respon = response.body()
                Log.d("profile-debug", "respon : " + respon)

                val getNama = respon?.name
                binding.textNamadiProfil.text = getNama

                val email = respon?.email
                binding.textEmaildiProfil.text = email

            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("profile-debug", t.localizedMessage)
            }

        })

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_third, container, false)
        _binding = FragmentThirdBinding.inflate(layoutInflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var sharedPref = requireActivity().applicationContext.getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?:return
        val token = sharedPref.getString("TOKEN", " ")
        Log.d("profile", token.toString())

        binding.textLogout.setOnClickListener {
            val client: UserApi = Retrofit().getService()
            val call: Call<LogoutResponse> = client.logout("Bearer $token")
            call.enqueue(object : Callback<LogoutResponse> {
                override fun onResponse(
                    call: Call<LogoutResponse>,
                    response: Response<LogoutResponse>
                ) {
                    with(sharedPref.edit()){
                        clear()
                        apply()
                    }
                    pindahHlm()
                }

                override fun onFailure(call: Call<LogoutResponse>, t: Throwable) {
                    Toast.makeText(context, "gagal", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }

    fun pindahHlm(){
        val intent = Intent(context, LoginActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }

    fun logout(){

    }

}