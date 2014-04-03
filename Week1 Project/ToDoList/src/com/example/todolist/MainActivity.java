package com.example.todolist;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	CheckBox homework, chores, clean, brush, choice;
	TextView finishedTextView;
	int count;
	int countNeeded = 4;
	boolean checked = false;
	boolean choiceText = false;
	String finishedText;
	EditText userEdit;
	private CheckBox[] checkArrays;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    public void onClick(View view) {
    	homework = (CheckBox)findViewById(R.id.check_homework);
    	chores = (CheckBox)findViewById(R.id.check_chores);
    	clean = (CheckBox)findViewById(R.id.check_cleanRoom);
    	brush = (CheckBox)findViewById(R.id.check_brushTeeth);
    	choice = (CheckBox)findViewById(R.id.check_user);
    	userEdit = (EditText)findViewById(R.id.edit_user);
    	checkArrays = new CheckBox[] {homework, chores, clean, brush, choice};
    	if (userEdit.getText().toString().equals("")) {
    		choiceText = false;
    	}else{
    		choiceText = true;
    		countNeeded = 5;
    	}
    	for (int i = 0; i < checkArrays.length; i++) {
    		if(checkArrays[i].isChecked() == true) {
    			count = count + 1;
    		};
    		if (choiceText == true) {
    			if (count == 5) {
    				checked = true;  				
    			}
    		}else {
    			if (count == 4){
    				checked = true;
    			}
    		}
    	}
    	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
