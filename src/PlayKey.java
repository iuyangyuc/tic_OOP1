public class PlayKey {

    private final String name;

    public PlayKey(String name) {
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
        PlayKey playKey = (PlayKey) obj;
        return name.equals(playKey.name);
    }
}
