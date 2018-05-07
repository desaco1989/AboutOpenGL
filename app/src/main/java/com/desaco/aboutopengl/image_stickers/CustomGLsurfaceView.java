package com.desaco.aboutopengl.image_stickers;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import com.desaco.aboutopengl.image_stickers.filter.AFilter;

import java.io.IOException;

/**
 * Created by desaco on 2018/5/7.
 */

public class CustomGLsurfaceView extends GLSurfaceView {
    //com.desaco.aboutopengl.image_stickers.CustomGLsurfaceView

    GLRenderer render;
    public CustomGLsurfaceView(Context context) {
        this(context, null);
    }

    public CustomGLsurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setEGLContextClientVersion(2);
        render = new GLRenderer(this);
        setRenderer(render);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

        try {
            render.setImage(BitmapFactory.decodeStream(getResources().getAssets().open("texture/fengj.png")));
            requestRender();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public GLRenderer getRender(){
        return render;
    }

    public void setFilter(AFilter filter){
        render.setFilter(filter);
    }

}
