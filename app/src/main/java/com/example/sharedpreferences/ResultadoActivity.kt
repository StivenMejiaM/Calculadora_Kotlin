package com.example.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val btnregresar = findViewById<Button>(R.id.buttonRegresar)
        btnregresar.setOnClickListener{onClick()}

        val message = findViewById<TextView>(R.id.Historial)

        var miBundle: Bundle? = this.intent.extras

        if (miBundle != null){
            message.text = "${miBundle.getString("key")}"
        }
    }

    private fun onClick() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
