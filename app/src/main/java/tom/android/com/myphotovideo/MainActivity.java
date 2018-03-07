package tom.android.com.myphotovideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import tom.android.com.myphotovideo.video.ContentManager;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentManager.initialize(this);
        ContentManager cm = ContentManager.getInstance();
        if (!cm.isContentCreated(this)) {
            ContentManager.getInstance().createAll(this);
        }
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentManager.getInstance().createAll(MainActivity.this);
            }
        });
    }
}
