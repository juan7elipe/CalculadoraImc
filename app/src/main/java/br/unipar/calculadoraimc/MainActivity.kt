package br.unipar.calculadoraimc

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputAltura = findViewById<EditText>(R.id.edAltura)
        val inputPeso = findViewById<EditText>(R.id.edPeso)
        val botaoCalcular = findViewById<Button>(R.id.btnImc)
        val resultado = findViewById<TextView>(R.id.txtResultado)


        botaoCalcular.setOnClickListener {
            val alturaString = inputAltura.text.toString()
            val pesoString = inputPeso.text.toString()


            if (alturaString.isNotEmpty() && pesoString.isNotEmpty()) {
                val altura = alturaString.toDouble()
                val peso = pesoString.toDouble()
                val resultadoImc = peso / (altura * altura)

                if (resultadoImc < 18.5) {
                    resultado.text = "Abaixo do peso"

                } else if (resultadoImc in 18.5..24.9) {
                    resultado.text = "Peso Normal"

                } else if (resultadoImc in 25.toDouble()..29.9) {
                    resultado.text = "Sobrepeso"

                } else if (resultadoImc >= 30) {
                    resultado.text = "Obesidade"

                } else {
                    resultado.text = "Valor Inválido"
                }
            }
        }
    }
    fun limparValores(view: View) {
        val resultado = findViewById<TextView>(R.id.txtResultado)
        val input = findViewById<EditText>(R.id.edAltura)
        val input2 = findViewById<EditText>(R.id.edPeso)

        resultado.setText("")
        input.setText("")
        input2.setText("")
    }
}