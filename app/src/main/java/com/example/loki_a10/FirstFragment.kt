package com.example.loki_a10

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loki_a10.adapter.AdapterInstansi
import com.example.loki_a10.databinding.FragmentFirstBinding
import com.example.loki_a10.models.Instansi

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var recycleView: RecyclerView
    private lateinit var instansiList: ArrayList<Instansi>
    private lateinit var adapter: AdapterInstansi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         _binding = FragmentFirstBinding.inflate(inflater, container, false)
//        return inflater.inflate(R.layout.fragment_first, container, false)
        val root: View = binding.root
        recycleView = binding.recyclerView1
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycleView.layoutManager = LinearLayoutManager(context)

        instansiList = ArrayList()

        instansiList.add(Instansi("Semen Padang", "Sedang diajukan"))
        instansiList.add(Instansi("Kominfo", "Telah Selesai"))
        instansiList.add(Instansi("Bank Republik Indonesia", "Telah Selesai"))
        instansiList.add(Instansi("Bank Syariah Indonesia", "Telah Selesai"))
        instansiList.add(Instansi("Tokopedia", "Telah Selesai"))

        adapter = AdapterInstansi(instansiList)
        recycleView.adapter = adapter

        adapter.setOnItemClickListener(object : AdapterInstansi.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@FirstFragment.requireContext(), DetailKpActivity::class.java)
                intent.putExtra("namaInstansi", instansiList[position].namaInstansi)
                intent.putExtra("statusKP",instansiList[position].statusKP)
                startActivity(intent)
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}