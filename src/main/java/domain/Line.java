package domain;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<FootStep> footSteps = new ArrayList<>();
    private final BooleanGenerator generator;

    public Line(final BooleanGenerator generator) {
        this.generator = generator;
    }

    public boolean isSteppableAt(final int index) {
        return this.footSteps
                .get(index)
                .isSteppable();
    }

    public void generateFootStep() {
        if (!isStartEdge()) {
            FootStep previous = getPreviousFootStep();
            addFootStep(previous.isSteppable());
            return;
        }
        addFootStep(false);
    }

    private FootStep getPreviousFootStep() {
        return this.footSteps.get(this.footSteps.size() - 1);
    }

    private void addFootStep(final boolean isPreviousFootStepSteppable) {
        if (isPreviousFootStepSteppable) {
            this.footSteps.add(new FootStep(false));
            return;
        }
        this.footSteps.add(new FootStep(generator.generate()));
    }

    private boolean isStartEdge() {
        return this.footSteps.size() == 0;
    }
}
