package garcia.carlosdamian.thecheezery_garciacarlosdamian

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import garcia.carlosdamian.thecheezery.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val buttonStart:Button = findViewById(R.id.button_get_started)

        buttonStart.setOnClickListener{
            var intent: Intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}