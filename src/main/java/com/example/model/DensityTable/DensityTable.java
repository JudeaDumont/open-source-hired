package com.example.model.DensityTable;

import com.example.model.DensityTable.Members.OccurredLogic;

import java.util.Hashtable;

public class DensityTable extends OccurredLogic {

    public DensityTable(Hashtable<String, Long> ht, Long totalDensity) {
        this.ht = ht;
        this.totalDensity = totalDensity;
    }

    public DensityTable() {
        ht = new Hashtable<>();
    }
}
