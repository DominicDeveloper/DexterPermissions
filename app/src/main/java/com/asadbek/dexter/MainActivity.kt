package com.asadbek.dexter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.asadbek.dexter.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.karumi.dexter.Dexter
import com.karumi.dexter.listener.single.PermissionListener
import com.karumi.dexter.listener.single.SnackbarOnDeniedPermissionListener


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        deadline()

    }
    private fun deadline(){
        val snackbarPermissionListener: PermissionListener =
            SnackbarOnDeniedPermissionListener.Builder
                .with(binding.txt,"NImadirlar")
                .withOpenSettingsButton("Sozlamar")
                .withCallback(object : Snackbar.Callback() {
                    override fun onShown(snackbar: Snackbar) {
                        // Event handler for when the given Snackbar is visible
                    }

                    override fun onDismissed(snackbar: Snackbar, event: Int) {
                        // Event handler for when the given Snackbar has been dismissed
                    }
                }).build()

        Dexter.withActivity(this)
            .withPermission(android.Manifest.permission.CAMERA)
            .withListener(snackbarPermissionListener)
            .check()
    }


}