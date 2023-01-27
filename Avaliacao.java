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
	            	tabela(matrizesJogadores);
	            	System.out.println("Digite o valor da linha "+ (j+1)+ " Na coluna "+(k+1)+": ");
	                matrizesJogadores[i][j][k] = entrada.nextInt();
	                
	            }
	        }
	    }
	    
		    for (int i = 0; i < numJogadores; i++) {
		    	System.out.println("\nTabela do Jogador: "+nomesJogadores[i]);
		    	System.out.println("================================================================");
		        for (int j = 0; j < 9; j++) {
		        	for(int k = 0; k < 9; k++) {
		            System.out.print(" | "+matrizesJogadores[i][j][k] + " | ");
		        }
		       System.out.println("*");
		        }
		    }
		    System.out.println("====================================================================");
		
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
	 public static void tabela (int[][][] matrizesJogadores) {
		
	        System.out.println(" | "+matrizesJogadores[0][0][0]+" "+matrizesJogadores[0][0][1]+" "+matrizesJogadores[0][0][2]+" | "+matrizesJogadores[0][0][3]+" "+matrizesJogadores[0][0][4]+" "+matrizesJogadores[0][0][5]+" | "+matrizesJogadores[0][0][6]+" "+matrizesJogadores[0][0][7]+" "+matrizesJogadores[0][0][8]+" | ");
	        System.out.println(" | "+matrizesJogadores[0][1][0]+" "+matrizesJogadores[0][1][1]+" "+matrizesJogadores[0][1][2]+" | "+matrizesJogadores[0][1][3]+" "+matrizesJogadores[0][1][4]+" "+matrizesJogadores[0][1][5]+" | "+matrizesJogadores[0][1][6]+" "+matrizesJogadores[0][1][7]+" "+matrizesJogadores[0][1][8]+" | ");
	        System.out.println(" | "+matrizesJogadores[0][2][0]+" "+matrizesJogadores[0][2][1]+" "+matrizesJogadores[0][2][2]+" | "+matrizesJogadores[0][2][3]+" "+matrizesJogadores[0][2][4]+" "+matrizesJogadores[0][2][5]+" | "+matrizesJogadores[0][2][6]+" "+matrizesJogadores[0][2][7]+" "+matrizesJogadores[0][2][8]+" | ");
	        System.out.println("  -----------------------");
	        System.out.println(" | "+matrizesJogadores[0][3][0]+" "+matrizesJogadores[0][3][1]+" "+matrizesJogadores[0][3][2]+" | "+matrizesJogadores[0][3][3]+" "+matrizesJogadores[0][3][4]+" "+matrizesJogadores[0][3][5]+" | "+matrizesJogadores[0][3][6]+" "+matrizesJogadores[0][3][7]+" "+matrizesJogadores[0][3][8]+" | ");
	        System.out.println(" | "+matrizesJogadores[0][4][0]+" "+matrizesJogadores[0][4][1]+" "+matrizesJogadores[0][4][2]+" | "+matrizesJogadores[0][4][3]+" "+matrizesJogadores[0][4][4]+" "+matrizesJogadores[0][4][5]+" | "+matrizesJogadores[0][4][6]+" "+matrizesJogadores[0][4][7]+" "+matrizesJogadores[0][4][8]+" | ");
	        System.out.println(" | "+matrizesJogadores[0][5][0]+" "+matrizesJogadores[0][5][1]+" "+matrizesJogadores[0][5][2]+" | "+matrizesJogadores[0][5][3]+" "+matrizesJogadores[0][5][4]+" "+matrizesJogadores[0][5][5]+" | "+matrizesJogadores[0][5][6]+" "+matrizesJogadores[0][5][7]+" "+matrizesJogadores[0][5][8]+" | ");
	        System.out.println("  -----------------------");
	        System.out.println(" | "+matrizesJogadores[0][6][0]+" "+matrizesJogadores[0][6][1]+" "+matrizesJogadores[0][6][2]+" | "+matrizesJogadores[0][6][3]+" "+matrizesJogadores[0][6][4]+" "+matrizesJogadores[0][6][5]+" | "+matrizesJogadores[0][6][6]+" "+matrizesJogadores[0][6][7]+" "+matrizesJogadores[0][6][8]+" | ");
	        System.out.println(" | "+matrizesJogadores[0][7][0]+" "+matrizesJogadores[0][7][1]+" "+matrizesJogadores[0][7][2]+" | "+matrizesJogadores[0][7][3]+" "+matrizesJogadores[0][7][4]+" "+matrizesJogadores[0][7][5]+" | "+matrizesJogadores[0][7][6]+" "+matrizesJogadores[0][7][7]+" "+matrizesJogadores[0][7][8]+" | ");
	        System.out.println(" | "+matrizesJogadores[0][8][0]+" "+matrizesJogadores[0][8][1]+" "+matrizesJogadores[0][8][2]+" | "+matrizesJogadores[0][8][3]+" "+matrizesJogadores[0][8][4]+" "+matrizesJogadores[0][8][5]+" | "+matrizesJogadores[0][8][6]+" "+matrizesJogadores[0][8][7]+" "+matrizesJogadores[0][8][8]+" | ");
	        
	    }
     }
     
