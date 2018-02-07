package example.com.perssionapply;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tbruyelle.rxpermissions.RxPermissions;

import example.com.perssionapply.utils.Tools;
import rx.Observer;

/**
 * Created by xingyatong on 2018/2/5.
 */
public class RxPermission extends AppCompatActivity implements View.OnClickListener {

    private Button checkPermission = null;
    private TextView stateTxt = null;
    private Button singelPermission = null;
    private Button multiPermission = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxpermission);
        checkPermission = (Button) findViewById(R.id.check_btn_rx);
        singelPermission = (Button) findViewById(R.id.single_permission_rx);
        multiPermission = (Button) findViewById(R.id.multi_permission_rx);
        stateTxt = (TextView) findViewById(R.id.state_txt_rx);
        checkPermission.setOnClickListener(this);
        singelPermission.setOnClickListener(this);
        multiPermission.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.check_btn_rx:
                String rxPermission = Tools.checkPermission(RxPermission.this, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA);
                stateTxt.setText(rxPermission);
                break;
            case R.id.single_permission_rx:
                requestRxPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                break;
            case R.id.multi_permission_rx:
                requestRxPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA);
                break;
        }
    }

    private void requestRxPermission(String... permissions) {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(permissions).subscribe(new Observer<Boolean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Boolean result) {
                if (result) {
                    Toast.makeText(RxPermission.this, "同意权限", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(RxPermission.this, "拒绝权限", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
