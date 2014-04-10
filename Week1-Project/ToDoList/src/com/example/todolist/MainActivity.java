package com.example.todolist;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	//Create variables needed
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
    	//get elements by their ids
    	homework = (CheckBox)findViewById(R.id.check_homework);
    	chores = (CheckBox)findViewById(R.id.check_chores);
    	clean = (CheckBox)findViewById(R.id.check_cleanRoom);
    	brush = (CheckBox)findViewById(R.id.check_brushTeeth);
    	choice = (CheckBox)findViewById(R.id.check_user);
    	userEdit = (EditText)findViewById(R.id.edit_user);
    	checkArrays = new CheckBox[] {homework, chores, clean, brush, choice};
    	
    	//if the edit view has text then change the integer needed to complete the list 
    	if (userEdit.getText().toString().equals("")) {
    		choiceText = false;
    		countNeeded = 4;
    	}else{
    		choiceText = true;
    		countNeeded = 5;
    	}
    	
    	//loop to count how many check boxes are checked
    	for (int i = 0; i < checkArrays.length; i++) {
    		if(checkArrays[i].isChecked() == true) {
    			count = count + 1;
    			
    			//if the edit view is checked change amount needed to complete list
    			if (choice.isChecked() == true) {
    				countNeeded = 5;
    			}
    		};

    		
    		//if there is a check or text in the user editable check box
    		//and text view and the number of boxes checked is correct the
    		//set bool to true

    		if (choiceText == true || choice.isChecked() == true) {
    			if (count == 5) {
    				checked = true;  				
    			}
    		//if edit view not used and the count is 4 then set bool to true
    		}else {
    			if (count == 4){
    				checked = true;
    			}
    		}
    	}
    	
    	//if all boxes are checked change padding of text view and set text
    	if (checked == true) {
    		finishedTextView = (TextView)findViewById(R.id.textView_toDo);
    		finishedTextView.setPadding(0,0,0,0);
    		finishedText = "Congratulations! You completeted all"+" " + count + " " + "tasks!";
    	}else{
    		
    	//if all boxes are not checked change padding of text view and set text
    		finishedTextView = (TextView)findViewById(R.id.textView_toDo);
    		finishedTextView.setPadding(125,0,0,0);
    		finishedText = "You still have" + " " + (countNeeded - count) + " " + "tasks left.";
    	}
    	//run finished function
    	finished();
    }
    
    //clear button and elements from ids
    public void onClear(View view) {
    	homework = (CheckBox)findViewById(R.id.check_homework);
    	chores = (CheckBox)findViewById(R.id.check_chores);
    	clean = (CheckBox)findViewById(R.id.check_cleanRoom);
    	brush = (CheckBox)findViewById(R.id.check_brushTeeth);
    	choice = (CheckBox)findViewById(R.id.check_user);
    	userEdit = (EditText)findViewById(R.id.edit_user);
    	
    	//clear edit view
    	userEdit.setText("");
    	
    	//series of if statements to see if boxes are checked. if they 
    	//are the click them off
    		if (homework.isChecked() == true) {
    			homework.performClick();
    		}
    		if (chores.isChecked() == true) {
    			chores.performClick();
    		}
    		if (clean.isChecked() == true) {
    			clean.performClick();
    		}
    		if (brush.isChecked() == true) {
    			brush.performClick();
    		}
    		if (choice.isChecked() == true) {
    			choice.performClick();
    		}
    	
    	//change text view text and padding
    	finishedTextView = (TextView)findViewById(R.id.textView_toDo);
    	finishedTextView.setPadding(0,0,0,0);
    	finishedText = "Completed all tasks? Press Finished.";
    	finishedTextView.setText(finishedText);
    }
    
    //finished function that sets text to text view and resets the count
    //and the bool for the check boxes
    public void finished() {
    	finishedTextView = (TextView)findViewById(R.id.textView_toDo);
    	finishedTextView.setText(finishedText);
    	checked = false;
    	count = 0;
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
