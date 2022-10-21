package com.avasoft.gabriel.grifs

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_adicionar.*
import java.io.File
import java.util.*


class AdicionarActivity : AppCompatActivity() {

    private var mDateSetListener: OnDateSetListener? = null

    private val REQUEST_IMAGE_CAPTURE = 1889

    var CaminhoFoto: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar)

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.GrifsCategorias,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            SpinnerCategoria.adapter = adapter
        }

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.GrifsEstados,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            SpinnerEstado.adapter = adapter
        }

        ButtonData.setOnClickListener(View.OnClickListener {
            val cal: Calendar = Calendar.getInstance()
            val year: Int = cal.get(Calendar.YEAR)
            val month: Int = cal.get(Calendar.MONTH)
            val day: Int = cal.get(Calendar.DAY_OF_MONTH)
            val dialog = DatePickerDialog(
                this,
                android.R.style.Theme_Light_Panel,
                mDateSetListener,
                year, month, day
            )
            dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        })



        mDateSetListener =
            OnDateSetListener { datePicker, year, month, day ->
                var month = month
                month = month + 1
                val date = "$day / $month / $year"
                ButtonData.text = date
            }

        btn_back.setOnClickListener{ this.finish() }

        btn_add_new_photo.setOnClickListener{ dispatchTakePictureIntent() }

    }

    private fun dispatchTakePictureIntent() {

        if(Build.VERSION.SDK_INT>=23){
            if(ActivityCompat.checkSelfPermission(this,
                    android.Manifest.permission.CAMERA)!=
                PackageManager.PERMISSION_GRANTED){

                requestPermissions(arrayOf( android.Manifest.permission.CAMERA),REQUEST_IMAGE_CAPTURE)
                return
            }
            if(ActivityCompat.checkSelfPermission(this,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE)!=
                PackageManager.PERMISSION_GRANTED){

                requestPermissions(arrayOf( android.Manifest.permission.WRITE_EXTERNAL_STORAGE),REQUEST_IMAGE_CAPTURE)
                return
            }
            if(ActivityCompat.checkSelfPermission(this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE)!=
                PackageManager.PERMISSION_GRANTED){

                requestPermissions(arrayOf( android.Manifest.permission.READ_EXTERNAL_STORAGE),REQUEST_IMAGE_CAPTURE)
                return
            }
        }
        /*
        val intent = Intent()
       intent.type = "image/"
        intent.action = Intent.ACTION_GET_CONTENT
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)*/
        var intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        CaminhoFoto = Environment.getExternalStorageDirectory().toString()+
                "/"+System.currentTimeMillis()+".png"
        var ArquivoFoto = File(CaminhoFoto)
        var LocalFoto = Uri.fromFile(ArquivoFoto)
        intent.putExtra(MediaStore.EXTRA_OUTPUT,LocalFoto)
        startActivityForResult(intent,REQUEST_IMAGE_CAPTURE)


    }
/*
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data != null) {

            val imageBitmap = data.extras.get("data") as Bitmap
            ImageViewGrifImage.setImageBitmap(imageBitmap)
        }
    }
*/
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //super.onActivityResult(requestCode, resultCode, data)
/*
        if(requestCode==REQUEST_IMAGE_CAPTURE  && data!=null && resultCode == RESULT_OK){

            val selectedImage=data.data
            val filePathColum= arrayOf(MediaStore.Images.Media.DATA)
            val cursor= contentResolver.query(selectedImage,filePathColum,null,null,null)
            cursor.moveToFirst()
            val coulomIndex=cursor.getColumnIndex(filePathColum[0])
            val picturePath=cursor.getString(coulomIndex)
            cursor.close()
            ImageViewGrifImage.setImageBitmap(BitmapFactory.decodeFile(picturePath))
        }
*/

    if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
        var image = BitmapFactory.decodeFile(CaminhoFoto)
        ImageViewGrifImage.setImageBitmap(image)
    }
    }
}
