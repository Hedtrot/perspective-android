package com.hedtrot.perspective;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Main extends AppCompatActivity {
    //implements View.OnClickListener
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setIcon(R.drawable.cabecao);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    public void DL(View v) {//old launcher for the apps
        String packageName = v.getTag().toString(); //get The tag in the button, which is the packagename hidden
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(packageName);
        startActivity(launchIntent);
    }

    public void Open(View v) throws InterruptedException {//open the app when button is clicked
        String packageName = v.getTag().toString(); //get The tag in the button, which is the packagename hidden
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(packageName);
        //startActivity(launchIntent);
        if (launchIntent != null) {
            // We found the activity now start the activity
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(launchIntent);
        } else {
            // Bring user to the market
            Snackbar.make(v, " App não instalado", Snackbar.LENGTH_LONG)
                    .show();
            launchIntent = new Intent(Intent.ACTION_VIEW);
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            launchIntent.setData(Uri.parse("market://details?id=" + packageName));
            startActivity(launchIntent);
        }
    }//Thank you for read my code

}
