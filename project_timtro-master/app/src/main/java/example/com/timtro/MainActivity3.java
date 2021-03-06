package example.com.timtro;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity3 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Spinner spinner;
    private String[] language;
    private ArrayAdapter<String> spinnerAddapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //tao chu tren thanh toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //tao thanh menu va su kien khi click no
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        spinner = (Spinner) findViewById(R.id.spiner1);
        language = getResources().getStringArray(R.array.gioi_tinh);
        spinnerAddapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,language);
        spinner.setAdapter(spinnerAddapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("selected: "+language[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void onClick(View view){
        Snackbar.make(view, "Đăng tin thành công", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        Thread bamgio=new Thread(){
            public void run()
            {
                try {
                    sleep(3000);
                } catch (Exception e) {

                }
                finally
                {
                    Intent activitymoi=new Intent("example.com.timtro.MainActivity");
                    startActivity(activitymoi);
                }
            }
        };
        bamgio.start();
        // finish();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
   //ham xu li mục setting
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.search_view) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()){
            case R.id.tim_phong:
                Intent intent1 = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.tim_ghep:
                Intent intent2 = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent2);
                break;
            case R.id.dang_cho_thue:
                //TODO
                break;
            case R.id.dang_tim_ghep:
                Intent intent3 = new Intent(MainActivity3.this, MainActivity3.class);
                startActivity(intent3);
                break;
            case R.id.tro_giup:
                //TODO
                break;
            case R.id.bao_cao:
                //TODO
                break;
            case R.id.cai_dat:
                //TODO
                break;
            default:
                break;
        }

        //cau lenh de quay ve man hinh chinh
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    protected void onPause(){
        super.onPause();
        finish();
    }
}
