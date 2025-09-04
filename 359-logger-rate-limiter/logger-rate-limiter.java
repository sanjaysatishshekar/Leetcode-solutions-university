class Logger {
    Map<String, Integer> table;
    public Logger() {
        table = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!table.containsKey(message)){
            table.put(message, timestamp + 10);
            return true;
        }
        int time = table.get(message);
        if (timestamp >= time){ table.put(message, timestamp + 10); return true;}
        return false;
        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */