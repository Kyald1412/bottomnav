package co.id.bottomnavigationcustom;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainStudentAct extends BaseActivity implements MainStudentContract.MainView {

    private String TAG = MainStudentAct.class.getSimpleName();

//    @Inject
    MainStudentPresenter mainStudentPresenter;

    @BindView(R.id.ll_find_teachers)
    LinearLayout llFindTeachers;
    @BindView(R.id.ll_point)
    LinearLayout llPoint;
    @BindView(R.id.tvPoint)
    TextView tvPoint;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewPager)
    CustomVPNoPaging viewPager;
    @BindView(R.id.bar_btm_home)
    View barBtmHome;
    @BindView(R.id.img_btm_home)
    ImageView imgBtmHome;
    @BindView(R.id.btm_home)
    RelativeLayout btmHome;
    @BindView(R.id.bar_btm_chat)
    View barBtmChat;
    @BindView(R.id.img_btm_chat)
    ImageView imgBtmChat;
    @BindView(R.id.btm_chat)
    RelativeLayout btmChat;
    @BindView(R.id.bar_btm_lesson)
    View barBtmLesson;
    @BindView(R.id.img_btm_lesson)
    ImageView imgBtmLesson;
    @BindView(R.id.btm_lesson)
    RelativeLayout btmLesson;
    @BindView(R.id.bar_btm_notif)
    View barBtmNotif;
    @BindView(R.id.img_btm_notif)
    ImageView imgBtmNotif;
    @BindView(R.id.btm_notif)
    RelativeLayout btmNotif;
    @BindView(R.id.bar_btm_profile)
    View barBtmProfile;
    @BindView(R.id.img_btm_profile)
    ImageView imgBtmProfile;
    @BindView(R.id.btm_profile)
    RelativeLayout btmProfile;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.tvToolbarTitle)
    TextView tvToolbarTitle;
    @BindView(R.id.tvNotifChat)
    TextView tvNotifChat;
    @BindView(R.id.tvNotifLesson)
    TextView tvNotifLesson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pivot_activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        mainStudentPresenter = new MainStudentPresenter(this, this);


        setupViews();

    }


    private void setupViews() {

        mainStudentPresenter.setupViewPager(viewPager, getSupportFragmentManager());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                resetBottomMenu();

                if (position == 0) {
                    imgBtmHome.setSelected(true);
                    barBtmHome.setVisibility(View.VISIBLE);
                    tvToolbarTitle.setVisibility(View.GONE);
                    llFindTeachers.setVisibility(View.VISIBLE);
                    llPoint.setVisibility(View.GONE);
                }
                if (position == 1) {
                    imgBtmChat.setSelected(true);
                    barBtmChat.setVisibility(View.VISIBLE);
                    tvToolbarTitle.setVisibility(View.VISIBLE);
                    tvToolbarTitle.setText("chat");
                    llFindTeachers.setVisibility(View.GONE);
                    llPoint.setVisibility(View.GONE);
                }
                if (position == 2) {
                    imgBtmLesson.setSelected(true);
                    tvToolbarTitle.setVisibility(View.VISIBLE);
                    tvToolbarTitle.setText("lesson");
                    barBtmLesson.setVisibility(View.VISIBLE);
                    llFindTeachers.setVisibility(View.GONE);
                    llPoint.setVisibility(View.GONE);
                }
//                if (position == 3) {
//                    imgBtmNotif.setSelected(true);
//                    tvToolbarTitle.setVisibility(View.VISIBLE);
//                    tvToolbarTitle.setText("Notifications");
//                    barBtmNotif.setVisibility(View.VISIBLE);
//                    llFindTeachers.setVisibility(View.GONE);
//                }
                if (position == 3) {
                    imgBtmProfile.setSelected(true);
                    tvToolbarTitle.setVisibility(View.VISIBLE);
                    tvToolbarTitle.setText("Profile");
                    barBtmProfile.setVisibility(View.VISIBLE);
                    llFindTeachers.setVisibility(View.GONE);
                    llPoint.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onBackPressed() {
//        if (!isExiting) {
//            Toast.makeText(this, R.string.pv_press_back_to_exit, Toast.LENGTH_SHORT).show();
//            isExiting = true;
//            return;
//        }

        super.onBackPressed();
    }

    @OnClick({R.id.btm_home, R.id.btm_chat, R.id.btm_lesson, R.id.btm_notif, R.id.btm_profile})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btm_home:
                viewPager.setCurrentItem(0);
                break;
            case R.id.btm_chat:
                viewPager.setCurrentItem(1);
                tvNotifChat.setVisibility(View.GONE);
                break;
            case R.id.btm_lesson:
                viewPager.setCurrentItem(2);
                tvNotifLesson.setVisibility(View.GONE);
                break;
//            case R.id.btm_notif:
//                viewPager.setCurrentItem(3);
//                break;
            case R.id.btm_profile:
                viewPager.setCurrentItem(3);
                break;
        }
    }

    private void resetBottomMenu() {

        imgBtmHome.setSelected(false);
        imgBtmChat.setSelected(false);
        imgBtmLesson.setSelected(false);
//        imgBtmNotif.setSelected(false);
        imgBtmProfile.setSelected(false);
        barBtmHome.setVisibility(View.GONE);
        barBtmChat.setVisibility(View.GONE);
        barBtmLesson.setVisibility(View.GONE);
//        barBtmNotif.setVisibility(View.GONE);
        barBtmProfile.setVisibility(View.GONE);

    }

}
