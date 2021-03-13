package com.google.sps.servlets;

/** Contact information. */
public final class Contact {

  private final String firstName, lastName, email, reason, otherReason;
  private final long timestamp;

  public Contact(String firstName, String lastName, String email, String reason, String otherReason, long timestamp) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.reason = reason;
    this.otherReason = otherReason;
    this.timestamp = timestamp;
  }
}