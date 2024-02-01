package com.pablo_daniel.aa3_interficies.activities

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.messaging.FirebaseMessaging
import com.pablo_daniel.aa3_interficies.R
import com.pablo_daniel.aa3_interficies.firebase.FB
import com.pablo_daniel.aa3_interficies.ui.theme.AA3_InterficiesTheme

class MainActivity : AppCompatActivity() {

    private val requestNotificationPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted->
        onNotificationPermissionResponse(isGranted)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        setContentView(R.layout.activity_main)
        FB.crashalytics.logSingleError("test de error") {
            key("error", "de prueba")
            key("parametro booleano", true)
            key("parametro entero", 32)
            key("parametro float", 50.690)
        }
        setTheme(FB.remoteConfig.getTheme().themeId)
        askNotificationPermission()
    }
    fun onNotificationPermissionResponse(isGranted:Boolean){
        if(isGranted){
            FirebaseMessaging.getInstance().token.addOnSuccessListener { token ->
                Log.d("Token","Token::> " + token)

            }.addOnFailureListener {
                //TODO ERROR
            }


        }else{
            //TODO ERROR
        }
    }

    fun askNotificationPermission(){
        val permission = Manifest.permission.POST_NOTIFICATIONS

        if(ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED){
            FirebaseMessaging.getInstance().token.addOnSuccessListener { token ->
                Log.d("TokenMalo","Token::> " + token)

            }.addOnFailureListener {
                //TODO ERROR
            }
        }else if(shouldShowRequestPermissionRationale(permission)){
            //Move to setup screen
        }else{
            requestNotificationPermissionLauncher.launch(permission)
        }

    }
}
