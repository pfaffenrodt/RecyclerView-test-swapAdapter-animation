package de.pfaffenrodt.swapadaptertest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private final int DUMMY_COUNT = 40;
    private boolean swaped;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();


        findViewById(R.id.main_button_swap).setOnClickListener(onClickListener);
        findViewById(R.id.main_button_set_list).setOnClickListener(onClickListener);
    }

    void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(createNewAdapter());

        swaped = !swaped;
    }

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.main_button_swap:
                    swapAdapter();
                break;
                case R.id.main_button_set_list:
                    setList();
                break;
            }
        }
    };

    public DummyAdapter createNewAdapter() {
        ArrayList<DummyItem> dummyItemArrayList = createNextDummyItems();
        DummyAdapter dummyAdapter = new DummyAdapter(dummyItemArrayList);

        /**
         * important to provide animations at swap adapter.
         */
        dummyAdapter.setHasStableIds(true);

        return dummyAdapter;
    }

    public ArrayList<DummyItem> createNextDummyItems(){
        return swaped?createDummyItems():createDummyItems2();
    }

    public ArrayList<DummyItem> createDummyItems() {
        ArrayList<DummyItem> dummyItemArrayList = new ArrayList<DummyItem>();
        for (int i = 0; i < DUMMY_COUNT; i++) {
            if (i % 7 == 0) {
                //skip all 3 item
                continue;
            }
            dummyItemArrayList.add(new DummyItem(i, "Item " + i,randomColor()));
        }
        return dummyItemArrayList;
    }

    public ArrayList<DummyItem> createDummyItems2() {
        ArrayList<DummyItem> dummyItemArrayList = new ArrayList<DummyItem>();
        for (int i = 0; i < DUMMY_COUNT; i++) {
            dummyItemArrayList.add(new DummyItem(i, "Item " + i,randomColor()));
        }
        return dummyItemArrayList;
    }

    private void swapAdapter() {
        if (null != recyclerView) {
            recyclerView.swapAdapter(createNewAdapter(), false);
            swaped = !swaped;
        }
    }

    public void setList(){

        if (null != recyclerView && recyclerView.getAdapter() instanceof DummyAdapter) {
            ((DummyAdapter)recyclerView.getAdapter()).setDummyItemArrayList(createNextDummyItems());
            swaped=!swaped;
        }
    }

    public int randomColor() {
        int alpha = (int) (0xff * Math.random());
        int r = (int) (0xff * Math.random());
        int g = (int) (0xff * Math.random());
        int b = (int) (0xff * Math.random());

        return Color.argb(alpha, r, g, b);
    }
}
