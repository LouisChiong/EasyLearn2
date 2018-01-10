package my.edu.taruc.easylearn;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!isConnected()) {
            Toast.makeText(getApplicationContext(), "No network", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(), "Connected network", Toast.LENGTH_LONG).show();
        }

    }

    private boolean isConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();

    }
    public void OnclickLearning(View view){
        Intent intent = new Intent(this,Levels.class);
        intent.putExtra("SELECTION","learing");
        startActivity(intent);
    }
    public void OnclickQuiz(View view) {
        Intent intent = new Intent(this, Levels.class);
        String selection = "quiz";
        intent.putExtra("SELECTION", selection);
        startActivity(intent);

    }
}
