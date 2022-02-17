package com.example.clickmeapp

//import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private val TAG = "MainActivity"
private val TEXT = "TEXT_CONTENT"

class MainActivity : AppCompatActivity() {

    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput: EditText = findViewById<EditText>(R.id.editTextTextPersonName2)
        val button: Button = findViewById<Button>(R.id.button5)
        textView = findViewById<TextView>(R.id.textView2)

        textView?.text = ""

        textView?.movementMethod = ScrollingMovementMethod()

        button?.setOnClickListener(object :View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d(TAG, "onClick")
                textView?.append(userInput.text)
                textView?.append("\n")
                userInput.setText("")
                userInput.text.clear()
            }
        })
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
    }

    //Al recrear la actividad después de destruirla
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text = savedInstanceState.getString(TEXT)
    }

    //Siempre se llama despues de onPaue
    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    //onPause: cuando un componente ya no tiene acceso visual a el.
    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
        outState.putString(TEXT, textView?.text.toString())
    }

    //onStop: Cuando la actividad deja de ser visual
    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }
}