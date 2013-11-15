/*
 * This is an example test project created in Eclipse to test NotePad which is a sample 
 * project located in AndroidSDK/samples/android-11/NotePad
 * 
 * 
 * You can run these test cases either on the emulator or on device. Right click
 * the test project and select Run As --> Run As Android JUnit Test
 * 
 * @author Renas Reda, renasreda@gmail.com
 * 
 */

package cis573.carecoor.test;

//import cis573.*;
import cis573.carecoor.*;

import com.jayway.android.robotium.solo.Solo;

import android.R.bool;
import android.R.integer;
import android.test.ActivityInstrumentationTestCase2;

public class MedTest extends ActivityInstrumentationTestCase2<MainActivity>{

	private Solo solo;

	public MedTest() {
		super(MainActivity.class);

	}

	@Override
	public void setUp() throws Exception {
		//setUp() is run before a test case is started. 
		//This is where the solo object is created.
		solo = new Solo(getInstrumentation(), getActivity());
	}

	@Override
	public void tearDown() throws Exception {
		//tearDown() is run after a test case has finished. 
		//finishOpenedActivities() will finish all the activities that have been opened during the test execution.
		solo.finishOpenedActivities();
	}
	
	/*
	public void testAlert() throws Exception {
		
		solo.clickOnText("Primary Number");

		solo.typeText(0, "2156960581");
		solo.clickOnButton("OK");
	
		solo.clickOnButton("ALERT");

		solo.clickOnButton("OK");
		//solo.clickOnButton("End");
		//solo.goBack();
		assert true;
		

	}*/

	public void testContacts(){
		//solo.goBackToActivity("MainActivity");
		//test +
		solo.scrollToSide(Solo.RIGHT,(float)0.8);
		solo.clickOnButton("+");
		solo.typeText(0, "wei");
		solo.typeText(1, "123456");
		solo.clickOnButton("OK");
		boolean actual=solo.searchText("123456");
		assertEquals(true, actual);
		
		//test import
		//solo.clickOnButton("Import");
		//solo.clickOnView(solo.getView(id))
		//actual=solo.searchText("wei");
		//assert actual; 
	}
	
	public void testReminder() throws Exception {

		for(int i=1;i<=2;i++)
			solo.scrollToSide(Solo.RIGHT, (float)0.8);
		
		boolean actual;
		
		solo.clickOnButton("New Schedule");
		solo.assertCurrentActivity("activity call error", "ChooseMedActivity");
		solo.clickInList(1);
		solo.assertCurrentActivity("activity call error", "SetScheduleActivity");
		
		solo.clickOnToggleButton("0:00\nAM");
		solo.clickOnToggleButton("5:00\nPM");
		solo.scrollDown();
		solo.clickOnButton("OK");
		
		actual=solo.searchText("Reminder")&&solo.searchText("Metformin");
		assert actual;
		
		solo.clickOnView(solo.getView("schedule_item_name",0));
		
		solo.assertCurrentActivity("activity call error", "TakeMedicineActivity");
		
		solo.goBackToActivity("MainActivity");
		
		solo.clickLongOnView(solo.getView("schedule_item_name"),0);
		actual=solo.searchText("Remove");
		assert actual;
		
		//solo.getCurrentViews(Class<Button>);
		//solo.clickOnButton("OK");
		solo.clickOnButton(0);
		
		/*
		actual=solo.searchText("No medicines are scheduled");
		assert actual;*/
	}
	
	public void testHistory(){
		for(int i=1;i<=3;i++)
			solo.scrollToSide(Solo.RIGHT, (float)0.8);
	}
	
	public void testFriends(){
		for(int i=1;i<=4;i++)
			solo.scrollToSide(Solo.RIGHT, (float)0.8);
		
	
		solo.clickOnText("Penn Nursing");
		solo.clickOnButton("OK");
		
		
		/*
		actual=solo.searchText("facebook");
		assert actual;
		solo.goBack();
		solo.clickOnText("Penn Engineering");*/
		
		
	}
}
