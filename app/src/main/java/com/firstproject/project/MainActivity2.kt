package com.firstproject.project

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView


class MainActivity2 : AppCompatActivity() {

    private lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        image = findViewById(R.id.pic)
        image.setOnClickListener() {
            openStorage()
        }
    }

    private fun openStorage() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "image/*"  // You can change this to other MIME types as needed

        startActivityForResult(intent, OPEN_STORAGE_REQUEST_CODE)
    }

    companion object {
        const val OPEN_STORAGE_REQUEST_CODE = 123
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == OPEN_STORAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            data?.data?.let { selectedUri ->
                // Handle the selected file URI as needed
                // For example, you might want to display the selected image
                // in the ImageView or perform other operations.
                val circleImageView: CircleImageView? = findViewById(R.id.pic)
                Glide.with(this)
                    .load(selectedUri)
                    .circleCrop()
                    .into(image)


            }
        }
    }
}