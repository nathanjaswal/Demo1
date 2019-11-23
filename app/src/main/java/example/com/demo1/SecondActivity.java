package example.com.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView  txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle mBundel = getIntent().getExtras();
        if (mBundel != null){
            String name = mBundel.getString("name");
            //Log.d("Name:", name);
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        //
    }
}
