package com.example.empleado

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable


data class Usuario(
    val nombre:String,
    val celular:String,
    val edad:String,
    val puesto:String,
    val direccion:String,
    var salario:Int
) : Serializable


