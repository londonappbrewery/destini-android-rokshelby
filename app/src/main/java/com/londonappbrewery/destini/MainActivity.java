package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView mStoryText;
    Button mTopButton;
    Button mBottomButton;
    int mStoryIndex;

    // TODO: Steps 4 & 8 - Declare member variables here:

    private StoryPlusButtons[] mStoryPlusButtons = new StoryPlusButtons[] {
            new StoryPlusButtons(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new StoryPlusButtons(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans1),
            new StoryPlusButtons(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans1),
            new StoryPlusButtons(R.string.T4_End,0,0),
            new StoryPlusButtons(R.string.T5_End, 0,0),
            new StoryPlusButtons(R.string.T6_End, 0,0)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null)
        {
            mStoryIndex = savedInstanceState.getInt("StoryKey");

        }
        else{
            mStoryIndex = 1;
        }


        mStoryText = findViewById(R.id.storyTextView);
        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);

        if(mStoryIndex > 3) {
            mStoryText.setText(mStoryPlusButtons[mStoryIndex-1].getStory());
            mTopButton.setVisibility(View.INVISIBLE);
            mBottomButton.setVisibility(View.INVISIBLE);

        }
        else{
            mStoryText.setText(mStoryPlusButtons[mStoryIndex-1].getStory());
            mBottomButton.setText(mStoryPlusButtons[mStoryIndex-1].getBottomButton());
            mTopButton.setText(mStoryPlusButtons[mStoryIndex-1].getTopButton());
            mTopButton.setVisibility(View.VISIBLE);
            mBottomButton.setVisibility(View.VISIBLE);
        }






        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                checkState(0);
            }
        });

        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                checkState(1);
            }
        });


    }
    public void checkState(int value)
    {
        if(mStoryText.getText() == returnString(R.string.T1_Story))
        {
            if(value == 0)
            {
                mStoryIndex = 3;
                mStoryText.setText(R.string.T3_Story);
                mTopButton.setText(R.string.T3_Ans1);
                mBottomButton.setText(R.string.T3_Ans2);
            }
            else
            {
                mStoryIndex = 2;
                mStoryText.setText(R.string.T2_Story);
                mTopButton.setText(R.string.T2_Ans1);
                mBottomButton.setText(R.string.T2_Ans2);
            }
        }
        else if(mStoryText.getText() == returnString(R.string.T2_Story))
        {
            if(value == 0)
            {
                mStoryIndex = 3;
                mStoryText.setText(R.string.T3_Story);
                mTopButton.setText(R.string.T3_Ans1);
                mBottomButton.setText(R.string.T3_Ans2);
            }
            else
            {
                mStoryIndex = 4;
                mStoryText.setText(R.string.T4_End);
                mBottomButton.setVisibility(View.INVISIBLE);
                mTopButton.setVisibility(View.INVISIBLE);
            }
        }
        else if(mStoryText.getText() == returnString(R.string.T3_Story))
        {
            if(value == 0)
            {
                mStoryIndex = 6;
                mStoryText.setText(R.string.T6_End);
                mBottomButton.setVisibility(View.INVISIBLE);
                mTopButton.setVisibility(View.INVISIBLE);
            }
            else
            {
                mStoryIndex = 5;
                mStoryText.setText(R.string.T5_End);
                mBottomButton.setVisibility(View.INVISIBLE);
                mTopButton.setVisibility(View.INVISIBLE);
            }
        }
    }

    public String returnString(int x)
    {
       return (String) getResources().getText(x);
    }
    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("StoryKey", mStoryIndex);
    }
}
