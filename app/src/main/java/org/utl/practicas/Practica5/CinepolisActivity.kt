package org.utl.practicas.Practica5

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.utl.practicas.R

class CinepolisActivity : AppCompatActivity() {

    private val PRECIO_BOLETA = 12.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cinepolis)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etCantidadCompradores = findViewById<EditText>(R.id.etCantidadCompradores)
        val etCantidadBoletas = findViewById<EditText>(R.id.etCantidadBoletas)
        val rgTarjetaCineco = findViewById<RadioGroup>(R.id.rgTarjetaCineco)
        val rbCinecoSi = findViewById<RadioButton>(R.id.rbCinecoSi)

        val btnProcesar = findViewById<Button>(R.id.btnProcesar)
        val btnSalir = findViewById<Button>(R.id.btnSalir)
        val tvValorAPagar = findViewById<TextView>(R.id.tvValorAPagar)

        btnProcesar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val compradoresStr = etCantidadCompradores.text.toString().trim()
            val boletasStr = etCantidadBoletas.text.toString().trim()

            if (nombre.isEmpty() || compradoresStr.isEmpty() || boletasStr.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val cantCompradores = compradoresStr.toInt()
            val cantBoletas = boletasStr.toInt()

            val maximoPermitido = cantCompradores * 7
            if (cantBoletas > maximoPermitido) {
                Toast.makeText(
                    this,
                    "No se permiten más de 7 boletas por persona (Máx. para este grupo: $maximoPermitido)",
                    Toast.LENGTH_LONG
                ).show()
                tvValorAPagar.text = "Valor a Pagar: Error en cantidad"
                return@setOnClickListener
            }

            var subtotal = cantBoletas * PRECIO_BOLETA

            if (cantBoletas > 5) {
                subtotal -= (subtotal * 0.15)
            } else if (cantBoletas in 3..5) {
                subtotal -= (subtotal * 0.10)
            }

            if (rbCinecoSi.isChecked) {
                subtotal -= (subtotal * 0.10)
            }

            tvValorAPagar.text = String.format("Valor a Pagar: $%,.2f", subtotal)
        }

        btnSalir.setOnClickListener {
            finish()
        }
    }
}