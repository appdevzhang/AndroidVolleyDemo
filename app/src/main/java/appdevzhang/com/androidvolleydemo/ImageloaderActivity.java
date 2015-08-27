package appdevzhang.com.androidvolleydemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import appdevzhang.com.androidvolleydemo.net.BitmapCache;

/**
 * @ClassName:
 * @Description:TODO()
 * @author:appdevzhang
 * @email:zhangzhongkai@damaiapp.com
 * @date:15/8/26 下午4:20
 */
public class ImageloaderActivity extends Activity{
    private ImageView ivLoader;
    private NetworkImageView nivLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);
        ivLoader = (ImageView) findViewById(R.id.iv_loader_result);
        nivLoader = (NetworkImageView) findViewById(R.id.niv_loader_result);
        RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());

        ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache());

        ImageLoader.ImageListener listener = ImageLoader.getImageListener(ivLoader,R.drawable.ic_launcher, R.drawable.ic_launcher);
        imageLoader.get("http://pic.miercn.com/uploads/allimg/150824/104-150R4135319.jpg", listener);
        nivLoader.setDefaultImageResId(R.mipmap.ic_launcher);
        nivLoader.setErrorImageResId(R.mipmap.ic_launcher);
        nivLoader.setImageUrl("http://pic.miercn.com/uploads/allimg/150824/104-150R4135319.jpg",imageLoader);
    }
}
