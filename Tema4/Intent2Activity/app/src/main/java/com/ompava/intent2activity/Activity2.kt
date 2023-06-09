package com.ompava.intent2activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ompava.intent2activity.MainActivity.Companion.KEY_EXTRA_NAME
import com.ompava.intent2activity.MainActivity.Companion.KEY_EXTRA_RESULT
import com.ompava.intent2activity.MainActivity.Companion.KEY_EXTRA_RESULT_PARCELABLE
import com.ompava.intent2activity.MainActivity.Companion.KEY_EXTRA_SURNAME
import com.ompava.intent2activity.databinding.Activity2Binding
import com.ompava.intent2activity.model.Person

class Activity2 : AppCompatActivity() {
    private lateinit var binding:Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(Activity2Binding.inflate(layoutInflater).also { binding = it }.root)


        //retrieveMainActivityData()
        getParcelableFromIntent()

        binding.btnBack.setOnClickListener {
            sendBackName()
        }

    }

    private fun getParcelableFromIntent() {
        var myText:String? = null

        if(intent.hasExtra(KEY_EXTRA_RESULT_PARCELABLE)){
            val person = intent.getParcelableExtra<Person>(KEY_EXTRA_RESULT_PARCELABLE)
            person.let{person ->
                myText = "${person?.name} ${person?.surname}"
            }
        }

        binding.tvTop.text = myText?:"No user"
    }

    private fun sendBackName() {
        val text = binding.etName.text.toString()
        val returnIntent = Intent().apply {
            putExtra(KEY_EXTRA_RESULT, text)
        }   //Creates a new Intent with editText content as an extra

        if(text != "")
            setResult(RESULT_OK, returnIntent) //The action went ok.
        else
            setResult(RESULT_CANCELED, returnIntent)

        finish() //Finish and close this activity
    }


    //This function checks if there is any data on the intent and set it into the TextView
    private fun retrieveMainActivityData() {
        var name:String? = null

        if(intent.hasExtra(KEY_EXTRA_NAME))
            name = "${intent.getStringExtra(KEY_EXTRA_NAME).toString()}"

        if(intent.hasExtra(KEY_EXTRA_SURNAME))
            name = "${name?:""} ${intent.getStringExtra(KEY_EXTRA_SURNAME).toString()}"

        binding.tvTop.text = name ?: "No user"
    }
}