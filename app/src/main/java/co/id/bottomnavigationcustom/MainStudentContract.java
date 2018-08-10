package co.id.bottomnavigationcustom;

import android.support.v4.app.FragmentManager;


/**
 * Created by Dhiky Aldwiansyah on 19/02/18.
 */

public interface MainStudentContract {

    interface MainView {
    }

    interface MainPresenter {

        void setupViewPager(CustomVPNoPaging viewPager, FragmentManager supportFragmentManager);
        void changeTabPosition(String position);

    }

}
