class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] mincoins=new int[amount+1];
        Arrays.fill(mincoins,amount+1);
        mincoins[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0; j < coins.length;j++){
                if(i-coins[j]>=0){
                    mincoins[i]=Math.min(mincoins[i],1+mincoins[i-coins[j]]);
                }
            }
        }
        return mincoins[amount]!=amount+1?mincoins[amount]:-1;
    }
}