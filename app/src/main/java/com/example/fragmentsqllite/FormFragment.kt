package com.example.fragmentsqllite


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast



class FormFragment : Fragment() {

    private lateinit var submitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_form, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val name: EditText = view.findViewById(R.id.nameET)
        val lastName: EditText = view.findViewById(R.id.lastNameET)
        val age: EditText = view.findViewById(R.id.ageET)
        val mail: EditText = view.findViewById(R.id.emailET)
        val dep: EditText = view.findViewById(R.id.departmentET)
        val salary: EditText = view.findViewById(R.id.salaryET)

        val dbHelper = SqlHelper(view.context)
        submitBtn = view.findViewById(R.id.submitBtn)
        submitBtn.setOnClickListener {


            if (name.text.isNotEmpty() && lastName.text.isNotEmpty() && age.text.isNotEmpty() && mail.text.isNotEmpty() && dep.text.isNotEmpty() && salary.text.isNotEmpty()) {


                val employee = Employee(
                    name.text.toString(),
                    lastName.text.toString(),
                    age.text.toString().toInt(),
                    mail.text.toString(),
                    dep.text.toString(),
                    salary.text.toString().toInt()
                )

                dbHelper.addEmployee(employee)

                clear()

            } else {
                Toast.makeText(view.context, "Fill out the form", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clear() {
        view?.findViewById<EditText>(R.id.nameET)?.text?.clear()
        view?.findViewById<EditText>(R.id.lastNameET)?.text?.clear()
        view?.findViewById<EditText>(R.id.ageET)?.text?.clear()
        view?.findViewById<EditText>(R.id.emailET)?.text?.clear()
        view?.findViewById<EditText>(R.id.departmentET)?.text?.clear()
        view?.findViewById<EditText>(R.id.salaryET)?.text?.clear()

    }

}