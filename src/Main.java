import java.util.ArrayList;
import java.util.Scanner;

class CarteiraDigital {
    private double saldo;
    private ArrayList<String> historico;

    public CarteiraDigital() {
        this.saldo = 0.0;
        this.historico = new ArrayList<>();
    }

    public void adicionarSaldo(double valor) {
        if (valor > 0) {
            saldo += valor;
            historico.add("Adicionado: +" + valor);
            System.out.println("Saldo de " + valor + " adicionado com sucesso!");
        } else {
            System.out.println("Valor inválido. Tente novamente.");
        }
    }

    public void realizarPagamento(double valor) {
        if (valor > 0) {
            if (valor <= saldo) {
                saldo -= valor;
                historico.add("Pagamento: -" + valor);
                System.out.println("Pagamento de " + valor + " realizado com sucesso!");
            } else {
                System.out.println("Saldo insuficiente para realizar o pagamento.");
            }
        } else {
            System.out.println("Valor inválido. Tente novamente.");
        }
    }

    public void verificarSaldo() {
        System.out.println("Seu saldo atual é: " + saldo);
    }

    public void historicoTransacoes() {
        System.out.println("Histórico de Transações:");
        for (String transacao : historico) {
            System.out.println(transacao);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarteiraDigital carteira = new CarteiraDigital();

        System.out.println("Bem-vindo à sua Carteira Digital!");

        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o valor para adicionar ao saldo: ");
                    double valorAdicionar = scanner.nextDouble();
                    carteira.adicionarSaldo(valorAdicionar);
                }
                case 2 -> {
                    System.out.print("Digite o valor do pagamento: ");
                    double valorPagamento = scanner.nextDouble();
                    carteira.realizarPagamento(valorPagamento);
                }
                case 3 -> carteira.verificarSaldo();
                case 4 -> {
                    System.out.println("Obrigado por usar a sua Carteira Digital!");
                    scanner.close();
                    return;
                }
                case 5 -> carteira.historicoTransacoes();
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Adicionar Saldo");
        System.out.println("2 - Realizar Pagamento");
        System.out.println("3 - Verificar Saldo");
        System.out.println("4 - Sair");
        System.out.println("5 - Ver Histórico de Transações");
        System.out.print("Usuário: ");
    }
}
