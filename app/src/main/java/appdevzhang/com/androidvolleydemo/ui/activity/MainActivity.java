package appdevzhang.com.androidvolleydemo.ui.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import appdevzhang.com.androidvolleydemo.R;

public class MainActivity extends BaseActivity {
    private RequestQueue mQueue;
    private TextView tvResult;
    private ImageView ivResult;
    private NetworkImageView nivResut;
    public static String url = "http://www.baidu.com";
    public static String jsonUrl = "http://m.weather.com.cn/atad/101010100.html";
    public static String imageUrl = "http://pic.miercn.com/uploads/allimg/150824/104-150R4135319.jpg";
    ImageRequest imageRequest;
    ImageLoader imageLoader;
    ImageLoader.ImageListener imageListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = (TextView) findViewById(R.id.tv_request_result);
        mQueue = Volley.newRequestQueue(this);
        findViewById(R.id.bt_string_request).setOnClickListener(this);
        findViewById(R.id.bt_json_request).setOnClickListener(this);
        findViewById(R.id.bt_image_request).setOnClickListener(this);
        findViewById(R.id.bt_image_loader).setOnClickListener(this);
        findViewById(R.id.bt_network_imageview).setOnClickListener(this);
        findViewById(R.id.bt_request_clear).setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_string_request:
                NextPage(StringRequestActivity.class,false);
                break;
            case R.id.bt_json_request:
                NextPage(JsonRequestActivity.class,false);
                break;
            case R.id.bt_image_request:
                NextPage(ImageRequestActivity.class,false);
                break;
            case R.id.bt_image_loader:
                NextPage(ImageLoaderActivity.class,false);
                break;
            case R.id.bt_network_imageview:
                NextPage(NetwordImageViewActivity.class,false);
                break;
            case R.id.bt_request_clear:
                break;
            default:
                break;
        }
    }
}
