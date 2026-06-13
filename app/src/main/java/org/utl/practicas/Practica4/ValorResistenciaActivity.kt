package org.utl.practicas.Practica4

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.utl.practicas.R
import kotlin.math.pow

class ValorResistenciaActivity : AppCompatActivity() {

    private val coloresBandas = listOf(
        Triple("Negro", 0, "#000000"),
        Triple("Marrón", 1, "#8B4513"),
        Triple("Rojo", 2, "#FF0000"),
        Triple("Naranja", 3, "#FFA500"),
        Triple("Amarillo", 4, "#FFFF00"),
        Triple("Verde", 5, "#008000"),
        Triple("Azul", 6, "#0000FF"),
        Triple("Violeta", 7, "#EE82EE"),
        Triple("Gris", 8, "#808080"),
        Triple("Blanco", 9, "#FFFFFF")
    )

    private val coloresMultiplicador = listOf(
        Triple("Negro (x1)", 1, "#000000"),
        Triple("Marrón (x10)", 10, "#8B4513"),
        Triple("Rojo (x100)", 100, "#FF0000"),
        Triple("Naranja (x1k)", 1000, "#FFA500"),
        Triple("Amarillo (x10k)", 10000, "#FFFF00"),
        Triple("Verde (x100k)", 100000, "#008000"),
        Triple("Azul (x1M)", 1000000, "#0000FF")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_valor_resistencia)

        val spinnerBanda1 = findViewById<Spinner>(R.id.spinnerBanda1)
        val spinnerBanda2 = findViewById<Spinner>(R.id.spinnerBanda2)
        val spinnerMultiplicador = findViewById<Spinner>(R.id.spinnerMultiplicador)

        val viewColor1 = findViewById<View>(R.id.viewColor1)
        val viewColor2 = findViewById<View>(R.id.viewColor2)
        val viewColor3 = findViewById<View>(R.id.viewColor3)

        val rgTolerancia = findViewById<RadioGroup>(R.id.rgTolerancia)
        val rbOro = findViewById<RadioButton>(R.id.rbOro)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        val tvValorOhm = findViewById<TextView>(R.id.tvValorOhm)
        val tvValorMaximo = findViewById<TextView>(R.id.tvValorMaximo)
        val tvValorMinimo = findViewById<TextView>(R.id.tvValorMinimo)

        val adapterBandas = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, coloresBandas.map { it.first })
        val adapterMultiplicador = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, coloresMultiplicador.map { it.first })

        spinnerBanda1.adapter = adapterBandas
        spinnerBanda2.adapter = adapterBandas
        spinnerMultiplicador.adapter = adapterMultiplicador

        spinnerBanda1.setSelection(2)
        spinnerBanda2.setSelection(2)
        spinnerMultiplicador.setSelection(1)

        spinnerBanda1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                viewColor1.setBackgroundColor(Color.parseColor(coloresBandas[position].third))
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        spinnerBanda2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                viewColor2.setBackgroundColor(Color.parseColor(coloresBandas[position].third))
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        spinnerMultiplicador.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                viewColor3.setBackgroundColor(Color.parseColor(coloresMultiplicador[position].third))
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        btnCalcular.setOnClickListener {
            val b1 = coloresBandas[spinnerBanda1.selectedItemPosition].second
            val b2 = coloresBandas[spinnerBanda2.selectedItemPosition].second
            val mult = coloresMultiplicador[spinnerMultiplicador.selectedItemPosition].second

            val valorOhm = ((b1 * 10) + b2) * mult

            val porcentajeTolerancia = if (rbOro.isChecked) 0.05 else 0.10

            val variacion = valorOhm * porcentajeTolerancia
            val valorMaximo = valorOhm + variacion
            val valorMinimo = valorOhm - variacion

            tvValorOhm.text = "valor ohm: $valorOhm"
            tvValorMaximo.text = "valor maximo: ${valorMaximo.toInt()}"
            tvValorMinimo.text = "valor minimo: ${valorMinimo.toInt()}"
        }
    }
}