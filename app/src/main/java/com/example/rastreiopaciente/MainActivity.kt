package com.example.rastreiopaciente

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.rastreiopaciente.Banco.Banco
import com.example.rastreiopaciente.Banco.Usuario
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    //Cria a variavel para o banco
    lateinit var banco: Banco

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //instacia o banco
        banco = Room.databaseBuilder(applicationContext, Banco::class.java, "teste").allowMainThreadQueries().build()

        //Cria um novo usuario
        val usuario = Usuario()
        usuario.id_usuario = 1
        usuario.nome = "Mariane"
        usuario.senha = "mfpl"
        usuario.senha = "123"
        usuario.email = "teste@gmail"
        usuario.credencial = "254511"

        //insere um usuario no banco
        banco.usuarioCrud().inserirUsuario(usuario)

        val btnEntrar = findViewById<Button>(R.id.button_entrar)

        btnEntrar.setOnClickListener {

            var usuario1 = banco.usuarioCrud().getUsuario(1)

            var usr = findViewById<EditText>(R.id.text_usuario)
            var senha = findViewById<EditText>(R.id.text_senha)

            try {
                if ((usuario1.login == usr.text.toString()) && (usuario1.senha == senha.text.toString())) {
                    Toast.makeText(
                        this,
                        "Usuário Autenticado!",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        this,
                        "Usuário Incorreto!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (e: Exception){
                Toast.makeText(
                    this,
                    e.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }
}
