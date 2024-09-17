import java.util.Objects;

public class BoardKey {

    private final int x;
    private final int y;

    public BoardKey(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BoardKey boardKey = (BoardKey) obj;
        return x == boardKey.x && y == boardKey.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
