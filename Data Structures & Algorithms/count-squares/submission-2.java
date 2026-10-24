class CountSquares {
    HashMap<Integer, HashMap<Integer, Integer>> pointsX = new HashMap<>();
    HashMap<Integer, HashMap<Integer, Integer>> pointsY = new HashMap<>();

    public CountSquares() { }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        // If key 'x' isn't there, create a new HashMap, insert it, and return it
        HashMap<Integer, Integer> pointsOnX = pointsX.computeIfAbsent(x, k -> new HashMap<>());

        // getOrDefault handles the "if exists increment, else set to 1" check
        pointsOnX.put(y, pointsOnX.getOrDefault(y, 0) + 1);

        // If key 'y' isn't there, create a new HashMap, insert it, and return it
        HashMap<Integer, Integer> pointsOnY = pointsY.computeIfAbsent(y, k -> new HashMap<>());

        // getOrDefault handles the "if exists increment, else set to 1" check
        pointsOnY.put(x, pointsOnY.getOrDefault(x, 0) + 1);
    }
    
    public int count(int[] point) {
        int count = 0;
        int x = point[0]; //2
        int y = point[1]; //1

        HashMap<Integer, Integer> pointsOnX; // 2, 3
        HashMap<Integer, Integer> pointsOnY; // 0, 1

        if (!pointsX.containsKey(x)) {
            return 0;
        } else {
            pointsOnX = pointsX.get(x);
        }

        if (!pointsY.containsKey(y)) {
            return 0;
        } else {
            pointsOnY = pointsY.get(y);
        }

        for (Map.Entry<Integer, Integer> entry : pointsOnX.entrySet()) {
            int mult = entry.getValue();;
            int multr = mult;
            int multl = mult;
            int x2 = x;
            int y2 = entry.getKey();
            HashMap<Integer, Integer> pointsOnY2 = pointsY.get(y2);
            if (y == y2) continue;
            int diff = Math.abs(y - y2);

            int rightX = x + diff;
            if (pointsOnY.containsKey(rightX) && pointsOnY2.containsKey(rightX)) {
                multr *= pointsOnY.get(rightX);
                multr *= pointsOnY2.get(rightX);
                count += multr;
            }

            int leftX = x - diff;
            if (pointsOnY.containsKey(leftX) && pointsOnY2.containsKey(leftX)) {
                multl *= pointsOnY.get(leftX);
                multl *= pointsOnY2.get(leftX);
                count += multl;
            }
        }

        return count;
    }
}