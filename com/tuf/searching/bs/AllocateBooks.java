package com.tuf.searching.bs;

import java.util.ArrayList;

public class AllocateBooks {
    // given n books with pages and m students
    // distribute all books among students
    // with minimum pages

    public static int[] getMinMaxOfArray(int[] arr) {
        ArrayList<Integer> ar = new ArrayList<>();
        for (Integer ele : arr) {
            ar.add(ele);
        }
        ar.sort(null);
        int[] ans = { ar.get(0), ar.get(ar.size() - 1) };
        return ans;
    }

    public static int getSumOfArray(int[] arr) {
        int sum = 0;
        for (Integer ele : arr) {
            sum += ele;
        }
        return sum;
    }

    public static int distributeBookWithMinPages(int[] booksWithPages, int maxAllocatingPage) {
        int totalStudentHasBooks = 1;
        int totalPagesWithStudent = booksWithPages[0];
        int n = booksWithPages.length;
        for (int i = 1; i < n; i++) {
            if ((totalPagesWithStudent + booksWithPages[i]) <= maxAllocatingPage) {
                totalPagesWithStudent += booksWithPages[i];
            } else {
                totalStudentHasBooks++;
                totalPagesWithStudent = booksWithPages[i];// next student hold this book(pages)
            }
        }
        return totalStudentHasBooks;
    }

    public static int getPagesAllowcatedBrute(int[] booksWithPages, int studentCount) {
        int[] minmax = getMinMaxOfArray(booksWithPages);
        int minPage = Integer.MAX_VALUE;
        int low = minmax[1];
        int high = getSumOfArray(booksWithPages);
        for (int pages = low; pages <= high; pages++) {
            int distributedCount = distributeBookWithMinPages(booksWithPages, pages);
            if (distributedCount == studentCount)
                return pages;
        }

        return minPage;
    }

    public static int getPagesAllowcatedBS(int[] booksWithPages, int studentCount) {
        int[] minmax = getMinMaxOfArray(booksWithPages);
        int minPage = Integer.MAX_VALUE;
        int low = minmax[1];
        int high = getSumOfArray(booksWithPages);
        while (low <= high) {
            int mid = (low + high) / 2;
            int distributeCount = distributeBookWithMinPages(booksWithPages, mid);
            if (distributeCount == studentCount) {
                minPage = Math.min(minPage, mid);
                high = mid - 1;
            } else if (distributeCount > studentCount) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return minPage;// low
    }

    public static void main(String[] args) {
        int[] bookPages = { 25, 46, 28, 49, 24 };
        System.out.println("Min page Allocated Brute  " + getPagesAllowcatedBrute(bookPages, 4));
        System.out.println("Min page Allocated BS     " + getPagesAllowcatedBS(bookPages, 4));
    }
}
