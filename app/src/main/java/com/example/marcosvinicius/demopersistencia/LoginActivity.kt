package com.example.marcosvinicius.demopersistencia

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences("meuapp", Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("MANTER_CONECTADO", false)){
            proximaTela()
        }

        btConectar.setOnClickListener{
            val editor = sharedPreferences.edit()
            editor.putBoolean("MANTER_CONECTADO", cbManterConectado.isChecked)
            editor.putString("USUARIO", inputNome.text.toString())
            editor.apply()
            proximaTela()

        }
    }

    private fun proximaTela() {
        startActivity(Intent(this, ListaActivity::class.java))
        finish()
    }
}
