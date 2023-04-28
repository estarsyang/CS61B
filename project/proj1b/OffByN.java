public class OffByN implements CharacterComparator {
    private int n;

    public OffByN(int num) {
        n = num;
    }
    @Override
    public boolean equalChars(char x, char y){
        int offN = Math.abs(x - y);
        return offN == n;
    }
}

