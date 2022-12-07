package com.example.loki_a10

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loki_a10.adapter.AdapterInfoSeminarLain
import com.example.loki_a10.databinding.FragmentSecondBinding
import com.example.loki_a10.models.InfoSeminarLain

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private lateinit var recycleView: RecyclerView
    private lateinit var mhsLainList: ArrayList<InfoSeminarLain>
    private lateinit var adapter: AdapterInfoSeminarLain

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
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
//        return inflater.inflate(R.layout.fragment_second, container, false)
        val root: View = binding.root
        recycleView = binding.recyclerView2
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycleView.layoutManager = LinearLayoutManager(context)

        mhsLainList = ArrayList()

        mhsLainList.add(InfoSeminarLain("Luthfia Humaira", "07/05/2022"))
        mhsLainList.add(InfoSeminarLain("Puti Jugalo", "15/06/2022"))
        mhsLainList.add(InfoSeminarLain("Fikri Nazif", "23/06/2022"))

        adapter = AdapterInfoSeminarLain(mhsLainList)
        recycleView.adapter = adapter

        adapter.setOnItemClickListener(object : AdapterInfoSeminarLain.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@SecondFragment.requireContext(), absensi_seminar::class.java)
                intent.putExtra("namaMhsLain", mhsLainList[position].namaMhsLain)
                intent.putExtra("tanggalSeminarLain",mhsLainList[position].tanggalSeminarLain)
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
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}