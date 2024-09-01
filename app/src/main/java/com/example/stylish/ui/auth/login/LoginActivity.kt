package com.example.stylish.ui.auth.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stylish.R
import com.example.stylish.databinding.ActivityLoginBinding
import com.example.stylish.ui.auth.forgotPassword.ForgotPasswordActivity
import com.example.stylish.ui.auth.register.RegisterActivity
import com.example.stylish.ui.welcomeScreen.WelcomeActivity

class LoginActivity : AppCompatActivity() {
    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.signUp?.setOnClickListener {
            startActivity(
                Intent(this@LoginActivity, RegisterActivity::class.java)
            )
        }

        binding?.forgotPassword?.setOnClickListener {
            startActivity(
                Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
            )
        }

        binding?.loginButton?.setOnClickListener {
            startActivity(
                Intent(this@LoginActivity, WelcomeActivity::class.java)
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}