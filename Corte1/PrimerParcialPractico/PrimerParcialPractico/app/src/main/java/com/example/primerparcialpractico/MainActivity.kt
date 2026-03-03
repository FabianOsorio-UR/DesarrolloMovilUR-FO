package com.example.primerparcialpractico

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {

    private val anuncios = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mostrarAvisos()
    }

    private fun mostrarAvisos() {
        setContentView(R.layout.activity_avisos)

        val llAnuncios = findViewById<LinearLayout>(R.id.llAnuncios)
        val btCrearGo = findViewById<Button>(R.id.btCrearGo)
        val btBorrarGo = findViewById<Button>(R.id.btBorrarGo)

        llAnuncios.removeAllViews()
        for (anuncio in anuncios) {
            val tv = TextView(this)
            tv.text = anuncio
            
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(30, 0, 30, 0)
            tv.layoutParams = params
            
            llAnuncios.addView(tv)
        }

        btCrearGo.setOnClickListener {
            mostrarCrear()
        }

        btBorrarGo.setOnClickListener {
            if (anuncios.isNotEmpty()) {
                mostrarBorrar()
            }
        }
    }

    private fun mostrarCrear() {
        setContentView(R.layout.activity_crear)

        val etAnuncio = findViewById<EditText>(R.id.etAnuncio)
        val btCrear = findViewById<Button>(R.id.btCrear)

        btCrear.setOnClickListener {
            val texto = etAnuncio.text.toString()
            if (texto.isNotBlank()) {
                anuncios.add(texto)
                mostrarAvisos()
            }
        }
    }

    private fun mostrarBorrar() {
        setContentView(R.layout.activity_borrar)

        val tvAnuncio = findViewById<TextView>(R.id.tvAnuncio)
        val btBorrar = findViewById<Button>(R.id.btBorrar)

        if (anuncios.isNotEmpty()) {
            tvAnuncio.text = anuncios.last()
        }

        btBorrar.setOnClickListener {
            if (anuncios.isNotEmpty()) {
                anuncios.removeAt(anuncios.size - 1)
            }
            mostrarAvisos()
        }
    }
}
