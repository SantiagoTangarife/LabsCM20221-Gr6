package co.edu.udea.compumovil.labs20221_gr6

import android.util.Log

private const val TAG = "Person"

class Person(
    var firstName: String,
    var lastName: String,
    var gender: Gender? = null,
    var birthday: String,
    var educationLevel: EducationLevel? = null,
    var contactInfo: ContactInfo
) {
    enum class Gender(val value: String) {
        MALE("Masculino"),
        FEMALE("Femenino"),
        NO_BINARY("No Binario")
    }

    enum class EducationLevel(val value: String) {
        PRIMARY("Primaria"),
        SECONDARY("Secundaria"),
        UNIVERSITARY("Universitaria"),
        OTHER("Otro")
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
            Log.i(TAG, educationLevel!!.value)
        }
        Log.i(TAG, "========================================")
        contactInfo.logData()
    }
}
