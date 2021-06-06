package com.example.android.droidcafeinput;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
/**
 * A PreferenceActivity that presents a set of application settings. On handset
 * devices, settings are presented as a single list. On tablets, settings are
 * split by category, with category headers shown to the left of the list of
 * settings.
 */
public class SettingsActivity extends AppCompatActivity implements
        PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {
    /**
     * A preference value change listener that updates the preference's summary
     * to reflect its new value.
     */
    private static final String TITLE = "settingsActivityTitle";
    public static class HeaderFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState,
                                        String rootKey) {
            setPreferencesFromResource(R.xml.pref_headers, rootKey);
        }
    }

    public static class MessagesFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState,
                                        String rootKey) {
            setPreferencesFromResource(R.xml.pref_notification, rootKey);
        }
    }

    public static class SyncFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState,
                                        String rootKey) {
            setPreferencesFromResource(R.xml.pref_account, rootKey);
        }
    }

    public static class GeneralFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState,
                                        String rootKey) {
            setPreferencesFromResource(R.xml.pref_general, rootKey);
        }
    }
    /**
     * Sets up the action bar for the activity.
     *
     * @param savedInstanceState Saved instance state bundle.
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        if (savedInstanceState == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new HeaderFragment())
                    .commit();
        else
            setTitle(savedInstanceState.getCharSequence(TITLE));

        getSupportFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    @Override
                    public void onBackStackChanged() {
                        if (getSupportFragmentManager()
                                .getBackStackEntryCount() == 0)
                            setTitle(R.string.title_activity_settings);
                    }
                }
        );
        /**
         * Set up the android.app.ActionBar, if the API is available.
         */
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onPreferenceStartFragment(PreferenceFragmentCompat caller,
                                             @NonNull Preference pref) {
        final Bundle args = pref.getExtras();
        final Fragment fragment = getSupportFragmentManager()
                .getFragmentFactory().instantiate(getClassLoader(),
                        pref.getFragment());

        fragment.setArguments(args);
        fragment.setTargetFragment(caller, 0);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, fragment)
                .addToBackStack(null)
                .commit();

        setTitle(pref.getTitle());

        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence(TITLE, getTitle());
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (getSupportFragmentManager().popBackStackImmediate())
            return true;
        return super.onSupportNavigateUp();
    }

}
