public class OffByN implements CharacterComparator{
    private int cha;
    OffByN(int N) {
        cha = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if(Math.abs(x-y)==cha) {
            return true;
        }
        return false;
    }
}
