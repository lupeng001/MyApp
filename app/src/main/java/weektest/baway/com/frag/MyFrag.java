package weektest.baway.com.frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import weektest.baway.com.myapp.R;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class MyFrag extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_layout, container, false);
        return view;
    }
}
