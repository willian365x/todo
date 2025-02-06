import controller.TodoController;
import model.Todo;
import util.ConnectionFactory;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static TodoController todoController = new TodoController();

    public static void viewTodos() {
        for (Todo objTodo : todoController.getList()) {
            System.out.println("\nID: " + objTodo.getId());
            System.out.println("Nome: " + objTodo.getNome());
            System.out.println("Descrição: " + objTodo.getDescricao());
            System.out.println("Data: " + objTodo.getData());
            System.out.println("Hora: " + objTodo.getHora());
            System.out.println("Concluída: " + objTodo.isIsok());
            System.out.println("-------------------------------------------");
        }
    }

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite as informações do ToDo logo abaixo:");
        System.out.println("Deseja continuar...? (Y/n)");

        String opcao = scanner.nextLine();

        if (!Objects.equals(opcao, "n")) {

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Descrição: ");
            String descricao = scanner.nextLine();

            System.out.print("Data (ex: 01/01/1900): ");
            String data = scanner.nextLine();

            System.out.print("Hora (ex: 12:00:00): ");
            String hora = scanner.nextLine();

            Todo todo = new Todo();
            todo.setNome(nome);
            todo.setDescricao(descricao);

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(data, dateFormatter);

            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime localTime = LocalTime.parse(hora, timeFormatter);

            todo.setData(Date.valueOf(localDate));
            todo.setHora(Time.valueOf(localTime));
            todo.setIsok(false);


            try {
                todoController.add(todo);
                System.out.println("ToDo registrado com sucesso!");
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                viewTodos();
            }
        } else {
            viewTodos();
        }
    }
}
