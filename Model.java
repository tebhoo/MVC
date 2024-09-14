public class Model {
    private Cow[] cows;
    private int[][] milkers = new int[10][4];
    private Cow[] cowPosition = new Cow[10];
    private int cowCount = 0;
    public long milksL = 0;

    public Model(Cow[] cows) {
        this.cows = cows;
    }

    public void nextQueue() {
        for (int i = cowCount; i < cows.length; i ++){
            boolean dontHaveSpace = true;
            int count = 0;
            for (int j = cows[i].getPreferredNumber(); count < 10; count++) {
                //check avalable machene
                if (milkers[j][0] == 0) {
                    for (int k = 0; k < milkers[0].length; k++) {
                        milkers[j][k] = 1;
                    }
                    cowPosition[j] = cows[i];
                    dontHaveSpace = false;
                    break;

                } else {
                    j++;
                    if (j == 10) {
                        j = 0;
                    }
                }
            }
            if (dontHaveSpace) {
                break;
            }
            cowCount++;
            System.out.println(i);
        }
    }

    //สถานะ 0 = “ว่าง”
    //สถานะ 1 = “มีวัวอยู่”
    //สถานะ 2 = “กําลังทําความสะอาด”
    //สถานะ 3 = “เตรียมพร้อม”
    //สถานะ 4 = “กําลังรีดนม”

    public void processing(){
        for (int i = 0; i < milkers.length; i ++) {
            if (!checkIfTheCowIsValid(cows[i])) continue;
            loop:
            for(int j = 0; j < milkers[i].length; j++){

                switch (milkers[i][j]) {
                    case 1:
                        undderCleaning(i, j);
                        break loop;

                    case 2:
                        preparing(i, j);
                        break loop;

                }

                if (j == 3 && milkers[i][j] == 3) {
                    milking(i);
                    System.out.println("asdasdasdasdasd");
                } 

                else if (milkers[i][j] == 4) doneMilking(i);
            }
        }
    }

    private void undderCleaning(int position, int udder) {
        //เปลี่ยนสถานะเป็น กำลังทำความสะอาด
        milkers[position][udder] = 2;

        System.out.println("clean");
    }

    private void preparing(int position, int udder) {
        //เปลี่ยนสถานะเป็น เตรียมพร้อม
        milkers[position][udder] = 3;
        System.out.println("preparing");
    }

    private void milking(int position) {
        //เปลี่ยนสถานะเป็น กําลังรีดนม
        for (int i = 0; i < milkers[position].length; i++) {
            milkers[position][i] = 4;
        }
        System.out.println("milking");
    }

    private void doneMilking(int position) {
        //รีดนมเสร็จ
        if (cowPosition[position].getPreferredNumber() == position) {
            milksL++;
        } else milksL += 0.5;
        //นำวัวออก
        for (int i = 0; i < milkers[position].length; i++) {
            milkers[position][i] = 0;
        }

        System.out.println("done");
    }

    private boolean checkIfTheCowIsValid(Cow cow) {
        if (cow.sex == 'm') return false;
        return true;
    }
}
