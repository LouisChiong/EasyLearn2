package my.edu.taruc.easylearn;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;

public class Learning extends AppCompatActivity {
    int F1Note[] = {R.drawable.f1c01_1, R.drawable.f1c01_2, R.drawable.f1c02_1,R.drawable.f1c03_1, R.drawable.f1c04_1,R.drawable.f1c04_2,
            R.drawable.f1c05_1, R.drawable.f1c06_1,R.drawable.f1c07_1,R.drawable.f1c08_1, R.drawable.f1c08_2, R.drawable.f1c09_1, R.drawable.f1c10_1,
            R.drawable.f1c10_2, R.drawable.f1c11_1,R.drawable.f1c11_2,R.drawable.f1c12_1, R.drawable.f1c12_2};
    int F2Note[] = {R.drawable.f2c01_1, R.drawable.f2c01_2, R.drawable.f2c01_3,R.drawable.f2c01_4, R.drawable.f2c02_1,R.drawable.f2c02_2,
            R.drawable.f2c02_3, R.drawable.f2c02_4,R.drawable.f1c07_1,R.drawable.f1c08_1, R.drawable.f1c08_2};

    int now;
    private String level;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);
        now=0;
        Intent intent = getIntent();
        PhotoView photoView = (PhotoView) findViewById(R.id.imageView);
        level = intent.getStringExtra("LEVEL");
        if(level.equals("1")){
            photoView.setImageResource(F1Note[now]);
            TextView page = (TextView) findViewById(R.id.textViewPage);
            page.setText((now+1)+"/"+F1Note.length);
        }else  if(level.equals("2")){
            TextView page = (TextView) findViewById(R.id.textViewPage);
            page.setText((now+1)+"/"+F2Note.length);
            photoView.setImageResource(F2Note[now]);
        }else  if(level.equals("3")){

        }else{

        }
    }

    public void next(View view){
        if(level.equals("1")){
            if(now== F1Note.length){
                finish();
            }else{
                now++;
                PhotoView photoView = (PhotoView) findViewById(R.id.imageView);
                photoView.setImageResource(F1Note[now]);
                TextView page = (TextView) findViewById(R.id.textViewPage);
                page.setText((now+1)+"/"+F1Note.length);
            }
        }else  if(level.equals("2")){
            if(now== F2Note.length){
                finish();
            }else{
                now++;
                PhotoView photoView = (PhotoView) findViewById(R.id.imageView);
                photoView.setImageResource(F2Note[now]);
                TextView page = (TextView) findViewById(R.id.textViewPage);
                page.setText((now+1)+"/"+F2Note.length);
            }
        }else if(level.equals("3")){

        }



    }
    public void preview(View view){
        if(level.equals("1")){
            if(now== -1){
                finish();
            }else{
                now--;
                PhotoView photoView = (PhotoView) findViewById(R.id.imageView);
                photoView.setImageResource(F1Note[now]);
                TextView page = (TextView) findViewById(R.id.textViewPage);
                page.setText((now+1)+"/"+F1Note.length);
            }
        }else  if(level.equals("2")){
            if(now== -1){
                finish();
            }else{
                now--;
                PhotoView photoView = (PhotoView) findViewById(R.id.imageView);
                photoView.setImageResource(F2Note[now]);
                TextView page = (TextView) findViewById(R.id.textViewPage);
                page.setText((now+1)+"/"+F2Note.length);
            }
        }else if(level.equals("3")){

        }



    }
}
