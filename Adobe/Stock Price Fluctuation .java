class StockPrice {
    TreeSet<Integer> times;  
    HashMap<Integer, Integer> prices;  
    int maxTimestamp;

    public StockPrice() {
        prices = new HashMap<>();
        times = new TreeSet<>((a, b) -> prices.get(a) - prices.get(b)); 
    }
    public void update(int timestamp, int price) {
        if (prices.containsKey(timestamp))
            times.remove(timestamp);
        
        prices.put(timestamp, price);
        maxTimestamp = Math.max(maxTimestamp, timestamp);
        times.add(timestamp);
    }
    public int current() {
        return prices.get(maxTimestamp);
    }
    public int maximum() {
        return prices.get(times.last());
    }
    public int minimum() {
        return prices.get(times.first());
    }
}