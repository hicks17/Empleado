package com.example.empleado

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.empleado.databinding.ActivityMainBinding
import com.google.android.material.R
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var usuario: Usuario
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSpinnerList()

        binding.btnCrearUsuario.setOnClickListener { validateFields() }

    }

    private fun validateFields() {
        if (!binding.etNombre.text.isNullOrEmpty() && !binding.etCelular.text.isNullOrEmpty()
            && !binding.etEdad.text.isNullOrEmpty()
        ) {
            setData()
        } else {
            Toast.makeText(this, "rellena todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setData() {
        usuario = Usuario(
            nombre = binding.etNombre.text.toString(),
            edad = binding.etEdad.text.toString(),
            salario = calcularSalario(binding.spinnerCargos.selectedItem.toString()),
            puesto = binding.spinnerCargos.selectedItem.toString(),
            direccion = binding.etAddress.text.toString(),
            celular = binding.etCelular.text.toString()
        )


        updateUI()
    }

    private fun setSpinnerList() {
        val listaDeCargos = ArrayAdapter<String>(
            this,
            R.layout.support_simple_spinner_dropdown_item
        )

        EnumCargos.values().forEach {
            listaDeCargos.add(it.toString())
        }

        binding.spinnerCargos.adapter = listaDeCargos
    }

    private fun calcularSalario(cargo: String): Int {

        return when (cargo) {
            "Programador" -> 8700
            "EncargadoDeMarketing" -> 6500
            "Supervisor" -> 8300
            "DirectorDeFinanzas" -> 7900
            "EncargadoDeSeguridad" -> 4500
            "Limpieza" -> 3200
            else -> 0
        }
    }


    private fun updateUI() {
        val intent = Intent(this, ShowDataActivity::class.java)
        Log.w(TAG, usuario.toString())
        intent.putExtra("user", usuario)
        startActivity(intent)
    }
}