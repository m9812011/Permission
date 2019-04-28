package melvinlin.com.permission.permission;

import android.app.Activity;

/**
 * 權限申請回調
 */
public interface IPermission {
    /**
     * Request permission.
     *
     * @param activity    activity實體對象
     * @param permissions 權限列表
     * @param requestCode 請求碼
     */
    void requestPermission(Activity activity, String[] permissions, int requestCode);

    /**
     * On request permission result.
     *
     * @param requestCode  請求碼
     * @param permissions  權限列表
     * @param grantResults 權限申請結果數組
     */
    void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults);
}


