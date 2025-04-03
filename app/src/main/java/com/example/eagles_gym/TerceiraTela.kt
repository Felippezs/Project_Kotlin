package com.example.eagles_gym

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TerceiraTela : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terceira_tela)

        val buttonVoltar = findViewById<Button>(R.id.button3)
        val inputNota = findViewById<EditText>(R.id.editTextText)
        val buttonAvaliar = findViewById<Button>(R.id.Editavaliar)
        val textResultado = findViewById<TextView>(R.id.textView8)

        buttonVoltar.setOnClickListener {
            voltarParaSegundaTela()
        }

        buttonAvaliar.setOnClickListener {
            avaliarNota(inputNota, textResultado)
        }
    }

    private fun voltarParaSegundaTela() {
        val intent = Intent(this, SegundaTela::class.java)
        startActivity(intent)
        finish()
    }

    @SuppressLint("SetTextI18n")
    private fun avaliarNota(inputNota: EditText, textResultado: TextView) {
        val nota = inputNota.text.toString().toFloatOrNull()

        if (nota != null && nota in 0.0..10.0) {
            val resultado = when {
                nota < 4 -> "Reprovado"
                nota in 4.0..5.9 -> "Prova Sub"
                nota >= 6 -> "Aprovado"
                else -> "Nota inválida"
            }
            textResultado.text = "Status: $resultado"
        } else {
            textResultado.text = "Digite uma nota válida (0 a 10)!"
        }
    }
}
