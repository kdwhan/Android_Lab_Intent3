package daewhan.example.com.labintent3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.web).setOnClickListener(mClickListener);
        findViewById(R.id.dial).setOnClickListener(mClickListener);
        findViewById(R.id.picture).setOnClickListener(mClickListener);
    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch(v.getId()) {
                case R.id.web :
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
                    startActivity(intent);
                    break;
                case R.id.dial :
                    intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-9627-6760"));
                    startActivity(intent);
                    break;
                case R.id.picture:
                    intent = new Intent(Intent.ACTION_VIEW);
                    Uri uri = Uri.fromFile(new File("/sdcard/test.jpg"));
                    intent.setDataAndType(uri, "image/jpeg");
                    startActivity(intent);
                    break;
            }
        }
    };
}
