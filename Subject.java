package school.subject;

public enum Subject {
    LITERATURE(SubjectType.HUMANITY, 4),
    HISTORY(SubjectType.HUMANITY, 5),
    PHYSICS(SubjectType.SCIENCE, 6),
    CHEMISTRY(SubjectType.SCIENCE, 7);

    private final SubjectType subjectType;
    private final int startingYear;

    Subject(SubjectType subjectType, int startingYear) {
        this.subjectType = subjectType;
        this.startingYear = startingYear;
    }

    private SubjectType getSubjectType() {
        return subjectType;
    }

    private int getstartingYear() {
        return startingYear;
    }

}