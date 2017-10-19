package com.brioal.flowview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * email:brioal@foxmail.com
 * github:https://github.com/Brioal
 * Created by brioa on 2017/4/11.
 */

public class FlowView extends View {

    private int mColorCircle;//圆圈颜色
    private int mColorDone;//已完成的颜色
    private int mColorUnReach;//未完成的颜色

    private Paint mPaintDone;
    private Paint mPaintUnReach;
    private Paint mPaintCircle;
    private int mFlowCount = 3;//流程总数
    private int mCurrentFlow = 3;//当前的流程
    private int mWidth;//View的宽度
    private int mHeight;//View的高度
    private int mFlowHeight;//线条的高度
    private int mCircleRadius;//圆圈的半径

    public FlowView(Context context) {
        this(context, null);
    }

    public FlowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttr(attrs);
        initPaint();
    }

    private void initAttr(AttributeSet attrs) {
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.FlowView);
        mFlowCount = array.getInteger(R.styleable.FlowView_allIndexCount, 3) - 1;
        mCurrentFlow = array.getInteger(R.styleable.FlowView_currentIndex, 2) - 1;
        mColorCircle = array.getColor(R.styleable.FlowView_colorCircle, getResources().getColor(R.color.colorCircle));
        mColorDone = array.getColor(R.styleable.FlowView_colorDone, getResources().getColor(R.color.colorDone));
        mColorUnReach = array.getColor(R.styleable.FlowView_colorUnDo, getResources().getColor(R.color.colorUnreach));
        array.recycle();
    }


    private void initPaint() {

        mPaintCircle = new Paint();
        mPaintCircle.setAntiAlias(true);
        mPaintCircle.setDither(true);

        mPaintDone = new Paint();
        mPaintDone.setAntiAlias(true);
        mPaintDone.setDither(true);

        mPaintUnReach = new Paint();
        mPaintUnReach.setAntiAlias(true);
        mPaintUnReach.setDither(true);
    }

    public int getColorCircle() {
        return mColorCircle;
    }

    public FlowView setColorCircle(int colorCircle) {
        mColorCircle = colorCircle;
        return this;
    }

    public int getColorDone() {
        return mColorDone;
    }

    public FlowView setColorDone(int colorDone) {
        mColorDone = colorDone;
        return this;
    }

    public int getColorUnReach() {
        return mColorUnReach;
    }

    public FlowView setColorUnReach(int colorUnReach) {
        mColorUnReach = colorUnReach;
        return this;
    }

    public int getFlowCount() {
        return mFlowCount;
    }

    public FlowView setFlowCount(int flowCount) {
        mFlowCount = flowCount;
        postInvalidate();
        return this;
    }

    public int getCurrentFlow() {
        return mCurrentFlow;
    }

    public FlowView setCurrentFlow(int currentFlow) {
        mCurrentFlow = currentFlow;
        postInvalidate();
        return this;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
        mFlowHeight = mHeight / 3;
        mCircleRadius = (mHeight - 10) / 2;
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaintDone.setColor(mColorDone);
        mPaintUnReach.setColor(mColorUnReach);
        mPaintCircle.setColor(mColorCircle);
        float singleLength = (mWidth - 10 - mCircleRadius * 2) * 1.0f / (mFlowCount-1);//每一段的距离
        float startX = 5 + mCircleRadius;
        float startY = mHeight / 2;
        //绘制基本线条
        canvas.drawRoundRect(new RectF(5 + mCircleRadius, mHeight / 2 - mFlowHeight / 2, mWidth - 5 - mCircleRadius, mHeight / 2 + mFlowHeight / 2), 10, 10, mPaintUnReach);
        //绘制未完成的小圆圈
        for (int i = 0; i <= mFlowCount+1; i++) {
            canvas.drawCircle(startX + i * singleLength, startY, mCircleRadius, mPaintUnReach);
        }
        //绘制已完成的线条
        canvas.drawRoundRect(new RectF(5 + mCircleRadius, mHeight / 2 - mFlowHeight / 2, 5 + mCircleRadius + singleLength * mCurrentFlow, mHeight / 2 + mFlowHeight / 2), 10, 10, mPaintDone);
        //绘制已完成的大圆圈
        for (int i = 0; i <= mCurrentFlow; i++) {
            canvas.drawCircle(startX + i * singleLength, startY, mCircleRadius, mPaintCircle);
        }
        //绘制已完成的小圆圈
        for (int i = 0; i <= mCurrentFlow; i++) {
            canvas.drawCircle(startX + i * singleLength, startY, mCircleRadius / 2 + 5, mPaintDone);
        }


    }
}
