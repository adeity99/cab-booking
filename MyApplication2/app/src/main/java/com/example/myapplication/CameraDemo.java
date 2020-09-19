package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraDemo extends AppCompatActivity implements View.OnClickListener {
   Button click;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_demo);
        iv=findViewById(R.id.imageView2);
        click=findViewById(R.id.button7);
        click.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);//ACTION_IMAGE_CAPTURE_SECURE will capture and give save image option
      startActivityForResult(i,12345);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==12345 && resultCode==RESULT_OK)
        {
         Bundle b=data.getExtras();
         Bitmap bmp=b.getParcelable("data");
         iv.setImageBitmap(bmp);
        }
    }
}
//in this program it will capture image and automatically save it in gallery