package registration.repository;

import registration.repository.entity.StudentEntity;
import registration.repository.entity.TeacherEntity;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeacherRepository {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/education";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "MyNewPass123!";


    public TeacherEntity register(TeacherEntity teacher) {
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO teacher(name, surname, " +
                    "age, email, salary) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setString(2, teacher.getSurname());
            preparedStatement.setInt(3, teacher.getAge());
            preparedStatement.setString(4, teacher.getEmail());
            preparedStatement.setBigDecimal(5, teacher.getSalary());

            preparedStatement.executeUpdate();

            try(ResultSet generatedKey = preparedStatement.getGeneratedKeys()) {
                if(generatedKey.next()) {
                    teacher.setId(generatedKey.getInt(1));
                }
            }
            return teacher;

        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<TeacherEntity> getAll() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from teacher");

            List<TeacherEntity> list = new ArrayList<>();
            while (resultSet.next()) {
                TeacherEntity teacher = toTeacherEntity(resultSet);

                list.add(teacher);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    public void deleteByID(int id) {
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from teacher where id =?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TeacherEntity findByID(int id) {
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from teacher where id =?");
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();
            if(result.next()) {
                return toTeacherEntity(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(TeacherEntity teacher) {
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            TeacherEntity found = findByID(teacher.getId());
            if(teacher.getName() != null && !teacher.getName().isBlank()) {
                found.setName(teacher.getName());
            }
            if(teacher.getSurname() !=null && !teacher.getSurname().isBlank()) {
                found.setSurname(teacher.getSurname());
            }
            if(teacher.getEmail()!=null && !teacher.getEmail().isBlank()) {
                found.setEmail(teacher.getEmail());
            }
            if(teacher.getAge()!=null) {
                found.setAge(teacher.getAge());
            }
            if(teacher.getUni_id()!=null) {
                found.setUni_id(teacher.getUni_id());
            }
            if(teacher.getSalary()!=null) {
                found.setSalary(teacher.getSalary());
            }

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE teacher set name=?, surname=?, age=?, email=?, salary=?, uni_id=? where id=?");
            preparedStatement.setString(1, found.getName());
            preparedStatement.setString(2, found.getSurname());
            preparedStatement.setInt(3, found.getAge());
            preparedStatement.setString(4, found.getEmail());
            preparedStatement.setBigDecimal(5, found.getSalary());
            preparedStatement.setInt(6, found.getUni_id());
            preparedStatement.setInt(7, found.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TeacherEntity> findBy(String name, String surname, String email) {
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "select * from teacher where 1+1 ";

            int index =0;
            if(name!=null && !name.isBlank()) {
                query+="and name like ?";
                index++;
            }
            if(surname!=null && !surname.isBlank()) {
                query+= "and surname like ?";
                index++;
            }
            if(email!=null && !email.isBlank()) {
                query+= "and email like ?";
                index++;
            }

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if(email!=null && !email.isBlank()) {
                preparedStatement.setString(index--, "%"+email+"%");
            }
            if(surname!=null && !surname.isBlank()) {
                preparedStatement.setString(index--, "%"+surname+"%");
            }
            if(name!=null && !name.isBlank()) {
                preparedStatement.setString(index, "%"+name+"%");

            }

            ResultSet resultSet = preparedStatement.executeQuery();

            List<TeacherEntity> teachers = new ArrayList<>();
            while (resultSet.next()) {
                teachers.add(toTeacherEntity(resultSet));
            }
            return teachers;


        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public TeacherEntity addStudentsToTeacher(TeacherEntity teacher, StudentEntity student) {
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student_teacher(" +
                    "student_id, teacher_id) " +
                    "VALUES (?, ?)");

            preparedStatement.setInt(1, student.getId());
            preparedStatement.setInt(2, teacher.getId());

            preparedStatement.executeUpdate();

            return teacher;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static TeacherEntity toTeacherEntity (ResultSet result) throws SQLException {
        Integer teacher_id = result.getInt("id");
        String name = result.getString("name");
        String surname = result.getString("surname");
        Integer age = result.getInt("age");
        String email = result.getString("email");
        Integer uni_id = result.getInt("uni_id");
        BigDecimal salary = result.getBigDecimal("salary");

        return new TeacherEntity(teacher_id, name, surname, age, email, salary, uni_id);
    }
}

