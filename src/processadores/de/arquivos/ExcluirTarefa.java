package processadores.de.arquivos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static processadores.de.arquivos.CriarTarefa.ler;

public class ExcluirTarefa {
    public static void excluirTarefa(String arquivo, String menu) {
        boolean operacaoCancelada = false;
        int escolhaMenu;
        System.out.println(menu);
        List<String> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        while (true) {
            escolhaMenu = Integer.parseInt(ler.nextLine());
            if (escolhaMenu == 0) {
                System.out.println("Operação cancelada pelo usuário\n");
                operacaoCancelada = true;
                break;
            } else if (escolhaMenu >= 1 && escolhaMenu < linhas.size()) {
                linhas.remove(escolhaMenu);
                System.out.println("Removido com sucesso");
                break;
            } else if (escolhaMenu <= -1 || escolhaMenu >= linhas.size()){
                System.out.println("Número de linha inválido!\n" +
                        "Escolha uma linha válida ou cancele a operação");
                System.out.println(menu);
            }
        }

        if (!operacaoCancelada) {
            try (BufferedWriter br = new BufferedWriter(new FileWriter(arquivo))) {
                for (String linha : linhas) {
                    br.write(linha);
                    br.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
