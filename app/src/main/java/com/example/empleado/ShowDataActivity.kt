package com.example.empleado

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.empleado.databinding.ActivityShowDataBinding

class ShowDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShowDataBinding
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowDataBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val user = intent.getSerializableExtra("user") as Usuario

        with(user){
            binding.apply {
                tvNombre.text = nombre
                tvCargo.text = puesto
                tvSalario.text = salario.toString()
                tvEdad.text = edad
                tvDireccion.text = direccion
                tvCelular.text = celular
            }
        }

    }
}