package co.edu.udea.compumovil.labs20221_gr6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class ContactDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)

        val countries = resources.getStringArray(R.array.latam_countries);
        val autoCountry : AutoCompleteTextView = findViewById(R.id.autoCompleteCountry);
        val adapterCountry : ArrayAdapter<String> = ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, countries);
        autoCountry.setAdapter(adapterCountry);

        val cities = resources.getStringArray(R.array.colombia_cities);
        val autoCity : AutoCompleteTextView = findViewById(R.id.autoCompleteCity);
        val adapterCity : ArrayAdapter<String> = ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, cities);
        autoCity.setAdapter(adapterCity);
    }
}