class Solution {
    class Coord {
        int x;
        int y;
        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;  // Same object
            if (o == null || getClass() != o.getClass()) return false;
            
            Coord coord = (Coord) o;
            return x == coord.x && y == coord.y;  // Compare actual values
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);  // Generate hash based on x and y
        }
    }
    char[][] board;
    String word;
    HashSet<Coord> included = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        int xLen = board.length;
        if (xLen == 0 || word.length() == 0) return false;
        int yLen = board[0].length;
        for (int x = 0; x < xLen; x++) {
            for (int y = 0; y < yLen; y++) {
                int val = board[x][y];
                if (val == word.charAt(0)) {
                    if (check(new Coord(x,y), 0)) return true;
                    included.clear();
                }
            }
        }
        return false;
    }
    private boolean check(Coord start, int wordIdx) {
        int wordLen = word.length();
        int xLen = board.length;
        int yLen = board[0].length;
        if (wordIdx >= wordLen) return true;
        if (start.x < 0 || start.x >= xLen) return false;
        if (start.y < 0 || start.y >= yLen) return false;        
        if (board[start.x][start.y] != word.charAt(wordIdx)) return false;
        if (included.contains(start)) return false;
        System.out.println("start: (" + start.x + "," + start.y + ") letter:" + word.charAt(wordIdx));
        int i = 0;
        for (Coord coord : included) {
            System.out.println(i + ": (" + coord.x + "," + coord.y + ")");
            i++;
        }
        // Current char is valid, continue check
        included.add(start);
        if (check(new Coord(start.x-1, start.y), wordIdx+1)) return true;
        if (check(new Coord(start.x+1, start.y), wordIdx+1)) return true;
        if (check(new Coord(start.x, start.y-1), wordIdx+1)) return true;
        if (check(new Coord(start.x, start.y+1), wordIdx+1)) return true;
        included.remove(start);
        return false;
    }
}
