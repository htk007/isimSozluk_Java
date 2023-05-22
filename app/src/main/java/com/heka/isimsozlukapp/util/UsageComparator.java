package com.heka.isimsozlukapp.util;

import com.heka.isimsozlukapp.model.Usage;

import java.util.Comparator;

public class UsageComparator implements Comparator<Usage> {
    @Override
    public int compare(Usage u1, Usage u2) {
        return u1.getUsageFull().compareTo(u2.getUsageFull());
    }
}