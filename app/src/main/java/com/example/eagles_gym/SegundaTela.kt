package com.example.eagles_gym

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class SegundaTela : AppCompatActivity() {

    private lateinit var textResultado: TextView
    private lateinit var editPeso: EditText
    private lateinit var editAltura: EditText
    private lateinit var btnVoltar: Button
    private lateinit var btnProximo: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)


        textResultado = findViewById(R.id.textResultado)
        editPeso = findViewById(R.id.editPeso)
        editAltura = findViewById(R.id.editAltura)
        btnVoltar = findViewById(R.id.editVoltar)
        btnProximo = findViewById(R.id.bntProximo)


        btnVoltar.setOnClickListener {
            finish()
        }

        btnProximo.setOnClickListener {
            irParaTerceiraTela()
        }
    }

    @SuppressLint("SetTextI18n")
    fun calcularIMC(view: View) {
        val pesoStr = editPeso.text.toString()
        val alturaStr = editAltura.text.toString()

        if (pesoStr.isNotEmpty() && alturaStr.isNotEmpty()) {
            val peso = pesoStr.toFloatOrNull()
            val altura = alturaStr.toFloatOrNull()

            if (peso != null && altura != null && peso > 0 && altura > 0) {
                val imc = peso / (altura * altura)
                val classificacao = when {
                    imc < 19 -> "Abaixo do peso"
                    imc < 25 -> "Peso normal"
                    imc < 30 -> "Sobrepeso"
                    imc < 40 -> "Obesidade Tipo 1"
                    else -> "Obesidade Tipo 2"
                }

                textResultado.text = "IMC: %.2f - %s".format(imc, classificacao)
            } else {
                Toast.makeText(this, "Peso e altura devem ser maiores que zero!", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
        }
    }

    fun irParaTerceiraTela() {
        val intent = Intent(this, TerceiraTela::class.java)
        startActivity(intent)
        finish()
    }
}
