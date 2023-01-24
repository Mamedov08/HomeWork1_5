package com.example.homework1_5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework1_5.MainActivity.Companion.TEXT_NAME
import com.example.homework1_5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClicker()

    }

    private fun initClicker() {
        binding.editTextSecond.setText(intent.getStringExtra(TEXT_NAME))

        binding.buttonSecond.setOnClickListener {
            if (binding.editTextSecond.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, getString(R.string.check), Toast.LENGTH_SHORT).show()
            } else sendData()
        }
    }

    private fun sendData() {
        Intent(this, MainActivity::class.java).apply {
            putExtra(TEXT_NAME, binding.editTextSecond.text.toString())
            setResult(Activity.RESULT_OK, this)
        }

        finish()
}
}