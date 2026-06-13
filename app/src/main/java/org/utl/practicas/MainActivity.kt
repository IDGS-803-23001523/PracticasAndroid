package org.utl.practicas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import org.utl.practicas.Practica1.DistanciaDosPuntosActivity
import org.utl.practicas.Practica2.DeterminarTrianguloActivity
import org.utl.practicas.Practica3.SignoZodiacalActivity
import org.utl.practicas.Practica4.ValorResistenciaActivity
import org.utl.practicas.Practica5.CinepolisActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnPractica1).setOnClickListener {
            startActivity(Intent(this, DistanciaDosPuntosActivity::class.java))
        }

        findViewById<Button>(R.id.btnPractica2).setOnClickListener {
            startActivity(Intent(this, DeterminarTrianguloActivity::class.java))
        }

        findViewById<Button>(R.id.btnPractica3).setOnClickListener {
            startActivity(Intent(this, SignoZodiacalActivity::class.java))
        }

        findViewById<Button>(R.id.btnPractica4).setOnClickListener {
            startActivity(Intent(this, ValorResistenciaActivity::class.java))
        }

        findViewById<Button>(R.id.btnPractica5).setOnClickListener {
            startActivity(Intent(this, CinepolisActivity::class.java))
        }
    }
}