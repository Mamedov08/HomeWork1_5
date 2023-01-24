package com.example.homework1_5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.homework1_5.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerForActivity()
        initClicker()
    }


    private fun registerForActivity() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.editTextFirst.setText(result.data?.getStringExtra(TEXT_NAME))
                }
            }
    }

    private fun initClicker() {
        binding.buttonFirst.setOnClickListener {
            if (binding.editTextFirst.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, getString(R.string.check), Toast.LENGTH_SHORT).show()
            } else sendData()
        }

    }

    private fun sendData() {
        Intent(this, SecondActivity::class.java).apply {
            putExtra(TEXT_NAME, binding.editTextFirst.text.toString())
            resultLauncher.launch(this)
        }

    }
    companion object {
        const val TEXT_NAME = "text_name"
    }
}