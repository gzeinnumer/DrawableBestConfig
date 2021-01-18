# DrawableBestConfig

|![](https://github.com/gzeinnumer/DrawableBestConfig/blob/master/preview/example1.jpg)|![](https://github.com/gzeinnumer/DrawableBestConfig/blob/master/preview/example2.jpg)|
|---|---|
- style
```xml
<style name="Theme.DrawableBestConfig.NoActionBar">
    <item name="windowActionBar">false</item>
    <item name="windowNoTitle">true</item>
    <item name="drawerArrowStyle">@style/DrawerArrowStyle</item>
    <item name="android:fitsSystemWindows">false</item>
    <item name="android:navigationBarColor">#F9F9F9</item>
</style>

<style name="DrawerArrowStyle" parent="Widget.AppCompat.DrawerArrowToggle">
    <item name="spinBars">true</item>
    <item name="color">@color/purple_500</item>
    <item name="android:windowDrawsSystemBarBackgrounds">true</item>
</style>

<style name="Theme.DrawableBestConfig.AppBarOverlay" parent="ThemeOverlay.AppCompat.Dark.ActionBar" />

<style name="Theme.DrawableBestConfig.PopupOverlay" parent="ThemeOverlay.AppCompat.Light" />
```

- DashboardActivity
```java
public class DashboardActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }

        int decore = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //enable this tho maker icon Navigation bar become black
            decore =  View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //enable this tho maker icon status bar become black
            decore += View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        }

        getWindow().getDecorView().setSystemUiVisibility(decore);
    }
}
```

- Manifest
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest >

    <application >
        <activity
            android:name=".DashboardActivity"
            android:label="@string/title_activity_dashboard"
            android:theme="@style/Theme.DrawableBestConfig.NoActionBar">

            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

- [AndroidManifest.xml](https://github.com/gzeinnumer/DrawableBestConfig/blob/master/app/src/main/AndroidManifest.xml)
- [DashboardActivity.java](https://github.com/gzeinnumer/DrawableBestConfig/blob/master/app/src/main/java/com/gzeinnumer/drawablebestconfig/DashboardActivity.java)
- [HomeFragment.java](https://github.com/gzeinnumer/DrawableBestConfig/blob/master/app/src/main/java/com/gzeinnumer/drawablebestconfig/fr/HomeFragment.java)
- [activity_dashboard.xml](https://github.com/gzeinnumer/DrawableBestConfig/blob/master/app/src/main/res/layout/activity_dashboard.xml)
- [app_bar_main.xml](https://github.com/gzeinnumer/DrawableBestConfig/blob/master/app/src/main/res/layout/app_bar_main.xml)
- [content_main.xml](https://github.com/gzeinnumer/DrawableBestConfig/blob/master/app/src/main/res/layout/content_main.xml)
- [custom_layout_header_drawer.xml](https://github.com/gzeinnumer/DrawableBestConfig/blob/master/app/src/main/res/layout/custom_layout_header_drawer.xml)
- [fragment_home.xml](https://github.com/gzeinnumer/DrawableBestConfig/blob/master/app/src/main/res/layout/fragment_home.xml)
- [menu_navigation_drawer.xml](https://github.com/gzeinnumer/DrawableBestConfig/blob/master/app/src/main/res/menu/menu_navigation_drawer.xml)
- [mobile_navigation.xml](https://github.com/gzeinnumer/DrawableBestConfig/blob/master/app/src/main/res/navigation/mobile_navigation.xml)
- [themes.xml](https://github.com/gzeinnumer/DrawableBestConfig/blob/master/app/src/main/res/values/themes.xml)

---

```
Copyright 2021 M. Fadli Zein
```