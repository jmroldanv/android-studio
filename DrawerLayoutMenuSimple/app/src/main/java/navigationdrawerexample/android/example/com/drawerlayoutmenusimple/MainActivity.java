package navigationdrawerexample.android.example.com.drawerlayoutmenusimple;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    private DrawerLayout mDrawer;
    private ListView mDrawerOptions;
    private static final String[] values = {"Drawer 1", "Drawer 2", "Drawer 3"};

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawerlayout);

        /*
            AppTheme no support "actionBar" and throws a NullPointerExeption


            To solve the problem, we put on a Theme with ActionBar support (Holo, ...):

                AndroidManifest.xml:
                     android:theme="@android:style/Theme.Holo.Light"
         */
        getActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerOptions = (ListView) findViewById(R.id.left_drawer);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        mDrawerOptions.setAdapter(new ArrayAdapter<String>(this, R.layout.row, R.id.textView1, values));
        mDrawerOptions.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Pulsado " + values[i], Toast.LENGTH_SHORT).show();
        mDrawer.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                if (mDrawer.isDrawerOpen(mDrawerOptions)){
                    mDrawer.closeDrawers();
                }else{
                    mDrawer.openDrawer(mDrawerOptions);
                }
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
