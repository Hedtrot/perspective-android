package com.hedtrot.perspective;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Autorama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autorama);
    }
    public void New(Context context, String packageName) {
        //Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        //if (intent == null) {
            // Bring user to the market or let them choose an app?
            //intent = new Intent(Intent.ACTION_VIEW);
            //intent.setData(Uri.parse("market://details?id=" + packageName));
        //}
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //context.startActivity(intent);
    }
    public void Test(){
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
        startActivity(launchIntent);
    }
}
