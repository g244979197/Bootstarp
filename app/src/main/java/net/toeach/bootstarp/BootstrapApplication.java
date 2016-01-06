package net.toeach.bootstarp;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import net.toeach.bootstarp.model.Terminal;

import org.xutils.common.util.LogUtil;
import org.xutils.x;

/**
 * Created by Administrator on 2016/1/5.
 */
public class BootstrapApplication extends Application {
    private static BootstrapApplication instance;// Application实例引用
    private Terminal mTerminal;// 终端信息

    public static BootstrapApplication getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Application has not been created");
        }
        return instance;
    }

    public Terminal getTerminal() {
        return mTerminal;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志
        LogUtil.d("Init starting...");

        getTerminalInfo();
    }

    /**
     * 当系统内存过低时触发
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        LogUtil.d("System is running low on memory");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        mTerminal = null;
    }

    private void getTerminalInfo() {
        mTerminal = new Terminal();
        mTerminal.setApiVersion("1.0");
        mTerminal.setModel(Build.MODEL);
        mTerminal.setOs("Android");
        mTerminal.setOsVersion(Build.VERSION.RELEASE);

        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        mTerminal.setImei(tm.getDeviceId());
        mTerminal.setImsi(tm.getSubscriberId());

        try {
            PackageManager manager = getPackageManager();
            PackageInfo info = manager.getPackageInfo(getPackageName(), 0);
            mTerminal.setAppVersion(info.versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        mTerminal.setScreenWidth(dm.widthPixels);
        mTerminal.setScreenHeight(dm.heightPixels);
        LogUtil.d(mTerminal.toString());
    }
}
