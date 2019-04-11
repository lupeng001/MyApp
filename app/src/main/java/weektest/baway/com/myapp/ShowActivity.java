package weektest.baway.com.myapp;

import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import weektest.baway.com.frag.DingdanFrag;
import weektest.baway.com.frag.GouwuFrag;
import weektest.baway.com.frag.MyFrag;
import weektest.baway.com.frag.QuanziFrag;
import weektest.baway.com.frag.ShouyeFrag;

public class ShowActivity extends AppCompatActivity {
private ViewPager viewPager;
private RadioGroup radioGroup;
private List<Fragment> list = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        viewPager = findViewById(R.id.shouye_viewpager);
        radioGroup = findViewById(R.id.shouye_radgrop);
        list.add(new ShouyeFrag());
        list.add(new QuanziFrag());
        list.add(new GouwuFrag());
        list.add(new DingdanFrag());
        list.add(new MyFrag());
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               switch (checkedId){
                   case R.id.shouye_radbutton1:
                       viewPager.setCurrentItem(0);
                       break;
                   case R.id.shouye_radbutton2:
                       viewPager.setCurrentItem(1);
                       break;
                   case R.id.shouye_radbutton3:
                       viewPager.setCurrentItem(2);
                       break;
                   case R.id.shouye_radbutton4:
                       viewPager.setCurrentItem(3);
                       break;
                   case R.id.shouye_radbutton5:
                       viewPager.setCurrentItem(4);
                       break;
               }
            }
        });
    viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        
        public void onPageSelected(int i) {
            radioGroup.check(radioGroup.getChildAt(i).getId());
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    });
    }
}
