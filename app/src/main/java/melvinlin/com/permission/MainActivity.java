package melvinlin.com.permission;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import melvinlin.com.permission.permission.PermissionHelper;

public class MainActivity extends AppCompatActivity {

    private int CUSTOM_NUMBER = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        //檢查是否取得權限
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);

        //沒有權限時
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            this.secondRequestPermission();
        } else {
            Toast.makeText(this, "已經拿到權限囉!", Toast.LENGTH_SHORT).show();
        }

    }

    public void secondRequestPermission() {
        //如果使用者第二次點擊功能呼叫權限視窗，就會跳出shouldShowRequestPermissionRationale
        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                Manifest.permission.CAMERA)) {
            //創建Dialog解釋視窗
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage("單純使用在拍照功能，如果您不給我相機的權限，您將無法使用此功能")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[]{Manifest.permission.CAMERA},
                                    CUSTOM_NUMBER);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();
        } else {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.CAMERA},
                    CUSTOM_NUMBER);
        }
    }

}
