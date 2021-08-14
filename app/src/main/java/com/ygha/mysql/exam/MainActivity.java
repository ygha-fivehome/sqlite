package com.ygha.mysql.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.ygha.mysql.exam.databinding.ActivityMainBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SpaceDatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    ArrayList<DeviceInfo> DeviceInfos;

    ActivityMainBinding mainBinding;

    DeviceRecyclerAdapter mRecyclerAdapter;
    private List mItemList = new ArrayList<SpaceEntity>();
    private int currentCursorId = -1;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext= this;
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setMainActivity(this);
        initData();
        initLayout();
    }

    public void initData(){
        DeviceInfos = new ArrayList<>();
        DeviceInfos.add(new DeviceInfo(0,"거실", "전등1", "43232"));
        DeviceInfos.add(new DeviceInfo(1,"거실", "전등2", "113344"));
        DeviceInfos.add(new DeviceInfo(2,"주방", "전등3", "02211"));
        DeviceInfos.add(new DeviceInfo(3,"침실", "전등4", "21232"));
        DeviceInfos.add(new DeviceInfo(4,"주방", "전등5", "023441"));
        DeviceInfos.add(new DeviceInfo(5,"침실", "전등6", "222333"));
    }

    public void saveButton(View view){

    }

    private void bindInsert(){
        final String spaceName = mainBinding.txtNickname.getText().toString();
        final String uuid = mainBinding.txtUuid.getText().toString();
    }

    private void updateList(){
        mItemList.clear();
        mItemList.addAll(getAllData());
        mRecyclerAdapter.notifyDataSetChanged();
    }

    private void bindDelete(){

    }



    public void bindList(){
        mRecyclerAdapter = new DeviceRecyclerAdapter(mItemList);
        mRecyclerAdapter.setOnItemClickListener((a_view, a_position) -> {
            SpaceEntity spaceEntity = (SpaceEntity) mItemList.get(a_position);
            currentCursorId = spaceEntity.getId();

           // mEtGrade.setText(spaceEntity.getSpace());
           // mEtNumber.setText(spaceEntity.getNickname());
           // mEtName.setText(spaceEntity.getUuid());
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mRecyclerAdapter);
    }

    public void initLayout(){

        String[] spaceMode = {"직접입력","거실","주방","침실", "안방", "서재"};
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(spaceMode, mContext);
        mainBinding.spinner.setAdapter(spinnerAdapter);
        mainBinding.spinner.setSelection(0);

        mainBinding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }




    private List getAllData(){
        List entityList = new ArrayList();

        String[] projection = {
                SpaceDatabaseContract.SapceEntry._ID,
                SpaceDatabaseContract.SapceEntry.SAPCE,
                SpaceDatabaseContract.SapceEntry.NICKNAME,
                SpaceDatabaseContract.SapceEntry.UUID
        };

        Cursor cursor = mDb.query(SpaceDatabaseContract.SapceEntry.TABLE_NAME, projection,
                null, null, null, null,null);

        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(SpaceDatabaseContract.SapceEntry._ID));
            String space = cursor.getString(cursor.getColumnIndexOrThrow(SpaceDatabaseContract.SapceEntry.SAPCE));
            String nickname = cursor.getString(cursor.getColumnIndexOrThrow(SpaceDatabaseContract.SapceEntry.NICKNAME));
            String uuid = cursor.getString(cursor.getColumnIndexOrThrow(SpaceDatabaseContract.SapceEntry.UUID));
            entityList.add(new SpaceEntity(id,space,nickname,uuid));
        }
        cursor.close();
        return entityList;
    }

    private void updateData(String a_uuid, String space, String nickname, String uuid){
        ContentValues values = new ContentValues();
        values.put(SpaceDatabaseContract.SapceEntry.SAPCE, space);
        values.put(SpaceDatabaseContract.SapceEntry.NICKNAME, nickname);
        values.put(SpaceDatabaseContract.SapceEntry.UUID, uuid);
        mDb.update(SpaceDatabaseContract.SapceEntry.TABLE_NAME, values, SpaceDatabaseContract.SapceEntry.UUID+"="+a_uuid, null);
    }

    private void insertData(String space, String nickname, String uuid){
        ContentValues values = new ContentValues();
        values.put(SpaceDatabaseContract.SapceEntry.SAPCE, space);
        values.put(SpaceDatabaseContract.SapceEntry.NICKNAME, nickname);
        values.put(SpaceDatabaseContract.SapceEntry.UUID, uuid);
        currentCursorId = (int) mDb.insert(SpaceDatabaseContract.SapceEntry.TABLE_NAME, null, values);
    }

    private boolean deleteData(String a_uuid){
        return mDb.delete(SpaceDatabaseContract.SapceEntry.TABLE_NAME, SpaceDatabaseContract.SapceEntry.UUID +"="+a_uuid, null)>0;
    }



    public void addDeviceOne(View view){
        mainBinding.txtNickname.setText(DeviceInfos.get(0).getNickname());
    }

    public void addDeviceTwo(View view){
        mainBinding.txtNickname.setText(DeviceInfos.get(1).getNickname());
    }

    public void addDeviceThree(View view){
        mainBinding.txtNickname.setText(DeviceInfos.get(2).getNickname());
    }

    public void addDeviceFour(View view){
        mainBinding.txtNickname.setText(DeviceInfos.get(3).getNickname());
    }

    public void addDeviceFive(View view){
        mainBinding.txtNickname.setText(DeviceInfos.get(4).getNickname());
    }

    public void addDeviceSix(View view){
        mainBinding.txtNickname.setText(DeviceInfos.get(5).getNickname());
    }

}