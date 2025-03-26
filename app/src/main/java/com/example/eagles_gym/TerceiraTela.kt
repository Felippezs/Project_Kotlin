package com.example.eagles_gym

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class TerceiraTela : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terceira_tela)


        val buttonVoltar = findViewById<View>(R.id.button3)


        buttonVoltar.setOnClickListener {

            val intent = Intent(this, SegundaTela::class.java)
            startActivity(intent)
            finish()
        }
    }
}
