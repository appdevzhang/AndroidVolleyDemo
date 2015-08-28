package appdevzhang.com.androidvolleydemo.ui.activity;

import android.os.Bundle;
import android.view.View;

import appdevzhang.com.androidvolleydemo.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_string_request).setOnClickListener(this);
        findViewById(R.id.bt_json_request).setOnClickListener(this);
        findViewById(R.id.bt_image_request).setOnClickListener(this);
        findViewById(R.id.bt_image_loader).setOnClickListener(this);
        findViewById(R.id.bt_network_imageview).setOnClickListener(this);
        findViewById(R.id.bt_xml_request).setOnClickListener(this);
        findViewById(R.id.bt_gson_request).setOnClickListener(this);
        findViewById(R.id.bt_request_clear).setOnClickListener(this);

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
            case R.id.bt_xml_request:
                NextPage(XMLRequestActivity.class,false);
                break;
            case R.id.bt_gson_request:
                NextPage(GsonRequestActivity.class,false);
                break;
            case R.id.bt_request_clear:
                break;
            default:
                break;
        }
    }
}
