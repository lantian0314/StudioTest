package example.com.perssionapply;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button rxPermissionBtn = null;
    private Button btnOKHttp = null;
    private Button btnGlide = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        rxPermissionBtn = (Button) findViewById(R.id.btn_rxPermission);
        btnOKHttp = (Button) findViewById(R.id.btn_okhttp);
        btnGlide = (Button) findViewById(R.id.btn_glide);
        rxPermissionBtn.setOnClickListener(this);
        btnOKHttp.setOnClickListener(this);
        btnGlide.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_rxPermission:
                openActivity(RxPermission.class);
                break;
            case R.id.btn_okhttp:
                openActivity(OKHttp.class);
                break;
            case R.id.btn_glide:
                openActivity(GlideActivity.class);
                break;
        }
    }

    private void openActivity(Class<?> openActivityClass) {
        Intent RxIntent = new Intent();
        RxIntent.setClass(getApplicationContext(), openActivityClass);
        startActivity(RxIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
