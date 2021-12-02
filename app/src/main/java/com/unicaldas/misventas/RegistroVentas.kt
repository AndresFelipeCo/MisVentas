package com.unicaldas.misventas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistroVentas.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistroVentas : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        return inflater.inflate(R.layout.fragment_registro_ventas, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spinnerTCortinas: Spinner = view.findViewById(R.id.spinnerTCortinas)
        //var tareas = arrayOf("Veneciana", "Japonesa", "Persiana")
        var tareas : ArrayList<Task> = ArrayList()
        tareas.add(Task("Ana Suarez", "000000", "2021-01-01", "Kra 6", "111111", "22222", "Veneciana", "2", "3"))
        tareas.add(Task("Juan Luna", "000000", "2021-02-05", "Cll 30", "111111", "22222", "Japonesa", "2", "3"))
        tareas.add(Task("Pablo Esquivel", "000000", "2021-02-20", "Cll 30", "111111", "22222", "Persiana", "2", "3"))

        val taskAdapter = ArrayAdapter(context?.applicationContext!!, android.R.layout.simple_spinner_item, tareas)
        taskAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTCortinas.adapter = taskAdapter

        val btnRegistrarVenta: Button = view.findViewById(R.id.btnRegistrarVenta)
        btnRegistrarVenta.setOnClickListener {
            var tarea = spinnerTCortinas.selectedItem as Task
            Toast.makeText(context?.applicationContext!!, tarea.spinnerTCortinas, Toast.LENGTH_LONG).show()
            //Toast.makeText(context?.applicationContext!!, spinnerTCortinas.selectedItem.toString(), Toast.LENGTH_LONG).show()
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegistroVentas.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegistroVentas().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}