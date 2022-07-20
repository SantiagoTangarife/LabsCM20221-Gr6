package co.edu.udea.compumovil.labs20221_gr6

import android.content.Context
import android.util.Log
import java.io.Serializable

private const val TAG = "Person"

class Person(
    var firstName: String,
    var lastName: String,
    var gender: Gender? = null,
    var birthday: String,
    var educationLevel: String? = null,
    var contactInfo: ContactInfo? = null
): Serializable {
    enum class Gender(val value: String) {
        MALE("Masculino"),
        FEMALE("Femenino")
    }

    val dataErrors = mutableMapOf<String, String>()

    fun isValid(context: Context): Boolean {
        var isValidData = true

        if(firstName.isBlank()) {
            dataErrors["firstName"] = context.getString(R.string.required_field)
            isValidData = false;
        }
        if(lastName.isBlank()) {
            dataErrors["lastName"] = context.getString(R.string.form_required_field)
            isValidData = false;
        }
        if(birthday.isBlank()) {
            dataErrors["birthday"] = context.getString(R.string.form_required_field)
            isValidData = false;
        }

        return isValidData;
    }

    fun logData() {
        Log.i(TAG, "========================================")
        Log.i(TAG, "Información Personal")
        Log.i(TAG, "${firstName} ${lastName}")
        if (gender != null) {
            Log.i(TAG, gender!!.value)
        }
        Log.i(TAG, "Nació el ${birthday}")
        if (educationLevel != null) {
            Log.i(TAG, educationLevel.toString())
        }
        Log.i(TAG, "========================================")
        contactInfo?.logData()
    }
}
