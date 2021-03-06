package kyu5.Pagination;

import java.util.List;

public class PaginationHelper<I> {

    private List<I> collection;

    private int itemsPerPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
        this.collection = collection;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return itemCount() / itemsPerPage + 1;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex >= pageCount() || pageIndex < 0) {
            return -1;
        }
        if (pageIndex == pageCount() - 1) {
            return collection.size() % itemsPerPage;
        } else return itemsPerPage;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        System.out.println(itemIndex);
        if (itemIndex > collection.size() ||itemIndex < 0 || collection.isEmpty()) {
            return -1;
        }
        return (itemIndex / itemsPerPage - 1) + 1;
    }
}
