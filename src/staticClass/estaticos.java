package staticClass;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class estaticos {
	
	private static Scanner input = new Scanner(System.in);
	private static List <String> arq_saves = new ArrayList<String>();
	private static String arq;
	private static String src;
	
	
	public static void limpaTela() {
		
		for (int cont = 0; cont < 100; cont++) {
			
			System.out.println();
			
		}
		
	}
	
	public static void SistemaMedias() throws IOException {
		
		int op = 0;
		
		do {
			
			if (arq_saves.isEmpty() == false) {
					
					System.out.println("***************** SISTEMA DE NOTAS DE ALUNOS *****************");
					System.out.println("**************************************************************");
					System.out.println("*********            1 - Registrar notas             *********");
					System.out.println("*********      2 - Registrar em arquivos salvos      *********");
					System.out.println("*********                9 - Sair                    *********");
					System.out.println("**************************************************************");
					System.out.println("**************************************************************");
					System.out.print("********* Digite uma opção: ");
					op = input.nextInt(); 
					
					if(op == 1) {
						
						input.nextLine();
						nomeArquivo();
						
					}else if(op == 2) {
						
						arquivosSalvos();
						
					} else if (op != 9) {
						
						System.out.println("Opção Inválida");
						
					}
					
					limpaTela();
				
			} else if (arq_saves.isEmpty() == true) {
					
					System.out.println("***************** SISTEMA DE NOTAS DE ALUNOS ******************");
					System.out.println("***************************************************************");
					System.out.println("*********            1 - Registrar notas             **********");
					System.out.println("*********                9 - Sair                    **********");
					System.out.println("***************************************************************");
					System.out.println("***************************************************************");
					System.out.print("********* Digite uma opção: ");
					op = input.nextInt(); 
					
					if(op == 1) {
						
						input.nextLine();
						nomeArquivo();
						
					}else if(op != 9) {
						
						System.out.printf("Opção Inválida\n");
						
					}
					
					limpaTela();
				
			}
			
		} while (op != 9); 
	
	}
	
	public static void nomeArquivo() throws IOException{
		
		System.out.println("********** Digite o nome do arquivo que deja salvar **********");
		arq = input.nextLine();
		src = String.format("//home//derekwillyan//Área de Trabalho//%s.txt", arq);
		arq_saves.add(arq);
		enumQuantidadeNotas();
		
	}
	
	public static void proccedureArquivoSalvo(String arq) throws IOException {
		
		src = String.format("//home//derekwillyan//Área de Trabalho//%s.txt", arq);
		enumQuantidadeNotas();
		
	}

	public static void arquivosSalvos() throws IOException {
		
		System.out.println("***************** Arquivos Salvos *****************");

		for (int cont = 0; cont < arq_saves.size(); cont++) {
			
			System.out.printf("%d, %s\n", cont+1, arq_saves.get(cont));
			
		}
		
		System.out.println("***** Digite a opção: ");
		int op_arq = input.nextInt();
		
		for (int cont = 0; cont < arq_saves.size(); cont++) {
			
			if ((op_arq-1) == arq_saves.indexOf(arq_saves.get(cont))) {
				
				proccedureArquivoSalvo(arq);
				
			}
			
		}
		
	}
	

	
	public static void enumQuantidadeNotas() throws IOException {

		System.out.printf("******* Digite a quantidade de notas para registro *******\n");
		int num = input.nextInt();
		limpaTela();
		RegistrarNotas(num);
	
	}
	
	public static void RegistrarNotas(int quant_notas) throws IOException {
		
		double[] notas = new double[quant_notas];
		double soma = 0;
		
		for (int cont = 0; cont < notas.length; cont ++) {
			System.out.printf("********** Digite a nota %d **********\n", cont+1);
			notas[cont] = input.nextDouble();
			soma += notas[cont]; 
		}
		
		medias(soma, quant_notas);
		
	}
	
	public static void medias(double soma, int quant_notas) throws IOException {

		String situ = "";
		double media = soma/quant_notas;
		System.out.printf("Feito!!!!\n");
		
		if (media >= 7) {

			situ = "Aprovado";
			
		} else if (media >= 4) {
			
			situ = "Recuperação";
			
		} else if (media < 4) {
			
			situ = "Reprovado";
			
		}
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(src, true))){
		
			bw.write(String.format("Média: %.2f, %s", media, situ));
			bw.newLine();
			
		} 
		catch(IOException e){
		
			System.out.println("ERROR");
			
		}
	
	}	

}
