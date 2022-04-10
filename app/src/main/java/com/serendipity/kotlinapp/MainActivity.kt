package com.serendipity.kotlinapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.serendipity.kotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var openActivity: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        initListeners()
        initLaunch()

    }

    private fun initLaunch() {
        openActivity =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    val intent: Intent? = it.data
                    val text = intent?.getStringExtra("Text")
                    setText(text)
    }
            }
    }

    private fun setText(text: String?) {
        binding.etMain.setText(text)

    }

    private fun initListeners() {
        binding.btnMain.setOnClickListener{
            val text = binding.etMain.text.toString()
            if (text.isNotBlank())
                transaction(text)
                Toast.makeText(this, "EditText can not be empty!", Toast.LENGTH_SHORT)
                    .show()
        }
    }

    private fun transaction(text: String) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("Text", text)
        openActivity.launch(intent)

    }
}