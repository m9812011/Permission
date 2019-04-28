package melvinlin.com.permission.permission;

public interface IPermissionResult {
    /**
     * Activity對象為空錯誤
     */
    int REQUEST_PERMISSION_ACTIVITY_NULL = 0x100;

    /**
     * 請求權限列表為空
     */
    int REQUEST_PERMISSION_GROUP_LIST_NULL = 0x101;

    /**
     * 解決回調為空
     */
    int REQUEST_PERMISSION_CALLBACK_NULL = 0x102;


}
