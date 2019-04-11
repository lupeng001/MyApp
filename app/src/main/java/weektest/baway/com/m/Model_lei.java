package weektest.baway.com.m;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import weektest.baway.com.okhttp.Okhttp;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class Model_lei implements Model_jiekou {


    @Override
    public void getLogin(String url, String name, String pwd, final LoginCallBack loginCallBack) {
        Okhttp.doPost(url, name, pwd, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                loginCallBack.onSuccess(response.body().string());
            }
        });
    }
}
