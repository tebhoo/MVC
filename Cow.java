public class Cow {
    char sex;
    int udderAmount = 0;
    int preferredNumber;

    public Cow(char sex, int udder, int preferredNumber) {
        this.sex = sex;
        if (sex == 'f') {
            udderAmount = udder;
        }
        this.preferredNumber = preferredNumber;
    }

    public int getPreferredNumber() {
        return preferredNumber;
    }
}
