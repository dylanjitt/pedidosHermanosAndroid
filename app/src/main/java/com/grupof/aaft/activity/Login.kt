package com.grupof.aaft.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.grupof.aaft.R
import com.grupof.aaft.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    var currentUser: FirebaseUser? = null

    private fun init(){
        auth= FirebaseAuth.getInstance()
        currentUser = auth.currentUser
    }

//    private fun initUi() {
//        auth = FirebaseAuth.getInstance()
//        currentUser = auth.currentUser
//
//        binding.run {
//            buttonLogin.setOnClickListener {
//                val email = emailEdit.text.toString()
//                val password = passwordEdit.text.toString()
//                if (validateData(email, password))
//                    loginUser(email, password)
//            }
//            buttonSignup.setOnClickListener {
//                val email = emailEdit.text.toString()
//                val password = passwordEdit.text.toString()
//                if (validateData(email, password))
//                    createNewUser(email, password)
//            }
//            buttonContinue.setOnClickListener {
//                if (currentUser != null) {
//                    redirectActivity()
//                } else {
//                    showMessage("Debes tener una sesión iniciada para continuar")
//                }
//            }
//        }
//    }

    private fun createNewUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    showMessage("Nuevo usuario Creado")
                } else {
                    showMessage("Algo salió mal, intente nuevamente")
                }
            }
    }

    private fun loginUser(email:String,password:String){
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(){ task ->
                if(task.isSuccessful){
                    redirectActivity()
                }else{
                    showMessage("Usuario o Contraseña incorrectos")
                }
            }
    }

    private fun validateData(email: String, password: String): Boolean {
        var valid = true
        if (email.isEmpty()) {
            valid = false
            showMessage("Ingresa un correo")
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            valid = false
            showMessage("Ingresa un correo válido")
        } else if (password.isEmpty()) {
            valid = false
            showMessage("Ingresa una contraseña")
        } else if (password.length < 8) {
            valid = false
            showMessage("Ingresa una contraseña de al menos 8 dígitos")
        }
        return valid
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun redirectActivity() {
        val intentRedirect = Intent(this, MainActivity::class.java)
        startActivity(intentRedirect)
//        quita el activity de la pila:
        finish()
    }
}