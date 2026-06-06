package org.utl.practicas.Practica3

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.utl.practicas.R
import java.util.Calendar

class SignoZodiacalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signo_zodiacal)

        val btnImprimir = findViewById<Button>(R.id.btnImprimir)
        val layoutResultados = findViewById<LinearLayout>(R.id.layoutResultadosZodiaco)
        val tvSaludo = findViewById<TextView>(R.id.tvSaludo)
        val tvEdad = findViewById<TextView>(R.id.tvEdad)
        val tvSignoNombre = findViewById<TextView>(R.id.tvSignoNombre)
        val ivSignoIcono = findViewById<ImageView>(R.id.ivSignoIcono)

        btnImprimir.setOnClickListener {
            val nombre = findViewById<EditText>(R.id.etNombre).text.toString()
            val aPaterno = findViewById<EditText>(R.id.etAPaterno).text.toString()
            val aMaterno = findViewById<EditText>(R.id.etAMaterno).text.toString()
            val diaStr = findViewById<EditText>(R.id.etDia).text.toString()
            val mesStr = findViewById<EditText>(R.id.etMes).text.toString()
            val anioStr = findViewById<EditText>(R.id.etAnio).text.toString()
            val rgSexo = findViewById<RadioGroup>(R.id.rgSexo)

            if (nombre.isEmpty() || aPaterno.isEmpty() || aMaterno.isEmpty() ||
                diaStr.isEmpty() || mesStr.isEmpty() || anioStr.isEmpty() || rgSexo.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                layoutResultados.visibility = View.GONE
                return@setOnClickListener
            }

            val anioNac = anioStr.toInt()
            val mesNac = mesStr.toInt()
            val diaNac = diaStr.toInt()

            // Calcular edad basándonos en el año actual (2026)
            val hoy = Calendar.getInstance()
            var edad = hoy.get(Calendar.YEAR) - anioNac
            if (hoy.get(Calendar.MONTH) + 1 < mesNac ||
                (hoy.get(Calendar.MONTH) + 1 == mesNac && hoy.get(Calendar.DAY_OF_MONTH) < diaNac)) {
                edad--
            }

            // Procesar información del Horóscopo Chino
            val resto = anioNac % 12
            var nombreSigno = ""
            var imagenResId = R.drawable.rata

            when (resto) {
                0 -> { nombreSigno = "Mono"; imagenResId = R.drawable.mono }
                1 -> { nombreSigno = "Gallo"; imagenResId = R.drawable.gallo }
                2 -> { nombreSigno = "Perro"; imagenResId = R.drawable.perro }
                3 -> { nombreSigno = "Cerdo"; imagenResId = R.drawable.cerdo }
                4 -> { nombreSigno = "Rata"; imagenResId = R.drawable.rata }
                5 -> { nombreSigno = "Buey"; imagenResId = R.drawable.buey }
                6 -> { nombreSigno = "Tigre"; imagenResId = R.drawable.tigre }
                7 -> { nombreSigno = "Conejo"; imagenResId = R.drawable.conejo }
                8 -> { nombreSigno = "Dragón"; imagenResId = R.drawable.dragon }
                9 -> { nombreSigno = "Serpiente"; imagenResId = R.drawable.serpiente }
                10 -> { nombreSigno = "Caballo"; imagenResId = R.drawable.caballo }
                11 -> { nombreSigno = "Cabra"; imagenResId = R.drawable.cabra }
            }

            // Desplegar datos en la misma pantalla
            tvSaludo.text = "Hola $nombre $aPaterno $aMaterno"
            tvEdad.text = "Tienes $edad años"
            tvSignoNombre.text = "Tu signo zodiacal es: $nombreSigno"
            ivSignoIcono.setImageResource(imagenResId)

            layoutResultados.visibility = View.VISIBLE
        }

    }
}