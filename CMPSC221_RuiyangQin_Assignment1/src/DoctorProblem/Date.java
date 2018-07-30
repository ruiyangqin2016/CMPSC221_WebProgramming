package DoctorProblem;

public class Date {
    //
    //  instance data
    private String month;
    private Integer day;
    private Integer year;

    public Date(String month, Integer day, Integer year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date)) return false;

        Date date = (Date) o;

        if (getMonth() != null ? !getMonth().equals(date.getMonth()) : date.getMonth() != null) return false;
        if (getDay() != null ? !getDay().equals(date.getDay()) : date.getDay() != null) return false;
        return getYear() != null ? getYear().equals(date.getYear()) : date.getYear() == null;
    }

    @Override
    public int hashCode() {
        int result = getMonth() != null ? getMonth().hashCode() : 0;
        result = 31 * result + (getDay() != null ? getDay().hashCode() : 0);
        result = 31 * result + (getYear() != null ? getYear().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Date{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }

    public String printDate() {
        return String.format("%d/%d/%d", month, day, year);
    }

    public String printEuroDate() {
        return String.format("%d/%d/%d", day, month, year);
    }
}
