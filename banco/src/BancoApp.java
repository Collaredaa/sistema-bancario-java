import java.util.*;

public class BancoApp {
    private static List<Conta> contas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- Banco Java ---");
            System.out.println("1. Criar conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Listar contas");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> criarConta();
                case 2 -> depositar();
                case 3 -> sacar();
                case 4 -> transferir();
                case 5 -> listarContas();
            }
        } while (opcao != 0);
    }

    private static void criarConta() {
        scanner.nextLine();
        System.out.print("Nome do titular: ");
        String nome = scanner.nextLine();
        Conta nova = new Conta(nome);
        contas.add(nova);
        System.out.println("Conta criada: " + nova);
    }

    private static Conta buscarConta(int numero) {
        return contas.stream()
                .filter(c -> c.getNumeroConta() == numero)
                .findFirst()
                .orElse(null);
    }

    private static void depositar() {
        System.out.print("Número da conta: ");
        int num = scanner.nextInt();
        Conta conta = buscarConta(num);
        if (conta != null) {
            System.out.print("Valor: ");
            conta.depositar(scanner.nextDouble());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void sacar() {
        System.out.print("Número da conta: ");
        int num = scanner.nextInt();
        Conta conta = buscarConta(num);
        if (conta != null) {
            System.out.print("Valor: ");
            boolean sucesso = conta.sacar(scanner.nextDouble());
            if (!sucesso) System.out.println("Saldo insuficiente.");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void transferir() {
        System.out.print("Conta origem: ");
        Conta origem = buscarConta(scanner.nextInt());
        System.out.print("Conta destino: ");
        Conta destino = buscarConta(scanner.nextInt());
        if (origem != null && destino != null) {
            System.out.print("Valor: ");
            boolean sucesso = origem.transferir(destino, scanner.nextDouble());
            if (!sucesso) System.out.println("Saldo insuficiente.");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void listarContas() {
        contas.forEach(System.out::println);
    }
}

