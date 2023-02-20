package controller;

import domain.Height;
import domain.Ladder;
import domain.Name;
import domain.Names;
import util.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    public void run() {
        Names names = getNames();
        Height height = getHeight();

        Ladder ladder = buildLadder(names, height);

        printResult(names, ladder);
    }

    private Ladder buildLadder(final Names names, final Height height) {
        Ladder ladder = new Ladder(new RandomBooleanGenerator());
        ladder.build(height, names.count());
        return ladder;
    }

    private static void printResult(final Names names, final Ladder ladder) {
        OutputView.printResult(names, ladder);
    }


    private Names getNames() {
        try {
            OutputView.printRequestNames();
            return new Names(Name.of(InputView.getNames()));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getNames();
        }
    }

    private Height getHeight() {
        try {
            OutputView.printRequestLadderHeight();
            return new Height(InputView.getHeight());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getHeight();
        }
    }
}
