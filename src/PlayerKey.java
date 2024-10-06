public class PlayerKey {

    private final String name;

    public PlayerKey(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PlayerKey playKey = (PlayerKey) obj;
        return name.equals(playKey.name);
    }
}
