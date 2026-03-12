class Solution {
    class Tnx {
        String name;
        int time;
        int amount;
        String city;
        public Tnx(String line) {
            String[] l = line.split(",");
            this.name = l[0];
            this.time = Integer.parseInt(l[1]);
            this.amount = Integer.parseInt(l[2]);
            this.city = l[3];
        }
    }
    public List<String> invalidTransactions(String[] transactions) {
        List<String> invalid = new ArrayList<>();
        Map<String, List<Tnx>> table = new HashMap<>();
        for (String t: transactions) {
            Tnx tnx = new Tnx(t);
            table.computeIfAbsent(tnx.name, key -> new ArrayList<>()).add(tnx);
        }

        for (String tran: transactions) {
            Tnx t = new Tnx(tran);
            if (!isValid(t, table.get(t.name)))
                invalid.add(tran);
        }
        return invalid;
    }

    public boolean isValid(Tnx t, List<Tnx> l) {
        if (t.amount > 1000) return false;
        for (Tnx ta: l) {
            if(Math.abs(ta.time - t.time) <= 60 && !ta.city.equals(t.city)){
				return false;
			} 
        }
        return true;
    }
}