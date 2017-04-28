package com.brioal.flowviewproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.brioal.flowview.FlowView;

public class MainActivity extends AppCompatActivity {
    private FlowView mFlowView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFlowView = (FlowView) findViewById(R.id.main_flowView);
        mFlowView.setFlowCount(3);
        mFlowView.setCurrentFlow(2);
    }
}
