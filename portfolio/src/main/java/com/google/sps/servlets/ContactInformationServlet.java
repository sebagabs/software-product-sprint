package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contact-information")
public class ContactInformationServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get first name entered in the form.
    String firstName = getParameter(request, "fname", "");
    
    // Get last name entered in the form.
    String lastName = getParameter(request, "lname", "");
    
    // Get the name entered in the form.
    String email = getParameter(request, "email", "");

    // Reason of contacting
    boolean academicContact = Boolean.parseBoolean(getParameter(request, "academic-contact", "false"));
    boolean professionalContact = Boolean.parseBoolean(getParameter(request, "professional-contact", "false"));
    boolean otherContact = Boolean.parseBoolean(getParameter(request, "other-contact", "false"));
    String otherContactReason = getParameter(request, "other-contact-reason", "");

    System.out.println("New contact: " + firstName + " " + lastName + ", " + email);
    if (academicContact) System.out.println("Contact reason: academic");
    if (professionalContact) System.out.println("Contact reason: professional");
    if (otherContact) System.out.println("Contact reason: other. " + "Reason: " + otherContactReason);
    response.sendRedirect("https://smaldonado-sps-spring21.appspot.com");
    }

   /**
   * @return the request parameter, or the default value if the parameter
   *         was not specified by the client
   */
  private String getParameter(HttpServletRequest request, String name, String defaultValue) {
    String value = request.getParameter(name);
    if (value == null) {
      return defaultValue;
    }
    return value;
  }

}