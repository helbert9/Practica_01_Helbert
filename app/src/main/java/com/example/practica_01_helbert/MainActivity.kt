package com.example.practica_01_helbert

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener {
            calcularNotaFinal()
        }
    }

    private fun calcularNotaFinal() {
        val notaParcial = etNotaParcial.text.toString().toFloatOrNull() ?: 0.0f
        val notaFinal = etNotaFinal.text.toString().toFloatOrNull() ?: 0.0f
        val pep = etPEP.text.toString().toFloatOrNull() ?: 0.0f

        if (notaParcial == 0.0f || notaFinal == 0.0f || pep == 0.0f) {
            mostrarError("Ingrese todas las notas")
            return
        }

        val notaFinalCalculada = (notaParcial + notaFinal + pep) / 3

        tvNotaFinal.text = "Nota Final: ${String.format("%.2f", notaFinalCalculada)}"

        if (notaFinalCalculada >= 10.5) {
            tvResultado.text = "Resultado: Aprobado"
        } else {
            tvResultado.text = "Resultado: Desaprobado"
        }
    }

    private fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}


