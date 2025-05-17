package registration.repository;

import registration.repository.entity.StudentEntity;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRepository {

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/education";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "MyNewPass123!";


    public StudentEntity register(StudentEntity student) {
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student(name, surname, " +
                    "age, email, scholarship) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setBigDecimal(5, student.getScholarship());

            preparedStatement.executeUpdate();

            try(ResultSet generatedKey = preparedStatement.getGeneratedKeys()) {
                if(generatedKey.next()) {
                    student.setId(generatedKey.getInt("id"));
                }
            }
            return student;

        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<StudentEntity> getAll() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");

            List<StudentEntity> list = new ArrayList<>();
            while (resultSet.next()) {
                StudentEntity student = toStudentEntity(resultSet);

                list.add(student);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public StudentEntity findByID(int id) {
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student where id =?");
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();
            if(result.next()) {
                return toStudentEntity(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteByID(int id) {
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where id =?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void update(StudentEntity student) {
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            StudentEntity found = findByID(student.getId());
            if(student.getName() != null && !student.getName().isBlank()) {
                found.setName(student.getName());
            }
            if(student.getSurname() !=null && !student.getSurname().isBlank()) {
                found.setSurname(student.getSurname());
            }
            if(student.getEmail()!=null && !student.getEmail().isBlank()) {
                found.setEmail(student.getEmail());
            }
            if(student.getAge()!=null) {
                found.setAge(student.getAge());
            }
            if(student.getUni_id()!=null) {
                found.setUni_id(student.getUni_id());
            }
            if(student.getScholarship()!=null) {
                found.setScholarship(student.getScholarship());
            }

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE student set name=?, surname=?, age=?, email=?, scholarship=?, uni_id=? where id=?");
            preparedStatement.setString(1, found.getName());
            preparedStatement.setString(2, found.getSurname());
            preparedStatement.setInt(3, found.getAge());
            preparedStatement.setString(4, found.getEmail());
            preparedStatement.setBigDecimal(5, found.getScholarship());
            preparedStatement.setInt(6, found.getUni_id());
            preparedStatement.setInt(7, found.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<StudentEntity> findBy(String name, String surname, String email) {
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "select * from student where 1=1 ";

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

            List<StudentEntity> students = new ArrayList<>();
            while (resultSet.next()) {
                students.add(toStudentEntity(resultSet));
            }
            return students;


        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

    }

    private static StudentEntity toStudentEntity (ResultSet result) throws SQLException {
        Integer student_id = result.getInt("id");
        String name = result.getString("name");
        String surname = result.getString("surname");
        Integer age = result.getInt("age");
        String email = result.getString("email");
        Integer uni_id = result.getInt("uni_id");
        BigDecimal scholarship = result.getBigDecimal("scholarship");

        return new StudentEntity(student_id, name, surname, age, email, scholarship, uni_id);
    }
}
