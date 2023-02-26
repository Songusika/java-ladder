package domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Names {

    public static final int MAX_SIZE = 10;
    public static final int MIN_SIZE = 2;
    public static final String INVALID_NAMES_SIZE_ERROR_MESSAGE = "최소 " + MIN_SIZE + "명이상 최대 " + MAX_SIZE + "명 이하 참가자가 필요합니다.";
    public static final String DUPLICATED_ERROR_MESSAGE = "중복된 사람은 참여할 수 없습니다.";

    private final List<Name> names;

    public Names(final List<String> names) {
        validateNames(names);
        this.names = createNames(names);
    }

    private List<Name> createNames(final List<String> names) {
        return names.stream().map(Name::new)
                .collect(Collectors.toList());
    }

    private static void validateNames(final List<String> names) {
        validateNamesSize(names);
        validateDuplicated(names);
    }

    private static void validateNamesSize(final List<String> names) {
        if (names.size() < MIN_SIZE || names.size() > MAX_SIZE) {
            throw new IllegalArgumentException(INVALID_NAMES_SIZE_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicated(final List<String> names) {
        names.forEach(target -> {
            if (hasDuplication(names, target)) {
                throw new IllegalArgumentException(DUPLICATED_ERROR_MESSAGE);
            }
        });
    }

    private static boolean hasDuplication(final List<String> names, String target) {
        return (Collections.frequency(names, target) > 1);
    }

    public int count() {
        return this.names.size();
    }

    public List<Name> getNames() {
        return List.copyOf(names);
    }

    @Override
    public boolean equals(Object names) {
        if (this == names) return true;
        if (names == null || getClass() != names.getClass()) return false;
        Names anotherNames = (Names) names;
        return this.names.equals(anotherNames.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }

    @Override
    public String toString() {
        return "Names{" +
                "names=" + names +
                '}';
    }
}
