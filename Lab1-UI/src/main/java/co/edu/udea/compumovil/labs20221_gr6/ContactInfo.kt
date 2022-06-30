package co.edu.udea.compumovil.labs20221_gr6

import android.util.Log

private const val TAG = "ContactInfo"

class ContactInfo (
    var phone: String,
    var address: String? = null,
    var email: String,
    var country: String,
    var city: String? = null
) {
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
