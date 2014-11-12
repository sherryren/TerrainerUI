package com.example.sherry.test;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import backend.BlueToothCommunicator;
import backend.BluetoothArduino;
import backend.ResistanceLevel;


/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link ItemListFragment} and the item details
 * (if present) is a {@link ItemDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link ItemListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class ItemListActivity extends Activity
        implements ItemListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    private final String BLUETOOTH_NAME = "HC-06";
    private TextView resistanceDisplay;
    private BluetoothArduino bluetoothArduino= BluetoothArduino.getInstance(BLUETOOTH_NAME);
    private ResistanceLevel resistanceLevel = new ResistanceLevel();
    private boolean connected=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_resistance);
        resistanceDisplay = (TextView) findViewById(R.id.currentResistance);
        resistanceDisplay.setText(String.valueOf(resistanceLevel.getCurrentResistance()));
        resistanceDisplay.setTextSize(100);
        connectBluetooth();


        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((ItemListFragment) getFragmentManager()
                    .findFragmentById(R.id.item_list))
                    .setActivateOnItemClick(true);

        }

        // TODO: If exposing deep links into your app, handle intents here.
    }

    /**
     * Callback method from {@link ItemListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID, id);
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ItemDetailActivity.class);
            detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }

    private void connectBluetooth (){
        if (!connected){
            bluetoothArduino.Connect();
            bluetoothArduino.SendMessage(String.valueOf(resistanceLevel.getCurrentResistance()));
            connected = true;
        }
    }

    public void chooseDistanceTime(View view){
        resistanceLevel.changeResistance(1);
        bluetoothArduino.SendMessage(String.valueOf(resistanceLevel.getCurrentResistance()));
        resistanceDisplay.setText(String.valueOf(resistanceLevel.getCurrentResistance()));
    }
    
      public void increaseResistance(View view){
        resistanceLevel.changeResistance(1);
        bluetoothArduino.SendMessage(String.valueOf(resistanceLevel.getCurrentResistance()));
        resistanceDisplay.setText(String.valueOf(resistanceLevel.getCurrentResistance()));
    }

    
    public void decreaseResistance(View view){
        resistanceLevel.changeResistance(-1);
        bluetoothArduino.SendMessage(String.valueOf(resistanceLevel.getCurrentResistance()));
        resistanceDisplay.setText(String.valueOf(resistanceLevel.getCurrentResistance()));
    }

    public void editResistance(View view){}
}
