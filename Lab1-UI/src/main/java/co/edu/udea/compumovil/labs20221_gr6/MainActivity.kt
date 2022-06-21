package co.edu.udea.compumovil.labs20221_gr6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of use class Person
        var juan = Person(
            "Juan",
            "Morales",
            Person.Gender.NO_BINARY,
            "09/12/1996",
            Person.EducationLevel.UNIVERSITARY,
            ContactInfo("3505824901", "CR 80 # 37 - 44", "juanmorales@gmail.com", "CO", "Medellín")
        )

        juan.gender = Person.Gender.MALE
        juan.contactInfo.phone = "0123456789"

        juan.logData()
    }
}
