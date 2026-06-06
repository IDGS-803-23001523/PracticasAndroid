package org.utl.practicas.Practica2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.utl.practicas.R
import kotlin.math.sqrt

class DeterminarTrianguloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_determinar_triangulo)

        val etA = findViewById<EditText>(R.id.etLadoA)
        val etB = findViewById<EditText>(R.id.etLadoB)
        val etC = findViewById<EditText>(R.id.etLadoC)
        val btnValidar = findViewById<Button>(R.id.btnValidarTriangulo)
        val layoutResultados = findViewById<LinearLayout>(R.id.layoutResultadosTriangulo)
        val tvResultado = findViewById<TextView>(R.id.tvResultadoHeron)

        btnValidar.setOnClickListener {
            val aStr = etA.text.toString()
            val bStr = etB.text.toString()
            val cStr = etC.text.toString()

            if (aStr.isEmpty() || bStr.isEmpty() || cStr.isEmpty()) {
                Toast.makeText(this, "Introduce todos los lados", Toast.LENGTH_SHORT).show()
                layoutResultados.visibility = View.GONE
                return@setOnClickListener
            }

            val a = aStr.toDouble()
            val b = bStr.toDouble()
            val c = cStr.toDouble()

            // Validación del triángulo
            if ((a + b > c) && (a + c > b) && (b + c > a)) {
                val s = (a + b + c) / 2.0
                val area = Math.sqrt(s * (s - a) * (s - b) * (s - c))

                tvResultado.text = String.format("¡Es un triángulo válido!\n\nSemiperímetro (s): %.2f\nÁrea: %.4f u²", s, area)

                // CORRECCIÓN AQUÍ: Se usa View.VISIBLE en lugar de getVisible o cualquier otra palabra
                layoutResultados.visibility = View.VISIBLE
            } else {
                layoutResultados.visibility = View.GONE
                Toast.makeText(this, "Las medidas NO forman un triángulo válido", Toast.LENGTH_LONG).show()
            }
        }
    }
}