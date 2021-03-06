package com.vansuita.materialabout.sample.helper;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;

import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.sample.R;
import com.vansuita.materialabout.views.AboutView;

/**
 * Created by jrvansuita on 17/02/17.
 */
public class SampleHelper implements View.OnClickListener {

    private Activity activity;
    private int theme = R.style.AppThemeDark;

    private SampleHelper(Activity activity) {
        this.activity = activity;
    }

    public static SampleHelper with(Activity activity) {
        return new SampleHelper(activity);
    }

    public SampleHelper init() {
        activity.setTheme(theme);

        activity.findViewById(R.id.dark).setOnClickListener(this);
        activity.findViewById(R.id.light).setOnClickListener(this);
        activity.findViewById(R.id.custom).setOnClickListener(this);

        return this;
    }

    public void loadAbout() {
        final FrameLayout flHolder = activity.findViewById(R.id.about);

        AboutBuilder builder = AboutBuilder.with(activity)
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .setPhoto(R.drawable.amar_chobi)
                .setCover(R.mipmap.profile_cover)
                .setLinksAnimated(true)
                .setDividerDashGap(13)
                .setName("Fayaz Bin Salam")
                .setSubTitle("Programmer and Developer")
                .setLinksColumnsCount(4)
                .addFacebookLink("p32929")
                .addTwitterLink("p32929")
                .addInstagramLink("p32929")
                .addYoutubeChannelLink("UC4T4Qi_DDvLKz9o4VhUjz4Q")
                .addEmailLink("p32929@gmail.com")
                .addGitHubLink("p32929")
                .addLinkedInLink("p32929")
                .addGooglePlusLink("112639130440478563588")
                .addFiveStarsAction()
                .addMoreFromMeAction("p32929")
                .setVersionNameAsAppSubTitle()
                .addShareAction("DeSplash", "Check out this High Quality, Professional photographer taken wallpaper app!!")
                .addJoinFbGroupAction("2057349181171399")
                .setActionsColumnsCount(2)
                .addFeedbackAction("p32929@gmail.com", "DeSplash Feedback", "Please add \'this\' category")
                .setWrapScrollView(true)
                .addUpdateAction("https://github.com/p32929/MaterialAbout", true)
                .setShowAsCard(true);

        AboutView view = builder.build();

        flHolder.addView(view);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dark:
                if (theme != R.style.AppThemeDark) {
                    theme = R.style.AppThemeDark;
                    activity.recreate();
                }
                break;
            case R.id.light:
                if (theme != R.style.AppThemeLight) {
                    theme = R.style.AppThemeLight;
                    activity.recreate();
                }
                break;

            case R.id.custom:
                if (theme != R.style.AppThemeCustom) {
                    theme = R.style.AppThemeCustom;
                    activity.recreate();
                }
                break;

            default:
                break;
        }
    }
}
