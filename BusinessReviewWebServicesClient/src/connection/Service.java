/**
 * Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package connection;

public interface Service extends java.rmi.Remote {
    public java.lang.String logout(java.lang.String email, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String[] login(java.lang.String email, java.lang.String password) throws java.rmi.RemoteException;
    public connection.Categories[] getCategories() throws java.rmi.RemoteException;
    public connection.ElementSuggest[] getSuggestion(java.lang.String suggestionValue) throws java.rmi.RemoteException;
    public java.lang.String editReview(java.lang.String email, java.lang.String password, java.lang.String edit, java.lang.String rate, java.lang.String id_No) throws java.rmi.RemoteException;
    public java.lang.String deleteReview(java.lang.String email, java.lang.String password, java.lang.String id_NoDel, java.lang.String elementNameDel, java.lang.String categoryDel) throws java.rmi.RemoteException;
    public connection.Review[] getReviews(java.lang.String email, java.lang.String password, java.lang.String categoryType) throws java.rmi.RemoteException;
    public java.lang.String signUp(java.lang.String fname, java.lang.String lname, java.lang.String email, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String postReview(java.lang.String email, java.lang.String password, java.lang.String category, java.lang.String element, java.lang.String review, java.lang.String rating, java.lang.String perform, java.lang.String description) throws java.rmi.RemoteException;
}
