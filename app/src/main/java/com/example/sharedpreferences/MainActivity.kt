package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var usuario:EditText?=null
    var password:EditText?=null
    var txtusuario:TextView?=null
    var txtPass:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciarComponentes()
        cargarDatos()
    }

    private fun iniciarComponentes() {
        var btnGuardar:Button=findViewById(R.id.iniciar_sesion)
        btnGuardar.setOnClickListener { guardarDatos() }
        var btnCargar:Button=findViewById(R.id.cargar)
        btnCargar.setOnClickListener { cargarDatos() }
        usuario=findViewById(R.id.user)
        password=findViewById(R.id.pass)
        txtusuario=findViewById(R.id.txt_usuario)
        txtPass=findViewById(R.id.txt_password)
    }

    private fun guardarDatos() {
        var preferences:SharedPreferences=getSharedPreferences("credenciales",Context.MODE_PRIVATE)
        var usuario= usuario?.text.toString()
        var pass= password?.text.toString()
        var editor:SharedPreferences.Editor=preferences.edit()
        editor.putString("user",usuario)
        editor.putString("pass",pass)
        txtusuario?.text=usuario
        txtPass?.text=pass
        editor.commit()
        Toast.makeText(this,"Se han registrado los datos",Toast.LENGTH_SHORT).show()
    }

    private fun cargarDatos() {
        var preferences:SharedPreferences=getSharedPreferences("credenciales",Context.MODE_PRIVATE)
        var user: String? =preferences.getString("user","No existe la información")
        var pass: String? =preferences.getString("pass","No existe la información")
        txtusuario?.text=user
        txtPass?.text=pass

        if (user != "No existe la información"){
            //Se crea el intent encargador de la comunicacion entre activities
            val intent = Intent(this, CalculadoraActivity::class.java)
            //Creamos el bundle para el paso de informacion entre activities
            val miBundle:Bundle = Bundle()
            //Se le agrega informacion al intent para que sea enviada
            intent.putExtras(miBundle)
            //Iniciamos el llamado a la nueva actividad
            startActivity(intent)
        }
    }
}