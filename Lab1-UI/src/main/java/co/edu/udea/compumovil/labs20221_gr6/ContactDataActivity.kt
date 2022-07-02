package co.edu.udea.compumovil.labs20221_gr6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText

class ContactDataActivity : AppCompatActivity() {

    private var person : Person? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)

        person = intent.getSerializableExtra("Person") as Person?

        val countries = resources.getStringArray(R.array.latam_countries);
        val autoCountry : AutoCompleteTextView = findViewById(R.id.country_text);
        val adapterCountry : ArrayAdapter<String> = ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, countries);
        autoCountry.setAdapter(adapterCountry);

        val cities = resources.getStringArray(R.array.colombia_cities);
        val autoCity : AutoCompleteTextView = findViewById(R.id.city_text);
        val adapterCity : ArrayAdapter<String> = ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, cities);
        autoCity.setAdapter(adapterCity);
    }

    fun nextButton(view: View){
        val phoneField = findViewById<EditText>(R.id.phone_text);
        val countryField = findViewById<EditText>(R.id.country_text);
        val emailField = findViewById<EditText>(R.id.email_text);
        val cityField = findViewById<EditText>(R.id.city_text);
        val addressField = findViewById<EditText>(R.id.address_text);

        var contactInfo = ContactInfo(
            phoneField.text.toString(),
            addressField?.text.toString(),
            emailField.text.toString(),
            countryField.text.toString(),
            cityField?.text.toString()
        )

        if(contactInfo.isValid(this)){
            person?.contactInfo = contactInfo
            person?.logData()
        }else{
            phoneField.error = contactInfo.dataErrors["phone"]
            emailField.error = contactInfo.dataErrors["email"]
            countryField.error = contactInfo.dataErrors["country"]
        }
    }
}