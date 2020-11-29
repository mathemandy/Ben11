package ng.mathemandy.venten.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import ng.mathemandy.venten.R


class MainActivity : AppCompatActivity (),
    ActivityCompat.OnRequestPermissionsResultCallback {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }



}

