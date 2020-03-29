package com.example.replacetextwithdrawable

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
import android.text.style.ImageSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.replacetextwithdrawable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val textView = binding.textView

        val string = resources.getString(R.string.explanation)

        val spanText = "cameraIcon"

        val startPosition = string.split(spanText)[0].length
        val endPosition = startPosition + spanText.length

        val ss = SpannableString(string)
        val drawable = ContextCompat.getDrawable(this, R.drawable.ic_photo)
        // Adjust size of drawable to fit with text height
        val lineHeight = textView.lineHeight
        drawable!!.setBounds(0,0,lineHeight, lineHeight)
        ss.setSpan(ImageSpan(drawable), startPosition, endPosition, SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = ss

        setContentView(binding.root)
    }

}
