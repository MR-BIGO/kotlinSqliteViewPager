package com.example.fragmentsqllite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragment : Fragment() {

    private lateinit var refreshBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dbHelper = SqlHelper(view.context)
        var employeesList = dbHelper.readData()

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        var adapter = EmployeesAdapter(employeesList)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapter

        refreshBtn = view.findViewById(R.id.refreshBtn)

        refreshBtn.setOnClickListener {
            employeesList = dbHelper.readData()
            adapter = EmployeesAdapter(employeesList)
            recyclerView.adapter = adapter

        }
    }

}