package de.pfaffenrodt.swapadaptertest;

/**
 * Created by Pfaffenrodt on 02.06.2015.
 */
public class DummyItem{
    private long id;
    private String text;
    private int color;

    public DummyItem(long id, String text, int color) {
        this.id = id;
        this.text = text;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
