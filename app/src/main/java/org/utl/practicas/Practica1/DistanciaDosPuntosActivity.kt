package org.utl.practicas.Practica1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.utl.practicas.R
import kotlin.math.sqrt
import kotlin.math.pow

class DistanciaDosPuntosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distancia_dos_puntos)

        val etX1 = findViewById<EditText>(R.id.etX1)
        val etY1 = findViewById<EditText>(R.id.etY1)
        val etX2 = findViewById<EditText>(R.id.etX2)
        val etY2 = findViewById<EditText>(R.id.etY2)
        val btnCalcular = findViewById<Button>(R.id.btnCalcularDistancia)
        val tvResultado = findViewById<TextView>(R.id.tvResultadoDistancia)

        btnCalcular.setOnClickListener {
            val x1Str = etX1.text.toString()
            val y1Str = etY1.text.toString()
            val x2Str = etX2.text.toString()
            val y2Str = etY2.text.toString()

            if (x1Str.isEmpty() || y1Str.isEmpty() || x2Str.isEmpty() || y2Str.isEmpty()) {
                Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val x1 = x1Str.toDouble()
            val y1 = y1Str.toDouble()
            val x2 = x2Str.toDouble()
            val y2 = y2Str.toDouble()

            // Fórmula de distancia euclidiana
            val distancia = sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))

            tvResultado.text = String.format("Resultado: d = %.2f", distancia)
        }
    }
}