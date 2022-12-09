package com.example.fragmentsqllite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeesAdapter(private val employeeList: ArrayList<Employee>) : RecyclerView.Adapter<EmployeesAdapter.EmployeesViewHolder>(){

    class EmployeesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var nameView: TextView = itemView.findViewById(R.id.employeeNameTV)
        var lastNameView: TextView = itemView.findViewById(R.id.employeeLastNameTV)
        var ageView: TextView = itemView.findViewById(R.id.employeeAgeTV)
        var depView: TextView = itemView.findViewById(R.id.employeeDepTV)
        var salaryView: TextView = itemView.findViewById(R.id.employeeSalaryTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.employee_resource_layout_file, parent, false)
        return EmployeesViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeesViewHolder, position: Int) {
        val currentEmployee = employeeList[position]
        holder.nameView.text = currentEmployee.name
        holder.lastNameView.text = currentEmployee.lastName
        holder.ageView.text = currentEmployee.age.toString()
        holder.depView.text = currentEmployee.department
        holder.salaryView.text = currentEmployee.salary.toString()
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }
}