class MedianFinder {
     PriorityQueue<Integer> maxHeap; // left (max heap)
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
         maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
         maxHeap.add(num);

        // Step 2: move largest of left → right
        minHeap.add(maxHeap.poll());

        // Step 3: balance sizes
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
         if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek(); // odd case
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0; // even case
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */