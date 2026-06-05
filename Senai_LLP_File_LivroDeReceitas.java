import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Senai_LLP_File_LivroDeReceitas {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> ingredientes = new ArrayList<>();
        ArrayList<String> quantidades = new ArrayList<>();
        ArrayList<String> passos = new ArrayList<>();

        System.out.print("Receita: ");
        String receita = sc.nextLine();

        System.out.println();

        while (true) {
            System.out.print("Ingrediente: ");
            String ingrediente = sc.nextLine();

            if (ingrediente.equals("")) {
                break;
            }

            System.out.print("Quantidade: ");
            String quantidade = sc.nextLine();

            ingredientes.add(ingrediente);
            quantidades.add(quantidade);
        }

        System.out.println();

        int cont = 1;

        while (true) {
            System.out.print("Passo " + cont + ": ");
            String passo = sc.nextLine();

            if (passo.equals("")) {
                break;
            }

            passos.add(passo);
            cont++;
        }

        String texto = "";

        texto += receita + "\n\n";

        texto += "Ingredientes:\n";

        for (int i = 0; i < ingredientes.size(); i++) {
            texto += (i + 1) + ". " + ingredientes.get(i) + " - " + quantidades.get(i) + "\n";
        }

        texto += "\n";

        texto += "Instruções:\n";

        for (int i = 0; i < passos.size(); i++) {
            texto += "Passo " + (i + 1) + ": " + passos.get(i) + "\n";
        }

        System.out.println();
        System.out.println(texto);

        String nomeArquivo = receita.replace(" ", "_") + ".txt";

        try {
            FileWriter arquivo = new FileWriter(nomeArquivo);
            arquivo.write(texto);
            arquivo.close();

            System.out.println("Arquivo salvo: " + nomeArquivo);

        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo.");
        }

        sc.close();
    }
}
