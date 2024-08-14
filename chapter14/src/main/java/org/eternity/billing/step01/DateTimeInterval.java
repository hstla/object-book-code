
public class DateTimeInterval {
    public List<DateTimeInterval> splitByDat() {
        if (days() > 0) {
            return splitByDay(days());
        }

        return Arrays.asList(this);
    }

    private long days() {
        return Duration.between(from.toLocalDate().atStartOfDay(), to.toLocalDate().atStartOfDay())
            .toDays();
    }


}