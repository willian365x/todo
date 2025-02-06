import controller.TodoController;
import model.Todo;
import util.ConnectionFactory;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws SQLException {
        Todo todo = new Todo();
        todo.setNome("Trabalho");
        todo.setDescricao("Construir uma planilha");

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse("25/03/2025", dateFormatter);

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.parse("16:00:00", timeFormatter);

        todo.setData(Date.valueOf(localDate));
        todo.setHora(Time.valueOf(localTime));
        todo.setIsok(false);

        TodoController todoController = new TodoController();

        try {
            //todoController.add(todo);
            //System.out.println("ToDo registrado com sucesso!");
            for(Todo objTodo : todoController.getList()){
                System.out.println("ID: " + objTodo.getId());
                System.out.println("Nome: " + objTodo.getNome());
                System.out.println("Descrição: " + objTodo.getDescricao());
                System.out.println("Data: " + objTodo.getData());
                System.out.println("Hora: " + objTodo.getHora());
                System.out.println("Concluída: " + objTodo.isIsok());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
