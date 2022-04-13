package com.example.demo

import LoginViewModel
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.demo.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: LoginViewModel
    private val retrofitService = RetrofitService.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, LoginViewModelFactory(LoginRepository(retrofitService))).get(
                LoginViewModel::class.java
            )

        binding.login.setOnClickListener(View.OnClickListener {
            viewModel.login(LoginRequest(binding.usernameText.text.toString(), binding.passwordText.text.toString(), "password", "test.token.test", "ANDROID"))
        })

        viewModel.msg.observe(this, {
            when (it) {
                "success" -> startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                "fail" -> Toast.makeText(this@LoginActivity, "Error Logging In", Toast.LENGTH_LONG).show()
            }
        })
    }

}