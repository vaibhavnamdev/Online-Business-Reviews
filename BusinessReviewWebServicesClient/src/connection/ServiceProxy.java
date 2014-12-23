package connection;

public class ServiceProxy implements connection.Service {
  private String _endpoint = null;
  private connection.Service service = null;
  
  public ServiceProxy() {
    _initServiceProxy();
  }
  
  public ServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceProxy();
  }
  
  private void _initServiceProxy() {
    try {
      service = (new connection.ServiceServiceLocator()).getService();
      if (service != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)service)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (service != null)
      ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public connection.Service getService() {
    if (service == null)
      _initServiceProxy();
    return service;
  }
  
  public java.lang.String logout(java.lang.String email, java.lang.String password) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.logout(email, password);
  }
  
  public java.lang.String[] login(java.lang.String email, java.lang.String password) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.login(email, password);
  }
  
  public connection.Categories[] getCategories() throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getCategories();
  }
  
  public connection.ElementSuggest[] getSuggestion(java.lang.String suggestionValue) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getSuggestion(suggestionValue);
  }
  
  public java.lang.String editReview(java.lang.String email, java.lang.String password, java.lang.String edit, java.lang.String rate, java.lang.String id_No) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.editReview(email, password, edit, rate, id_No);
  }
  
  public java.lang.String deleteReview(java.lang.String email, java.lang.String password, java.lang.String id_NoDel, java.lang.String elementNameDel, java.lang.String categoryDel) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.deleteReview(email, password, id_NoDel, elementNameDel, categoryDel);
  }
  
  public connection.Review[] getReviews(java.lang.String email, java.lang.String password, java.lang.String categoryType) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.getReviews(email, password, categoryType);
  }
  
  public java.lang.String signUp(java.lang.String fname, java.lang.String lname, java.lang.String email, java.lang.String password) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.signUp(fname, lname, email, password);
  }
  
  public java.lang.String postReview(java.lang.String email, java.lang.String password, java.lang.String category, java.lang.String element, java.lang.String review, java.lang.String rating, java.lang.String perform, java.lang.String description) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.postReview(email, password, category, element, review, rating, perform, description);
  }
  
  
}