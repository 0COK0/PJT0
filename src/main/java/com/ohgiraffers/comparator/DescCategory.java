package com.ohgiraffers.comparator;

import com.ohgiraffers.test.model.dto.BookDTO;

import java.util.Comparator;

public class DescCategory implements Comparable<DescCategory> {
    private int category;

    @Override
    public int compareTo(DescCategory o) {
        // 카테고리 순으로 내림차순 정렬
        return Integer.compare(o.category, this.category);
    }
}
