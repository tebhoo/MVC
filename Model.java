public class Model {
    private Cow[] cows;
    private int[][] milkers = new int[10][4];
    private Cow[] cowPosition = new Cow[10];
    private int cowCount = 0;

    public Model(Cow[] cows) {
        this.cows = cows;
    }

    public void nextQueue() {
        for (int i = cowCount; i < cows.length; i ++){
            int count = 0;
            for (int j = cows[i].getPreferredNumber(); count < 10; count++) {

                //check avalable machene
                if (milkers[j][0] == 0) {
                    for (int k = 0; k < milkers[0].length; k++) {
                        milkers[j][k] = 1;
                    }
                    cowPosition[j] = cows[i];
                } else {
                    j++;
                    if (j <= 10) {
                        j = 0;
                    }
                }
            }
        }
    }

    //สถานะ 0 = “ว่าง”
    //สถานะ 1 = “มีวัวอยู่”
    //สถานะ 2 = “กําลังทําความสะอาด”
    //สถานะ 3 = “เตรียมพร้อม”
    //สถานะ 4 = “กําลังรีดนม”

    public void processing(){
        for (int i = 0; i < milkers.length; i ++) {
            if (checkIfTheCowIsValid(cows[i])) break;
            for(int j = 0; j < milkers[i].length; j++){
                if (milkers[i][j] == 1) undderCleaning(i, j);
                break;
            }
        }
    }

    private void undderCleaning(int position, int udder){

        //เปลี่ยนสถานะเป็น กำลังทำความสะอาด
        milkers[position][udder] = 2;
    }

    private boolean checkIfTheCowIsValid(Cow cow) {
        if (cow.sex == 'm') return false;
        return true;
    }
}
