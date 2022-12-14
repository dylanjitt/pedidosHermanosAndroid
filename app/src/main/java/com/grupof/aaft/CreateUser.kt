package com.grupof.aaft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.grupof.aaft.databinding.ActivityCreateUserBinding
import com.grupof.aaft.databinding.ActivityLoginBinding

class CreateUser : AppCompatActivity() {

    private lateinit var binding: ActivityCreateUserBinding
    private lateinit var auth: FirebaseAuth
    var currentUser: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        agregarUsuario()
    }

    private fun agregarUsuario(){
        auth = FirebaseAuth.getInstance()
        currentUser = auth.currentUser
        binding.run{
            botonConfirmar.setOnClickListener{
                val email = email.text.toString()
                val password = password.text.toString()
                if (validateData(email, password)){
                    createNewUser(email, password)
                    redirectActivity()
                }
            }
            botonCancelar.setOnClickListener{
                redirectActivity()
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

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun redirectActivity() {
        val intentRedirect = Intent(this, Login::class.java)
        startActivity(intentRedirect)
        finish()
    }

}