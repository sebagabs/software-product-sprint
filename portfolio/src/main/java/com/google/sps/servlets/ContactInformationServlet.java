package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
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
    String contactReason = "";

    System.out.print("Contact reason: ");
    if (academicContact) System.out.print("academic; ");
    if (professionalContact) System.out.print("professional; ");
    if (otherContact) System.out.println("other; " + "Reason: " + otherContactReason);

    // Datastore
    long timestamp = System.currentTimeMillis();
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Contact");
    FullEntity contactEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("fname", firstName)
            .set("lname", lastName)
            .set("email", email)
            .set("reason", contactReason)
            .set("other reason", otherContactReason)
            .set("timestamp", timestamp)
            .build();
    datastore.put(contactEntity);

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