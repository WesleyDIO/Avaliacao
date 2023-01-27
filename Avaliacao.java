import java.util.Scanner;
public class sudoku {
	public static void main(String[] args) {
	    Scanner entrada = new Scanner(System.in);
	    System.out.println("Digite quantos jogadores iram participar: ");
	    int numJogadores = entrada.nextInt();
	    String[] nomesJogadores = new String[numJogadores];
	    int[][][] matrizesJogadores = new int[numJogadores][9][9];
	    for (int i = 0; i < numJogadores; i++) {
	    	System.out.println("Digite o nome de cada jogador: ");
	        nomesJogadores[i] = entrada.next();
	        
	        for (int j = 0; j < 9; j++) {
	            for (int k = 0; k < 9; k++) {
	            	System.out.println("Digite o valor da linha "+ (j+1)+ " Na coluna "+(k+1)+": ");
	                matrizesJogadores[i][j][k] = entrada.nextInt();
	                
	            }
	        }
	    }
	    
		    for (int i = 0; i < numJogadores; i++) {
		    	System.out.println("\nTabela do Jogador: "+nomesJogadores[i]);
		    	System.out.println("============================================");
		        for (int j = 0; j < 9; j++) {
		        	for(int k = 0; k < 9; k++) {
		            System.out.print(matrizesJogadores[i][j][k] + "");
		        }
		       System.out.println("");
		        }
		    }
		    System.out.println("================================================");
		
	    for (int i = 0; i < numJogadores; i++) {
	        System.out.print("Sudoku " + (i+1) + ": " + nomesJogadores[i] + " ");
	        if (verificaSudoku(matrizesJogadores[i])) {
	            System.out.println("SIM");
	        } else {
	            System.out.println("NÃO");
	        }
	    }
	}
	
	public static boolean verificaSudoku(int[][] matriz) {
	    return verificaLinhas(matriz) && verificaColunas(matriz) && verificaRegioes(matriz);
	}
	
	public static boolean verificaLinhas(int[][] matriz) {
	    for (int i = 0; i < 9; i++) {
	        boolean[] check = new boolean[9];
	        for (int j = 0; j < 9; j++) {
	            if (matriz[i][j] < 1 || matriz[i][j] > 9) {
	                return false;
	            }
	            if (check[matriz[i][j] - 1]) {
	                return false;
	            }
	            check[matriz[i][j] - 1] = true;
	        }
	    }
	    return true;
	}
	
	public static boolean verificaColunas(int[][] matriz) {
	    for (int i = 0; i < 9; i++) {
	        boolean[] check = new boolean[9];
	        for (int j = 0; j < 9; j++) {
	            if (matriz[j][i] < 1 || matriz[j][i] > 9) {
	                return false;
	            }
	            if (check[matriz[j][i] - 1]) {
	                return false;
	            }
	            check[matriz[j][i] - 1] = true;
	        }
	    }
	    return true;
	}

	public static boolean verificaRegioes(int[][] matriz) {
	    for (int i = 0; i < 9; i += 3) {
	        for (int j = 0; j < 9; j += 3) {
	            boolean[] check = new boolean[9];
	            for (int k = i; k < i + 3; k++) {
	                for (int l = j; l < j + 3; l++) {
	                    if (matriz[k][l] < 1 || matriz[k][l] > 9) {
	                        return false;
	                    }
	                    if (check[matriz[k][l] - 1]) {
	                        return false;
	                    }
	                    check[matriz[k][l] - 1] = true;
	                }
	            }
	        }
	    }
	    return true;
	}
	 
     }
