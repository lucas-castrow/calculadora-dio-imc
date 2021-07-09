package com.example.appimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = btCalcular

        button.setOnClickListener {
            showAlertDialog(calcularIMC(inputPeso.text.toString(), inputAltura.text.toString()))
        }
    }

    fun showAlertDialog(imc: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("IMC calculado")
        //set message for alert dialog
        when(imc){
            "0" -> builder.setMessage("Não foi possivel mostrar seu IMC, tente novamente ")
            else -> builder.setMessage("Seu IMC foi calculado: ${imc} ")
        }

        builder.setPositiveButton("Valeu!"){dialogInterface, which ->
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    private fun calcularIMC(peso: String, altura: String) : String{
        val peso = peso.toDoubleOrNull()
        val altura = altura.toDoubleOrNull()

        if(peso != null && altura != null){
            val imc = peso / (altura * altura)
            return "%.2f".format(imc)
        }else{
            return "0"
        }
    }


}