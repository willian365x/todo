package controller;

import model.Todo;
import util.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoController {
    private ConnectionFactory factory;
    private PreparedStatement preparedStatement;

    public TodoController(){
        this.factory = new ConnectionFactory();
    }

    public void add(Todo objTodo){
        String sql = "insert into todo(nome,descricao,dt,hr,isok) values(?,?,?,?,?)";
        try {
            this.preparedStatement = factory.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,objTodo.getNome());
            preparedStatement.setString(2,objTodo.getDescricao());
            preparedStatement.setDate(3,objTodo.getData());
            preparedStatement.setTime(4,objTodo.getHora());
            preparedStatement.setBoolean(5,objTodo.isIsok());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Todo> getList(){
        String sql = "select * from public.todo";
        List<Todo> listTodos = new ArrayList<>();
        try{
            this.preparedStatement = factory.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setNome(rs.getString("nome"));
                todo.setDescricao(rs.getString("descricao"));
                todo.setData(rs.getDate("dt"));
                todo.setHora(rs.getTime("hr"));
                todo.setIsok(false);

                listTodos.add(todo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listTodos;
    }
}
