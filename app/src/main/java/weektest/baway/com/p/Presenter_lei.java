package weektest.baway.com.p;

import weektest.baway.com.api.Api;
import weektest.baway.com.m.Model_jiekou;
import weektest.baway.com.m.Model_lei;
import weektest.baway.com.myapp.MainActivity;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class Presenter_lei implements Presenter_jiekou {
    MainActivity mainActivity;
    private final Model_lei model_lei;

    public Presenter_lei(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        model_lei = new Model_lei();
    }

    @Override
    public void getLogin(String name, String pwd) {
        model_lei.getLogin(Api.Loginurl,name, pwd, new Model_jiekou.LoginCallBack() {
            @Override
            public void onSuccess(String url) {
                mainActivity.getLogin(url);
            }
        });
    }
}
