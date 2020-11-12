package br.com.loadti.conversortemperatura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbarInit()
        btnConverter.setOnClickListener { converterTemperatura(it) }
    }


    /*Inicializa o toolbar*/
    fun toolbarInit() {

        tbMain.title = getString(R.string.toolbarTitle)
        setSupportActionBar(tbMain)

    }

    /*Realiza a conversao*/
    fun converterTemperatura(view: View) {

        /*Verifica se a edit valor da temperatura nao esta vazio
        * pois se estiver vazia o sistema ocorrera em erro de conversao*/
        if (!edtTemperatura.text.toString().isEmpty()) {

            /*Coloca um bloco try/catch para capturar erros*/
            try {

                var temperatura: Double = edtTemperatura.text.toString().toDouble()
                //
                if (CelciusBottom.isChecked) {

                    temperatura = (temperatura - 32) * 5 / 9;

                } else if (FahrenheitButton.isChecked) {

                    temperatura = (temperatura * 9 / 5) + 32;

                }

                edtTemperatura.setText("$temperatura")


            } catch (e: Exception) {

                Toast.makeText(view.context,
                        "Desculpe, ocorreu o seguinte erro ao converter a temperatura  + ${e.message}",
                        Toast.LENGTH_LONG).show()

            }


        } else {

            Toast.makeText(view.context,
                    "Por favor informe o valor a converter.",
                    Toast.LENGTH_SHORT).show()
        }

    }
}

