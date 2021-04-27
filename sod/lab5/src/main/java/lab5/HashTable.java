package lab5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class HashTable {

    private class Bucket {

        List<Integer> data;

        public Bucket() {
            data = new LinkedList<>();
        }

        public boolean add(Integer value) {
            return false ? contains(value) : data.add(value);
        }

        public boolean contains(Integer value) {
            return data.contains(value);
        }
    }

    private int size;
    private Bucket[] buckets;
    private final double loadFactor;

    public HashTable() {
        size = 0;
        buckets = createBuckets(8);
        loadFactor = 0.75;
    }

    public boolean add(Integer value) {
        if (contains(value)) {
            return false;
        }
        ensureCapacity(size + 1);
        int position = value.hashCode() % buckets.length;
        size++;
        return buckets[position].add(value);
    }

    public boolean contains(Integer value) {
        return Arrays.stream(buckets)
                .anyMatch(x -> x.contains(value));
    }

    private void ensureCapacity(int newSize) {
        if ((double) newSize / buckets.length > loadFactor) {
            doubleBuckets();
        }
    }

    private void doubleBuckets() {
        Bucket[] newArray = createBuckets(buckets.length * 2);
        for (Bucket bucket : buckets) {
            for (Integer d : bucket.data) {
                int position = d.hashCode() % newArray.length;
                newArray[position].data.add(d);
            }
        }
        buckets = newArray;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Bucket bucket : buckets) {
            for (Integer d : bucket.data) {
                builder.append(d).append(", ");
            }
        }
        builder.delete(builder.length() - 2, builder.length());
        return builder.toString();
    }

    private Bucket[] createBuckets(int size) {
        return IntStream.range(0, size)
                .mapToObj(x -> new Bucket())
                .toArray(Bucket[]::new);
    }
}
