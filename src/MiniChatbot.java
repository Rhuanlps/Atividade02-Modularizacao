import java.util.Scanner;

public class MiniChatbot {

    public static void main(String[] args) {
        MiniChatbot chatbot = new MiniChatbot();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Olá! Eu sou o MiniChatbot. Como posso te ajudar hoje?");

        while (true) {
            System.out.print("Usuário: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.contains("sair")) {
                System.out.println("MiniChatbot: Tchau! Até a próxima.");
                break;
            }

            String response = chatbot.getResponse(input);
            System.out.println("MiniChatbot: " + response);
        }

        scanner.close();
    }

    public String getResponse(String input) {
        if (input.contains("olá") || input.contains("oi")) {
            return saudar();
        } else if (input.contains("nome")) {
            return dizerNome();
        } else if (input.contains("como você está") || input.contains("tudo bem")) {
            return responderEstado();
        } else {
            return respostaPadrao();
        }
    }


    private String saudar() {
        return "Olá! Como posso ajudar?";
    }

    private String dizerNome() {
        return "Eu sou o MiniChatbot, seu assistente virtual!";
    }

    private String responderEstado() {
        return "Estou funcionando perfeitamente, obrigado!";
    }

    private String respostaPadrao() {
        return "Desculpe, não entendi sua pergunta. Pode reformular?";
    }
}
