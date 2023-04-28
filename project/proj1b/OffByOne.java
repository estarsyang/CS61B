public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y){
        /** return boolean, char minus char is compute by ASCII code. 'a' - 'b' to compute is 97 - 98 */
        int offOne = Math.abs(x - y);
        return offOne == 1;
    }
}
