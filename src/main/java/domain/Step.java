package domain;

public class Step {
    private final boolean steppable;

    public Step(final boolean steppable) {
        this.steppable = steppable;
    }

    public boolean isSteppable() {
        return steppable;
    }

    @Override
    public String toString() {
        return "FootStep{" +
                "steppable=" + steppable +
                '}';
    }
}
