package co.edu.udea.compumovil.labs20221_gr6

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

import androidx.fragment.app.DialogFragment
import java.util.*

var fecha: EditText? = null

class MainActivity : AppCompatActivity(), View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.personal_data_activity)

        iniciarSeleccion()




        val spinner= findViewById<Spinner>(R.id.spinnerList)

        var lista=resources.getStringArray(R.array.opciones)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)
        spinner.adapter=adaptador





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

    private fun validacion():Boolean{
        var isvalid=true
        val nombre=findViewById<EditText>(R.id.Name)
        val apellido=findViewById<EditText>(R.id.LastName)
        val nacimiento=findViewById<EditText>(R.id.etDate)

        if(nombre.text.toString().isBlank()){
            isvalid=false
            nombre.error=getString(R.string.form_required_field)
        }
        if(apellido.text.toString().isBlank()){
            isvalid=false
            apellido.error=getString(R.string.form_required_field)
        }
        if(nacimiento.text.toString().isBlank()){
            isvalid=false
            nacimiento.error=getString(R.string.form_required_field)
        }

        return isvalid
    }

     fun sig(view: View){
        if(validacion()){
            val intent:Intent=Intent(this,Pantalla2_Activity::class.java)
            startActivity(intent)
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

