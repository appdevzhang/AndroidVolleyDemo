package appdevzhang.com.androidvolleydemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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
        ivResult = (ImageView) findViewById(R.id.iv_request_result);
        nivResut = (NetworkImageView) findViewById(R.id.niv_request_result);
        mQueue = Volley.newRequestQueue(this);
        findViewById(R.id.bt_string_request).setOnClickListener(this);
        findViewById(R.id.bt_json_request).setOnClickListener(this);
        findViewById(R.id.bt_image_request).setOnClickListener(this);
        findViewById(R.id.bt_image_loader).setOnClickListener(this);
        findViewById(R.id.bt_request_clear).setOnClickListener(this);
        imageRequest = new ImageRequest(imageUrl,imageResponseListener(),0,0, Bitmap.Config.RGB_565,errorListener());
        imageLoader = new ImageLoader(mQueue, new BitmapCache());
        imageListener = ImageLoader.getImageListener(ivResult,R.mipmap.ic_launcher,R.mipmap.ic_launcher);

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

    public Response.Listener<String> responseListener(){
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                tvResult.setText(s);
            }
        };
    }

    public Response.ErrorListener errorListener(){
        return new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MainActivity.this,volleyError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        };
    }

    public Response.Listener<JSONObject> jsonResponseListener(){
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject json) {
                tvResult.setText(json.toString());
            }
        };
    }

    public Response.Listener<Bitmap> imageResponseListener(){
        return new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                ivResult.setVisibility(View.VISIBLE);
                ivResult.setImageBitmap(bitmap);
            }
        };
    }

    public Response.ErrorListener imageErrorListener(){
        return new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                ivResult.setImageResource(R.mipmap.ic_launcher);
            }
        };
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_string_request:
                mQueue.add(new StringRequest(Request.Method.POST,url,responseListener(),errorListener()));
                break;
            case R.id.bt_json_request:
                mQueue.add(new JsonObjectRequest(Request.Method.GET,jsonUrl,null,jsonResponseListener(),errorListener()));
                break;
            case R.id.bt_image_request:
                mQueue.add(imageRequest);
                break;
            case R.id.bt_image_loader:
                imageLoader.get(imageUrl,imageListener);
                nivResut.setDefaultImageResId(R.mipmap.ic_launcher);
                nivResut.setErrorImageResId(R.mipmap.ic_launcher);
                nivResut.setImageUrl(imageUrl,imageLoader);
//                Intent intent = new Intent(MainActivity.this,ImageloaderActivity.class);
//                startActivity(intent);
                break;
            case R.id.bt_request_clear:
                tvResult.setText("");
                ivResult.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }
}
