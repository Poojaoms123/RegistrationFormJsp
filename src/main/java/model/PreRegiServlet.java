package model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegiServlet")
public class PreRegiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");
        String currentlyUndergoingTraining = request.getParameter("currentlyUndergoingTraining");
        String whichTrainingProgram = request.getParameter("whichTrainingProgram");
        String other = request.getParameter("other");
        String whichDateAndBatch = request.getParameter("whichDateAndBatch");
        String pleaseProveThatYouAreHumanBySolvingTheEquation = request.getParameter("pleaseProveThatYouAreHumanBySolvingTheEquation");

        // Print statements for debugging
        System.out.println("fullName: " + fullName);
        System.out.println("age: " + age);
        System.out.println("gender: " + gender);
        System.out.println("phoneNo: " + phoneNo);
        System.out.println("email: " + email);
        System.out.println("currentlyUndergoingTraining: " + currentlyUndergoingTraining);
        System.out.println("whichTrainingProgram: " + whichTrainingProgram);
        System.out.println("whichDateAndBatch: " + whichDateAndBatch);
        System.out.println("other: " + other);
        System.out.println("pleaseProveThatYouAreHumanBySolvingTheEquation: " + pleaseProveThatYouAreHumanBySolvingTheEquation);

        PreRegi preRegi = new PreRegi(fullName, age, gender, phoneNo, email, currentlyUndergoingTraining, whichTrainingProgram, other, whichDateAndBatch, pleaseProveThatYouAreHumanBySolvingTheEquation);

        PreRegiDAO preRegiDAO = new PreRegiDAO();
        boolean result = preRegiDAO.saveRegi(preRegi);

        if (result) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}