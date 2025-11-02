package factcampus.part1.cameragallery

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresExtension
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import factcampus.part1.cameragallery.databinding.ActivityMainBinding
import java.io.File




class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val laucher =
        registerForActivityResult(ActivityResultContracts.GetMultipleContents()){ uri ->
            if (uri.isNotEmpty()){
//                updateImage()
            }

        }


    @RequiresExtension(extension = Build.VERSION_CODES.R, version = 2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.btnCemra.setOnClickListener {
            val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(takePicture)
        }

        binding.btnVidio.setOnClickListener {
            val vidioIntent = Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA)
            startActivity(vidioIntent)

        }
        binding.btnGalery.setOnClickListener {


            checkPermission()

        }
    }

    private fun  checkPermission(){
        val permission = if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU){
            android.Manifest.permission.READ_MEDIA_IMAGES

        }else{
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        }


        when{
            ContextCompat.checkSelfPermission(this,
                permission) == PackageManager.PERMISSION_GRANTED ->{


                    loadImage()
                }
            shouldShowRequestPermissionRationale(permission) ->{
                showInfoDialogPermission()
            }
            else ->{
                requestMediaPermission()
            }
        }
    }

    private fun requestMediaPermission() {

        val permissions = if(android.os.Build.VERSION.SDK_INT >=
            android.os.Build.VERSION_CODES.TIRAMISU){
            arrayOf(android.Manifest.permission.READ_MEDIA_IMAGES,
                android.Manifest.permission.READ_MEDIA_VIDEO)
        }else {
            arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        ActivityCompat.requestPermissions(this, permissions,
            REQUEST_CODE_FOR_MEDIA_PERMISSION)
    }

    private fun showInfoDialogPermission() {
         AlertDialog.Builder(this)
            .setTitle("Need permission for use gallery ")
            .setNegativeButton("Cancel", null)
            .setPositiveButton("Yes") {_,_ ->
                requestMediaPermission() }
            .show()


    }

    private fun loadImage() {

         laucher.launch("image/*")

        Log.d("TAG", "loadImage: ")

    }

    private fun updateImage(uri: Uri){

    }


    companion object{
        const val REQUEST_CODE_FOR_MEDIA_PERMISSION = 100
    }

}
