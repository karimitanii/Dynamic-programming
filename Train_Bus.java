package cp3;

public class Train_Bus {
	public static void main(String[] args) {
        int[] trainPrices = {5, 100, 5, 100, 5};
        int[] busPrices = {100, 5, 100, 5, 100};
        int n = trainPrices.length;  
        int switchCost = 10;
        
        int[] dp = new int[n];
        int cost = 0;
        boolean onTrain = false;  // Boolean used for logic control flow
        
        if(trainPrices[0] < busPrices[0]){
            cost = trainPrices[0];
            onTrain = true;
        } 
        else if(trainPrices[0] > busPrices[0]){
            cost = busPrices[0];
            onTrain = false;
        } 
        
        else{  // trainPrices[0] == busPrices[0]
            if (trainPrices[1] > busPrices[1]){
                cost = busPrices[0];  // choose bus
                onTrain = false;
            } 
            else{
                cost = trainPrices[0];  // choose train
                onTrain = true;
            }
        }
        
        dp[0] = cost;
        
        // Process the rest of the stations
        for(int i = 1; i < n; i++){
            if(onTrain){
            	
                if(trainPrices[i] > busPrices[i] + switchCost){
                    cost += switchCost + busPrices[i];
                    onTrain = false;
                } 
                else{
                    cost += trainPrices[i];
                }
            } 
            else{
                
            	if (busPrices[i] > trainPrices[i] + switchCost){
                    cost += switchCost + trainPrices[i];
                    onTrain = true;
                } 
            	
            	else{
                    cost += busPrices[i];
                }
            }
            
            dp[i] = cost;
        }
        
        for (int i = 0; i < n; i++){
            int res = dp[i];
        	System.out.print(res + " ");
        }
        System.out.println();

    	System.out.println("Suzie Q can reach her final destination by paying " + dp[n-1]+ " dollars!");

    }

}
