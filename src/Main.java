import java.util.*;

//Paz,Aaron Philip G.
//Nagloloko po siya sir pag nag enter lang ng 2 recipe pero pag 3 po okay naman:))


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int matrix = sc.nextInt();
        System.out.print("Enter how many order: ");
        int numRecipes = sc.nextInt();
      
      
        char[][] arr = new char[matrix][matrix]; 
        sc.nextLine();
     
     System.out.println("-------------------------");
     System.out.println("Enter the locations");
          System.out.println("-------------------------");
     
     
      //This is the entring the rows.
        for(int i = 0; i<matrix; i++){
            String row = sc.nextLine();
            
            for(int j =0; j<matrix; j++){
                
                arr[i][j] = row.charAt(j);
            }
        }

        //This will initiate the distances by -1 means 0.
        int [][] distances = new int[matrix][matrix]; 
        
        for (int i = 0; i < matrix; i++){ 
            for (int j = 0; j < matrix; j++){ 
                distances[i][j] =-1;
           
        
            }
            
        }
        //Initialize the store.
        Queue <int[]> queue = new LinkedList<int[]>();
        
        for (int i = 0; i < matrix; i++) { 
       
         for (int j = 0; j < matrix; j++) { 
            if (arr[i][j] == '#') { // shop location.
               queue.add(new int[]{i, j}); //It will add the location of the store.
                    distances[i][j] = 0; //it will be zero.
              }
        }
     }

        int[] row1 = {-1, 0, 1, 0}; // this is how the rows and column move left right up down.
        int[] comlumn = {0, 1, 0, -1};
                                    
        while (!queue.isEmpty()) { // it will ru until the queu is not empty
            int[] current = queue.poll(); //traversal loop
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) { // this block of code is the bfs traversal. checking if ingredients is visited or not
                int nx = x + row1[i];
                int ny = y + comlumn[i];

                if (nx >= 0 && nx < matrix && ny >= 0 && ny < matrix && distances[nx][ny] == -1) { 
                    distances[nx][ny] = distances[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        // This block of code read the recipes and calculating the total
        for (int i = 0; i < numRecipes; i++) {
            
            System.out.print("");
            System.out.print("\nEnter a recipe: ");
            String recipe = sc.nextLine();
         
            int total = 0;

            for (char ingredient : recipe.toCharArray()){
                int index = "MBTSP".indexOf(ingredient);
                int x = -1;
                int y = -1;

                for (int j = 0; j < matrix; j++){  
                    for (int k = 0; k < matrix; k++){  
                        if (arr[j][k] == ingredient){
                 x = j;
                 y = k;
                 break;
                        }
                    }
                }

                if (x != -1 && y != -1) {
                    total += distances[x][y];
                }
            }
//}
            System.out.print("The total is: " + total);
        }
    }
}