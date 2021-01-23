package com.example.quartaaula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tela_inicial.*

class TelaInicial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        // quando clicado carrega a tela de quem somos
        button_somos.setOnClickListener {
            val intent = Intent(this, QuemSomos::class.java)
            startActivity(intent)
        }

        // quando clicado carrega a tela de informacoes
        button_info.setOnClickListener {
            val intent = Intent(this, Informacoes::class.java)
            startActivity(intent)
        }

        // quando clicado carrega a tela do mapa
        button_mapa.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
    }
}