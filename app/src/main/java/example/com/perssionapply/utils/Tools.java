package example.com.perssionapply.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.PermissionChecker;
import android.text.TextUtils;


/**
 * Created by xingyatong on 2018/2/7.
 */
public class Tools {

    public  static  String checkPermission(Context context,String ... permissions){
        StringBuilder builder=new StringBuilder();
        try {
            for (String permission:permissions
                 ) {
                builder.append(permission);
                builder.append(" is apply state : ");
                builder.append(checkPermissionState(context,permission));
                builder.append("\n\n");
            }
            return  builder.toString();
        }catch (Exception e){

        }finally {
            if (builder!=null){
                builder.delete(0,builder.length());
            }
        }
        return "";
    }

    private  static  boolean checkPermissionState(Context context,String permission){
        if (context==null|| TextUtils.isEmpty(permission)) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
                int tragetVersion = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA).targetSdkVersion;
                if (tragetVersion >= Build.VERSION_CODES.M) {
                    return context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
                } else {
                    return PermissionChecker.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
                }
            }
        }catch (Exception e){
        }
        return  false;
    }
}
