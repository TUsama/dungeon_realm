package com.robertx22.dungeon_realm.structure;

public class HasDoneData {

    public int total = 0;
    public int done = 0;

    // remember not to call if all rooms aren't done genning
    public int getPercentDone() {
        if (done >= total) {
            return 100; // in case there's fucky floating point shit happening
        }
        return (int) (((float) done / (float) total) * 100);
    }
}

