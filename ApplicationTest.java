package com.jhi.ismart;

import android.app.Application;
import android.support.annotation.IdRes;
import android.support.design.widget.TextInputLayout;
import android.support.test.espresso.ViewInteraction;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.EditText;
import android.widget.TextView;
import com.jhi.ismart.activities.AccountAuthenticationActivity;
import com.jhi.ismart.fragments.LoginFragment;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.hasContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;



/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

class EspressoTextInputLayoutUtils{
    /*
     * Use this method to find the EditText within the TextInputLayout. Useful for typing into the TextInputLayout
     */
    public static ViewInteraction onEditTextWithinTilWithId(@IdRes int textInputLayoutId) {
        //Note, if you have specified an ID for the EditText that you place inside
        //the TextInputLayout, use that instead - i.e, onView(withId(R.id.my_edit_text));
        return onView(allOf(isDescendantOfA(withId(textInputLayoutId)), isAssignableFrom(EditText.class)));
    }

    /*
     * Use this method to find the error view within the TextInputLayout. Useful for asseting that certain errors are displayed to the user
     */
    public static ViewInteraction onErrorViewWithinTilWithId(@IdRes int textInputLayoutId) {
        return onView(allOf(isDescendantOfA(withId(textInputLayoutId)), not(isAssignableFrom(EditText.class)), isAssignableFrom(TextView.class)));
    }


}


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ApplicationTest extends ApplicationTestCase<Application> {

    public ApplicationTest() {
        super(Application.class);
    }


    @Rule
    public ActivityTestRule<AccountAuthenticationActivity> mActivityRule = new ActivityTestRule(AccountAuthenticationActivity.class);

    @Test
    public void signIn() {

        /*onView(withId(R.id.tv_sign_in)).perform(click());
        EspressoTextInputLayoutUtils.onEditTextWithinTilWithId(R.id.til_email).perform(typeText(LoginUtils.validRandomEmail("rbrazuk@tonicdesign.com",6)));
        EspressoTextInputLayoutUtils.onEditTextWithinTilWithId(R.id.til_password).perform(typeText(LoginUtils.randomPassword(6, 2, true)));
        onView(allOf(withId(R.id.tv_sign_in),withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))).perform(click());*/

        onView(withId(R.id.tv_sign_in)).perform(click());
        EspressoTextInputLayoutUtils.onEditTextWithinTilWithId(R.id.til_email).perform(typeText("rbrazuk+espresso@tonicdesign.com"));
        EspressoTextInputLayoutUtils.onEditTextWithinTilWithId(R.id.til_password).perform(typeText("qwerty1234"));
        onView(allOf(withId(R.id.tv_sign_in), withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))).perform(click());
        //onView(withId(R.id.dl_drawer)).perform(DrawerActions.open());



        // onView(withId(android.R.id.home)).perform(click());

        // onView(withId(R.id.tv_medication_action)).perform(click());






    }
}
