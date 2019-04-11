package weektest.baway.com.okhttp;

import android.net.ConnectivityManager;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class Okhttp {

    private static OkHttpClient okHttpClient;
    private static FormBody build;
    private static Request request;

    public static void doPost(String url, String user, String pwd, Callback callback){
        okHttpClient = new OkHttpClient();
        build = new FormBody.Builder().add("phone", user).add("pwd", pwd).build();
        request = new Request.Builder().url(url).post(Okhttp.build).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
