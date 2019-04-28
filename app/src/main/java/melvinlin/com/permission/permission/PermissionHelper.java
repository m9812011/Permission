package melvinlin.com.permission.permission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;


/**
 * 權限申請幫助類
 */
public class PermissionHelper {

    private static int CUSTOM_NUMBER = 2;

    /**
     * 檢查指定權限
     * ContextCompat.checkSelfPermission(content, permission) => (未授權：-1, 已授權：0)
     *
     * @param content    上下文
     * @param permission 權限指示 see{@link android.Manifest.permission}
     * @return boolean 是否擁有此權限
     */
    public static boolean checkPermission(Context content, String permission) {
        return ContextCompat.checkSelfPermission(content, permission) != PackageManager.PERMISSION_GRANTED;
    }

    /**
     * 檢查權限版本兼容
     *
     * @return the boolean
     */
    public static boolean checkPermissionVersion() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }


    /**
     * 使用者第二次點擊功能呼叫權限視窗
     *
     * @param activity   activity
     * @param permission 權限指示 see{@link android.Manifest.permission}
     * @param message    權限說明
     */
    public static void secondRequestPermissionDialog(final Activity activity, String permission, String message) {
        //如果使用者第二次點擊功能呼叫權限視窗，就會跳出shouldShowRequestPermissionRationale
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
            //創建Dialog解釋視窗
            new AlertDialog.Builder(activity)
                    .setMessage(message)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            requestPermissionDialog(activity);
                        }
                    })
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            activity.finish();
                        }
                    })
                    .show();
        } else {
            requestPermissionDialog(activity);
        }

    }

    /**
     * 開啟指定權限畫面
     *
     * @param activity
     */
    private static void requestPermissionDialog(Activity activity) {
        ActivityCompat.requestPermissions(activity,
                new String[]{Manifest.permission.CAMERA},
                CUSTOM_NUMBER);
    }
}
