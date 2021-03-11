package Ken.example.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val secretNumber = SecretNumber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("test", "secret : " + secretNumber.secret)
    }

    fun check(view : View){
        val n = ed_number.text.toString().toInt()
        println("number : $n")
        Log.d("test","num : " + n)
        val diff = secretNumber.validate(n)
        var msg = "yesUGotIt !"
        if(secretNumber.validate(n) < 0){
            msg = "BIGGER";
//            Toast.makeText(this, "BIGGER", Toast.LENGTH_LONG).show()
        }else if(diff > 0){
            msg = "smaller";
//            Toast.makeText(this, "smaller", Toast.LENGTH_LONG).show()
        }else{
//            Toast.makeText(this, "命中 ! ", Toast.LENGTH_LONG).show()
        }
//        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setTitle("Message")
            .setMessage(msg)
            .setPositiveButton("OK", null)
            .show()
    }

}

