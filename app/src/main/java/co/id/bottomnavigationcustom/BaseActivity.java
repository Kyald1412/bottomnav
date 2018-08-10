package co.id.bottomnavigationcustom;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


/**
 * Created by Dhiky Aldwiansyah on 17/05/18.
 */
public class BaseActivity extends AppCompatActivity {

    boolean isCalled = false;
    private AlertDialog.Builder dialog;
    private AlertDialog ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        AppsFlyer();

    }


}
