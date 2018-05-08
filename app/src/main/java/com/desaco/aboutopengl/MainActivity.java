package com.desaco.aboutopengl;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.desaco.aboutopengl.image_stickers.Texture2DStickerActivity;
import com.desaco.aboutopengl.image_stickers.Texture3DStickerActivity;
import com.desaco.aboutopengl.vr.VRPanoramaActivity;
import com.desaco.aboutopengl.vr.VRdoubleEyesActivity;

/**
 * https://github.com/doggycoder/AndroidOpenGLDemo
 * https://github.com/DrownCoder/VRShow
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        initView();
        initData();
    }

    private void initView() {
        //opengl_2d
        Button openGL2D = (Button) findViewById(R.id.opengl_2d);
        openGL2D.setOnClickListener(this);
        //opengl_3d
        Button openGL3D = (Button) findViewById(R.id.opengl_3d);
        openGL3D.setOnClickListener(this);
//        vr_one_eye vr_two_eyes
        Button vrOneEye = (Button) findViewById(R.id.vr_one_eye);
        vrOneEye.setOnClickListener(this);

        Button vrTwoEyes = (Button) findViewById(R.id.vr_two_eyes);
        vrTwoEyes.setOnClickListener(this);
    }

    private void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.opengl_2d:
                jumpToGoalActivity(Texture2DStickerActivity.class);
                break;
            case R.id.opengl_3d:
                jumpToGoalActivity(Texture3DStickerActivity.class);
                break;
            case R.id.vr_one_eye:
                jumpToGoalActivity(VRPanoramaActivity.class);
                break;
            case R.id.vr_two_eyes:
                jumpToGoalActivity(VRdoubleEyesActivity.class);
                break;
            default:
                break;
        }
    }
    private void jumpToGoalActivity(Class<?> clazz){
        Intent intent = new Intent();
        intent.setClass(mContext,clazz);
        startActivity(intent);
    }
}
