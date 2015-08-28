package appdevzhang.com.androidvolleydemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Response;

import appdevzhang.com.androidvolleydemo.R;
import appdevzhang.com.androidvolleydemo.bean.Wheather;

/**
 * @ClassName: GsonRequestActivity
 * @Description:
 * @author: appdevzhang
 * @email: 1160030655@qq.com
 * @date: 15/8/28 上午10:48
 */
public class GsonRequestActivity extends BaseActivity {
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson_request);
        tvResult = (TextView) findViewById(R.id.tv_request_result);
        findViewById(R.id.bt_gson_request).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.bt_gson_request:

                break;
            default:
                break;
        }
    }

    protected Response.Listener<Wheather> listener(){
        return new Response.Listener<Wheather>() {
            @Override
            public void onResponse(Wheather wheather) {
                tvResult.setText(wheather.toString());
            }
        };
    }

}
