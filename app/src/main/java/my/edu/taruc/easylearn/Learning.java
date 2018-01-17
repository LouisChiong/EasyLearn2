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

public class Learning extends AppCompatActivity {
    int F1Note[] = {R.drawable.f1c01_1, R.drawable.f1c01_2, R.drawable.f1c02_1,R.drawable.f1c03_1, R.drawable.f1c04_1,R.drawable.f1c04_2,
            R.drawable.f1c05_1, R.drawable.f1c06_1,R.drawable.f1c07_1,R.drawable.f1c08_1, R.drawable.f1c08_2, R.drawable.f1c09_1, R.drawable.f1c10_1,
            R.drawable.f1c10_2, R.drawable.f1c11_1,R.drawable.f1c11_2,R.drawable.f1c12_1, R.drawable.f1c12_2};
    int F2Note[] = {R.drawable.f2c01_1, R.drawable.f2c01_2, R.drawable.f2c01_3,R.drawable.f2c01_4, R.drawable.f2c02_1,R.drawable.f2c02_2,
            R.drawable.f2c02_3, R.drawable.f2c02_4,R.drawable.f1c07_1,R.drawable.f1c08_1, R.drawable.f1c08_2};
    private ImageView ImageViewNote;
    int windowwidth;
    int windowheight;
    int now;
    private String level;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);
        now=0;
        Intent intent = getIntent();

        level = intent.getStringExtra("LEVEL");
        if(level.equals("1")){
            ImageViewNote = (ImageView) findViewById(R.id.imageView1);
            ImageViewNote.setImageResource(F1Note[now]);
        }else  if(level.equals("2")){
            ImageViewNote = (ImageView) findViewById(R.id.imageView1);
            ImageViewNote.setImageResource(F2Note[now]);
        }else  if(level.equals("3")){

        }else{

        }
        windowwidth = getWindowManager().getDefaultDisplay().getWidth();
        windowheight = getWindowManager().getDefaultDisplay().getHeight();
        final RelativeLayout img = (RelativeLayout) findViewById(R.id.layout1);

        img.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) img
                        .getLayoutParams();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int x_cord = (int) event.getRawX();
                        int y_cord = (int) event.getRawY();

                        if (x_cord > windowwidth) {
                            x_cord = windowwidth;
                        }
                        if (y_cord > windowheight) {
                            y_cord = windowheight;
                        }

                        layoutParams.leftMargin = x_cord - 25;
                        layoutParams.topMargin = y_cord - 75;

                        img.setLayoutParams(layoutParams);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });


    }
    public void next(View view){
        if(level.equals("1")){
            if(now== F1Note.length){
                finish();
            }else{
                now++;
                ImageViewNote = (ImageView) findViewById(R.id.imageView1);
                ImageViewNote.setImageResource(F1Note[now]);
            }
        }else  if(level.equals("2")){
            if(now== F2Note.length){
                finish();
            }else{
                now++;
                ImageViewNote = (ImageView) findViewById(R.id.imageView1);
                ImageViewNote.setImageResource(F2Note[now]);
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
                ImageViewNote = (ImageView) findViewById(R.id.imageView1);
                ImageViewNote.setImageResource(F1Note[now]);
            }
        }else  if(level.equals("2")){
            if(now== -1){
                finish();
            }else{
                now--;
                ImageViewNote = (ImageView) findViewById(R.id.imageView1);
                ImageViewNote.setImageResource(F2Note[now]);
            }
        }else if(level.equals("3")){

        }



    }
}
