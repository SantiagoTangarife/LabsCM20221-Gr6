package co.edu.udea.compumovil.labs20221_gr6

import android.content.Context
import android.util.Log
import android.util.Patterns

private const val TAG = "ContactInfo"

class ContactInfo (
    var phone: String,
    var address: String? = null,
    var email: String,
    var country: String,
    var city: String? = null
) {
    val dataErrors = mutableMapOf<String, String>()

    fun isValid(context: Context): Boolean {
        var isValidData = true

        if(phone.isBlank()) {
            dataErrors["phone"] = context.getString(R.string.required_field)
            isValidData = false;
        }else if(!Patterns.PHONE.matcher(phone).matches()){
            dataErrors["phone"] = context.getString(R.string.wrong_phone)
            isValidData = false;
        }

        if(email.isBlank()) {
            dataErrors["email"] = context.getString(R.string.form_required_field)
            isValidData = false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            dataErrors["email"] = context.getString(R.string.wrong_email)
            isValidData = false;
        }
        if(country.isBlank()) {
            dataErrors["country"] = context.getString(R.string.form_required_field)
            isValidData = false;
        }

        return isValidData;
    }

    // Print values
    fun logData() {
        Log.i(TAG, "========================================")
        Log.i(TAG, "Información de Contacto")
        Log.i(TAG, "Teléfono: ${phone}")
        if (address != null) {
            Log.i(TAG, "Dirección: ${address}")
        }
        Log.i(TAG, "Email: ${email}")
        Log.i(TAG, "País: ${country}")
        Log.i(TAG, "Ciudad: ${city}")
        Log.i(TAG, "========================================")
    }
}
