package weektest.baway.com.m;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public interface Model_jiekou {
    void getLogin(String url,String name,String pwd,LoginCallBack loginCallBack);
    interface LoginCallBack{
        void onSuccess(String url);
    }
}
