package domain;

import util.BooleanGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> lines;
    private final BooleanGenerator booleanGenerator;

    public Ladder(final List<Line> liens){
        this.lines = liens;
        this.booleanGenerator = null;
    }

    public int getLineHeight() {
        return this.lines.size();
    }

    public int getWidth() {
        if(this.lines.isEmpty()){
            return 0;
        }

        return this.lines
                .get(0)
                .getWidth();
    }

    public List<List<Boolean>> getLadderShape() {
        return lines.stream()
                .map(Line::getRightConnectionCondition)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                ", booleanGenerator=" + booleanGenerator +
                '}';
    }
}
