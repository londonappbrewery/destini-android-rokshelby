package com.londonappbrewery.destini;

public class StoryPlusButtons
{

    StoryPlusButtons(int str, int top, int bot)
    {
        setStory(str);
        setBottomButton(bot);
        setTopButton(top);
    }

    public int getStory() {
        return story;
    }

    public void setStory(int story) {
        this.story = story;
    }

    public int getTopButton() {
        return topButton;
    }

    public void setTopButton(int topButton) {
        this.topButton = topButton;
    }

    public int getBottomButton() {
        return bottomButton;
    }

    public void setBottomButton(int bottomButton) {
        this.bottomButton = bottomButton;
    }

    int story;
    int topButton;
    int bottomButton;

}
