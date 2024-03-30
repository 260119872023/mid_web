package Controller;

import DAO.StudentCOurseDao;
import DAO.StudentDao;
import DAO.courseDao;
import DAO.studentRegDAO;
import Model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@WebServlet("/RegistrationServelet")
public class RegistrationServelet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date_start = request.getParameter("date");
        String student = request.getParameter("student");
        String sem = request.getParameter("semester");
        String academic = request.getParameter("academic");

        Student stud = new Student();
        stud.setRegNo(student);

        Semester sems = new Semester();
        sems.setSem_Id(Integer.valueOf(sem));

        AcademicUnit academicUnit = new AcademicUnit();
        academicUnit.setId(Integer.valueOf(academic));

        Date start_date = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            start_date = (Date) dateFormat.parse(date_start);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        StudentDao studentDao = new StudentDao();
        String stud_id = String.valueOf(studentDao.getStudentByRegNo(student));

        if(stud_id!= null)
        {


            Course course = new Course();
            course.setAcademicUnit(academicUnit);
            course.setSemester_Course(sems);
            courseDao courseDaos = new courseDao();
            List<Course> courseList = courseDaos.getdepartmentandSemester(course);
            if(courseList !=null)
            {
//                Student studentset =new Student();
//                studentset.setRegNo(stud_id);
                StudentReg reg = new StudentReg();
                reg.setSemester(sems);
                reg.setRegistration_date(start_date);
                reg.setStudent_Id(stud);
                reg.setStudent_registration(academicUnit);

                studentRegDAO res = new studentRegDAO();
                String result = String.valueOf(res.save(reg));

                for (Course course1 : courseList)
                {
                    Course course2 = new Course();
                    course2.setCourse_id(course1.getCourse_id());
                    StudentCourse studentCourse = new StudentCourse();
                    studentCourse.setCredits(course1.getCredit());
                    studentCourse.setResult("");
                    studentCourse.setCourseSet(course2);
                    studentCourse.setStudent_reg(stud);
                    studentCourse.setSemester(sems);
                    StudentCOurseDao dao = new StudentCOurseDao();
                    dao.registerStudent(studentCourse);
                }
                if (result !=null)
                {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Login.html");
                    dispatcher.forward(request, response);
                }
                else
                {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("signup.html");
                    dispatcher.forward(request, response);
                }
            }


        }
    }
}
