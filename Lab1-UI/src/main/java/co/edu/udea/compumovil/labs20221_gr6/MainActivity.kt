package co.edu.udea.compumovil.labs20221_gr6

<<<<<<< HEAD
=======
import android.app.DatePickerDialog
import android.app.Dialog
>>>>>>> main
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
<<<<<<< HEAD
import android.widget.Button
=======
import android.widget.*

import androidx.fragment.app.DialogFragment
import java.util.*

var fecha: EditText? = null

class MainActivity : AppCompatActivity(), View.OnClickListener {


>>>>>>> main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
<<<<<<< HEAD
        setContentView(R.layout.activity_main)

    }

    fun nextButton(view: View){
        val s = "getString(R.string.next)";
        val intent = Intent(this, ContactDataActivity::class.java);
        startActivity(intent);
=======
        setContentView(R.layout.personal_data_activity)

        iniciarSeleccion()

        val spinner= findViewById<Spinner>(R.id.spinnerList)

        var lista=resources.getStringArray(R.array.opciones)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)
        spinner.adapter=adaptador

>>>>>>> main
    }

    private fun iniciarSeleccion(){
        fecha=findViewById(R.id.etDate)
        fecha?.setOnClickListener(this)
    }

    override fun onClick(p0: View){
    val fe=DatePickerFragment{year, month, day ->mostrarResultado(year,month,day)  }
    fe.show(supportFragmentManager, "DatePicker")
    }

    private fun mostrarResultado(year: Int, month: Int, day: Int) {
        fecha?.setText("$year/$month/$day")
    }

     fun sig(view: View){
         val nombre=findViewById<EditText>(R.id.Name)
         val apellido=findViewById<EditText>(R.id.LastName)
         val nacimiento=findViewById<EditText>(R.id.etDate)
//         val educationLevel = findViewById<Spinner>(R.id.spinnerList)


         var person = Person(
             nombre.text.toString(),
             apellido.text.toString(),
             Person.Gender.MALE,
             nacimiento.text.toString(),
             Person.EducationLevel.UNIVERSITARY,
         )

         if(person.isValid(this)){
             val intent:Intent=Intent(this,Pantalla2_Activity::class.java)
             startActivity(intent)
         } else {
             nombre.error = person.dataErrors["firstName"]
             apellido.error = person.dataErrors["lastName"]
             nacimiento.error = person.dataErrors["birthday"]
         }
    }

    class DatePickerFragment (val listener: (year:Int, month: Int, day:Int) -> Unit):DialogFragment(),DatePickerDialog.OnDateSetListener{

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val c= Calendar.getInstance()
            val year=c.get(Calendar.YEAR)
            val month= c.get(Calendar.MONTH)
            val day= c.get(Calendar.DAY_OF_MONTH)

            return DatePickerDialog(requireActivity(), this,year,month,day)
        }

        override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
            listener(year,month,day)
        }
    }}

