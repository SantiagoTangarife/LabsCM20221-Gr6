package co.edu.udea.compumovil.labs20221_gr6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun nextButton(view: View){
        val s = "getString(R.string.next)";
        val intent = Intent(this, ContactDataActivity::class.java);
        startActivity(intent);
    }
}