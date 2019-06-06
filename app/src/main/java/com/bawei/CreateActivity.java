package com.bawei;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CodeUtils;

public class CreateActivity extends AppCompatActivity {

    private EditText editText;
    private Button btn_log,btn_no;
    private ImageView imageView;
    private Bitmap mimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        //
        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageView);
        btn_log = findViewById(R.id.btn_log);
        btn_no = findViewById(R.id.btn_no);
        //生成带logo的二维码图片
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textContent = editText.getText().toString();
                if (TextUtils.isEmpty(textContent)){
                    Toast.makeText(CreateActivity.this,"请输入内容!",Toast.LENGTH_LONG).show();
                    return;
                }
                editText.setText("");
                mimage = CodeUtils.createImage(textContent, 400, 400, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                imageView.setImageBitmap(mimage);
            }
        });
        //生成不带logo的二维码图片
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textContent = editText.getText().toString();
                if (TextUtils.isEmpty(textContent)){
                    Toast.makeText(CreateActivity.this,"请输入内容!",Toast.LENGTH_LONG).show();
                    return;
                }
                editText.setText("");
                Bitmap imagem = CodeUtils.createImage(textContent, 400, 400, null);
                imageView.setImageBitmap(imagem);
            }
        });
    }
}
