package example.com.perssionapply;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.json.JSONObject;

import example.com.perssionapply.net.HttpEnter;

/**
 * Created by xingyatong on 2018/2/7.
 */
public class OKHttp extends AppCompatActivity implements View.OnClickListener {

    private Button btn_get = null;
    private Button btn_post=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.okhttp);
        btn_get = (Button) findViewById(R.id.btn_get);
        btn_post=(Button)findViewById(R.id.btn_post);
        btn_get.setOnClickListener(this);
        btn_post.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:
                String requestUrl="https://www.baidu.com";
                new HttpEnter().getRequest(OKHttp.this,requestUrl);
                break;
            case R.id.btn_post:
                String postUrl="";
                JSONObject mJsonObject=null;
                new HttpEnter().postRequest(postUrl,mJsonObject);
                break;
        }
    }
}
