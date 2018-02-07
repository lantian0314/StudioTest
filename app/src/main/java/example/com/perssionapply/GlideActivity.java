package example.com.perssionapply;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by xingyatong on 2018/2/7.
 */
public class GlideActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView netImageView = null;
    private Button btnNet = null;
    private Button btnGif = null;
    private Button btnAnim = null;
    private Button btnSize = null;
    private Button btnTrans = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glide);
        netImageView = (ImageView) findViewById(R.id.img_netnormal);
        btnNet = (Button) findViewById(R.id.btn_normal_img);
        btnGif = (Button) findViewById(R.id.btn_gif_img);
        btnAnim = (Button) findViewById(R.id.btn_anima);
        btnSize = (Button) findViewById(R.id.btn_size_img);
        btnTrans = (Button) findViewById(R.id.btn_trans);
        btnNet.setOnClickListener(this);
        btnGif.setOnClickListener(this);
        btnAnim.setOnClickListener(this);
        btnSize.setOnClickListener(this);
        btnTrans.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_normal_img:
                Toast.makeText(GlideActivity.this, "加载网络图片", Toast.LENGTH_SHORT).show();
                String url = "http://i4.myapkcdn.in/promotePic/20170726/s_5978640b3f4f3.jpg";
                Glide.with(GlideActivity.this).load(url).placeholder(R.drawable.ic_launcher).error(R.drawable.ic_launcher).thumbnail(0.1f).into(netImageView);
                break;
            case R.id.btn_gif_img:
                Toast.makeText(GlideActivity.this, "加载GIF图片", Toast.LENGTH_SHORT).show();
                String gifUrl = "http://i4.myapkcdn.in/promotePic/20170726/s_5978640b3f4f3.jpg";
                Glide.with(GlideActivity.this).load(gifUrl).asBitmap().into(netImageView);
                //Glide.with(GlideActivity.this).load(gifUrl).asGif().into(netImageView);
                break;
            case R.id.btn_anima:
                Toast.makeText(GlideActivity.this, "加载动画图片", Toast.LENGTH_SHORT).show();
                String animUrl = "http://i4.myapkcdn.in/promotePic/20170726/s_5978640b3f4f3.jpg";
                Glide.with(GlideActivity.this).load(animUrl).crossFade().into(netImageView);
                //Glide.with(GlideActivity.this).load(animUrl).animate(R.anim.fade).into(netImageView);
                //Glide.with(GlideActivity.this).load(animUrl).dontAnimate().into(netImageView);
                break;
            case R.id.btn_size_img:
                Toast.makeText(GlideActivity.this, "加载图片尺寸及缓存", Toast.LENGTH_SHORT).show();
                String sizeUrl = "http://i4.myapkcdn.in/promotePic/20170726/s_5978640b3f4f3.jpg";
                //Glide.with(GlideActivity.this).load(sizeUrl).override(500,800).into(netImageView);
                //Glide.with(GlideActivity.this).load(sizeUrl).centerCrop().into(netImageView);
                //Glide.with(GlideActivity.this).load(sizeUrl).fitCenter().diskCacheStrategy(DiskCacheStrategy.ALL).into(netImageView);
                break;
            case R.id.btn_trans:
                Toast.makeText(GlideActivity.this, "图片模糊", Toast.LENGTH_SHORT).show();
                String transUrl = "http://i4.myapkcdn.in/promotePic/20170726/s_5978640b3f4f3.jpg";
                int radisus = 20;//1-25 ，值越大图片越模糊
                Glide.with(GlideActivity.this).load(transUrl).bitmapTransform(new BlurTransformation(GlideActivity.this, radisus)).into(netImageView);
                break;
        }
    }
}
