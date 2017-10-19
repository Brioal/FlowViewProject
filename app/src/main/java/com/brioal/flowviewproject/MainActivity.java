package com.brioal.flowviewproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.brioal.flowview.FlowView;

public class MainActivity extends AppCompatActivity {

    private FlowView mFlowView;
    private Spinner mSpinnerCount;
    private Spinner mSpinnerIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initIDs();
        initView();
    }

    private void initView() {
        mFlowView.setFlowCount(3).setCurrentFlow(0);
        mSpinnerCount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final int count = position + 3;
                mFlowView.setFlowCount(count);
                mSpinnerIndex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position > count - 1) {
                            Toast.makeText(MainActivity.this, "超出范围", Toast.LENGTH_SHORT).show();
                        } else {
                            mFlowView.setCurrentFlow(position);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initIDs() {
        mFlowView = (FlowView) findViewById(R.id.main_flowView);
        mSpinnerCount = (Spinner) findViewById(R.id.main_spinner_count);
        mSpinnerIndex = (Spinner) findViewById(R.id.main_spinner_index);
    }
}
