package appdevzhang.com.androidvolleydemo;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * @ClassName:
 * @Description:TODO()
 * @author:appdevzhang
 * @email:zhangzhongkai@damaiapp.com
 * @date:15/8/26 下午2:57
 */
public class BitmapCache implements ImageLoader.ImageCache{

    LruCache<String,Bitmap> lruCache ;

    public BitmapCache() {
        int maxSize = 10 * 1024 * 1024;
        lruCache = new LruCache<String,Bitmap>(maxSize){
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getRowBytes();
            }
        };
    }

    @Override
    public Bitmap getBitmap(String url) {
        return lruCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        lruCache.put(url,bitmap);
    }
}
