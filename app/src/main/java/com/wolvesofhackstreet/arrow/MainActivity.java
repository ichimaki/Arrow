package com.wolvesofhackstreet.arrow;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.parse.ParseAnalytics;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    ParseAnalytics.trackAppOpenedInBackground(getIntent());

        // If no user logged in, then open the login page
        /* After using any signup or login methods, the user is cached on disk. This cache can be
             treated as a session.
         */
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser == null) {
            navigateToLogin();
        }
        else {
            Log.i(TAG, currentUser.getUsername());
        }

        // Harsh
        FloatingActionButton plusButton;

            plusButton= (FloatingActionButton) findViewById(R.id.plus);
            plusButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    startActivity(new Intent(MainActivity.this, SetNewReminder.class));

                }
            });
    }

    //function Harsh
   /* public void call(Intent intent){

        setContentView(activity_main);
        Bundle gettitle=getIntent().getExtras();
        String title= gettitle.getString("listitem");

        listview = (ListView) findViewById(R.id.listview1);
        final List<String> ListElementsArrayList = new
                ArrayList<String>(Arrays.asList(ListElements));


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (MainActivity.this, android.R.layout.simple_list_item_1, ListElementsArrayList);

        listview.setAdapter(adapter);
        ListElementsArrayList.add(title.toString());

        adapter.notifyDataSetChanged();
    }
*/


    private void navigateToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            ParseUser.logOut();
            navigateToLogin();
        }



        return super.onOptionsItemSelected(item);
    }
}
