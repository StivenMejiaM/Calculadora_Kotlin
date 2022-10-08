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

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instancio los componentes//
        val txtnumber1 = findViewById<EditText>(R.id.editTextNumber)
        val txtnumber2 = findViewById<EditText>(R.id.editTextNumber2)
        val suma = findViewById<Button>(R.id.buttonSumar)
        val resta = findViewById<Button>(R.id.buttonRestar)
        val multiplicar = findViewById<Button>(R.id.buttonMultiplicar)
        val dividir = findViewById<Button>(R.id.buttonDividir)
        val btnResultado = findViewById<TextView>(R.id.Resultado)
        val btnReiniciar = findViewById<Button>(R.id.Reiniciar)
        val btnsiguiente = findViewById<Button>(R.id.buttonSiguiente)
        btnsiguiente.setOnClickListener { onClick() }

        var Resultado: Long? = null

        suma.setOnClickListener {
            if (txtnumber1.text.isNotEmpty() && txtnumber2.text.isNotEmpty()) {
                Resultado =
                    txtnumber1.text.toString().toLong() + txtnumber2.text.toString().toLong()
                btnResultado.text = Resultado.toString()
            } else {
                Toast.makeText(this, "Los dos campos son obligatorias", Toast.LENGTH_SHORT).show()
            }
        }

        resta.setOnClickListener {
            if (txtnumber1.text.isNotEmpty() && txtnumber2.text.isNotEmpty()) {
                Resultado =
                    txtnumber1.text.toString().toLong() - txtnumber2.text.toString().toLong()
                btnResultado.text = Resultado.toString()
            } else {
                Toast.makeText(this, "Los dos campos son obligatorias", Toast.LENGTH_SHORT).show()
            }
        }

        multiplicar.setOnClickListener {
            if (txtnumber1.text.isNotEmpty() && txtnumber2.text.isNotEmpty()) {
                Resultado =
                    txtnumber1.text.toString().toLong() * txtnumber2.text.toString().toLong()
                btnResultado.text = Resultado.toString()
            } else {
                Toast.makeText(this, "Los dos campos son obligatorias", Toast.LENGTH_SHORT).show()
            }
        }

        dividir.setOnClickListener {
            if (txtnumber1.text.isNotEmpty() && txtnumber2.text.isNotEmpty()) {
                Resultado =
                    txtnumber1.text.toString().toLong() / txtnumber2.text.toString().toLong()
                btnResultado.text = Resultado.toString()
            } else {
                Toast.makeText(this, "Los dos campos son obligatorias", Toast.LENGTH_SHORT).show()
            }
        }

        btnReiniciar.setOnClickListener {
            txtnumber1.text.clear()
            txtnumber2.text.clear()
            btnResultado.text = ""
        }
    }

    private fun onClick() {
        val intent = Intent(this, ResultadoActivity::class.java)
        val miBundle: Bundle = Bundle()
        intent.putExtras(miBundle)
        startActivity(intent)
    }

}
