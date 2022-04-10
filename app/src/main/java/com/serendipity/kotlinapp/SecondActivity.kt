package com.serendipity.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.serendipity.kotlinapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater).also { setContentView(it.root) }
        initListeners()
        initData()
    }


    private fun initListeners() {
        binding.btnSecond.setOnClickListener {
            val text = binding.etSecond.text.toString()
            if (text.isNotBlank())
                transaction(text)
            else
                Toast.makeText(this, "EditText can not be empty!", Toast.LENGTH_SHORT)
                    .show()        }
    }

    private fun transaction(text: String) {

    }
    private fun initData() {
        val date: Bundle? = intent.extras
        val text = date?.getString("Text")
        setText(text)
    }

    private fun setText(text: String?) {
        binding.etSecond.setText(text)

    }
}