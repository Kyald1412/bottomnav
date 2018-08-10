package co.id.bottomnavigationcustom;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by Dhiky Aldwiansyah on 19/02/18.
 */

public class MainStudentPresenter implements MainStudentContract.MainPresenter {

    private MainStudentContract.MainView view;
//    RestAPI restAPI;
    private String TAG = "MainStudentPresenter";
    private Activity context;
    private ViewPagerAdapter adapter;


    private CustomVPNoPaging customVPNoPaging;

//    @Inject
    public MainStudentPresenter(MainStudentContract.MainView view, Activity context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void setupViewPager(CustomVPNoPaging viewPager, FragmentManager fragmentManager) {
        customVPNoPaging = viewPager;

        adapter = new ViewPagerAdapter(fragmentManager);
        adapter.addFragment(new BlankFragment(), "FragMain");
        adapter.addFragment(new BlankFragment(), "FragStudentChatRoom");
        adapter.addFragment(new BlankFragment(), "FragLesson");
        adapter.addFragment(new BlankFragment(), "FragSettings");
        viewPager.setPagingEnabled(false);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount());

    }

    private static class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super(manager);

        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public void changeTabPosition(String position) {

//        if(position.equals(GlobalConfig.TAB_HOME)){
//            customVPNoPaging.setCurrentItem(0);
//        }
//        if(position.equals(GlobalConfig.TAB_CHAT)){
//            customVPNoPaging.setCurrentItem(1);
//        }
//        if(position.equals(GlobalConfig.TAB_LESSON)){
//            customVPNoPaging.setCurrentItem(2);
//        }
//        if(position.equals(GlobalConfig.TAB_PROFILE)){
//            customVPNoPaging.setCurrentItem(3);
//        }
    }

}