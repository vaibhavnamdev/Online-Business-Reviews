<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleServiceProxyid" scope="session" class="connection.ServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        connection.Service getService10mtemp = sampleServiceProxyid.getService();
if(getService10mtemp == null){
%>
<%=getService10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        String email_1id=  request.getParameter("email18");
            java.lang.String email_1idTemp = null;
        if(!email_1id.equals("")){
         email_1idTemp  = email_1id;
        }
        String password_2id=  request.getParameter("password20");
            java.lang.String password_2idTemp = null;
        if(!password_2id.equals("")){
         password_2idTemp  = password_2id;
        }
        java.lang.String logout15mtemp = sampleServiceProxyid.logout(email_1idTemp,password_2idTemp);
if(logout15mtemp == null){
%>
<%=logout15mtemp %>
<%
}else{
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(logout15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
}
break;
case 22:
        gotMethod = true;
        String email_3id=  request.getParameter("email25");
            java.lang.String email_3idTemp = null;
        if(!email_3id.equals("")){
         email_3idTemp  = email_3id;
        }
        String password_4id=  request.getParameter("password27");
            java.lang.String password_4idTemp = null;
        if(!password_4id.equals("")){
         password_4idTemp  = password_4id;
        }
        java.lang.String[] login22mtemp = sampleServiceProxyid.login(email_3idTemp,password_4idTemp);
if(login22mtemp == null){
%>
<%=login22mtemp %>
<%
}else{
        String tempreturnp23 = null;
        if(login22mtemp != null){
        java.util.List listreturnp23= java.util.Arrays.asList(login22mtemp);
        tempreturnp23 = listreturnp23.toString();
        }
        %>
        <%=tempreturnp23%>
        <%
}
break;
case 29:
        gotMethod = true;
        connection.Categories[] getCategories29mtemp = sampleServiceProxyid.getCategories();
if(getCategories29mtemp == null){
%>
<%=getCategories29mtemp %>
<%
}else{
        String tempreturnp30 = null;
        if(getCategories29mtemp != null){
        java.util.List listreturnp30= java.util.Arrays.asList(getCategories29mtemp);
        tempreturnp30 = listreturnp30.toString();
        }
        %>
        <%=tempreturnp30%>
        <%
}
break;
case 32:
        gotMethod = true;
        String suggestionValue_5id=  request.getParameter("suggestionValue35");
            java.lang.String suggestionValue_5idTemp = null;
        if(!suggestionValue_5id.equals("")){
         suggestionValue_5idTemp  = suggestionValue_5id;
        }
        connection.ElementSuggest[] getSuggestion32mtemp = sampleServiceProxyid.getSuggestion(suggestionValue_5idTemp);
if(getSuggestion32mtemp == null){
%>
<%=getSuggestion32mtemp %>
<%
}else{
        String tempreturnp33 = null;
        if(getSuggestion32mtemp != null){
        java.util.List listreturnp33= java.util.Arrays.asList(getSuggestion32mtemp);
        tempreturnp33 = listreturnp33.toString();
        }
        %>
        <%=tempreturnp33%>
        <%
}
break;
case 37:
        gotMethod = true;
        String email_6id=  request.getParameter("email40");
            java.lang.String email_6idTemp = null;
        if(!email_6id.equals("")){
         email_6idTemp  = email_6id;
        }
        String password_7id=  request.getParameter("password42");
            java.lang.String password_7idTemp = null;
        if(!password_7id.equals("")){
         password_7idTemp  = password_7id;
        }
        String edit_8id=  request.getParameter("edit44");
            java.lang.String edit_8idTemp = null;
        if(!edit_8id.equals("")){
         edit_8idTemp  = edit_8id;
        }
        String rate_9id=  request.getParameter("rate46");
            java.lang.String rate_9idTemp = null;
        if(!rate_9id.equals("")){
         rate_9idTemp  = rate_9id;
        }
        String id_No_10id=  request.getParameter("id_No48");
            java.lang.String id_No_10idTemp = null;
        if(!id_No_10id.equals("")){
         id_No_10idTemp  = id_No_10id;
        }
        java.lang.String editReview37mtemp = sampleServiceProxyid.editReview(email_6idTemp,password_7idTemp,edit_8idTemp,rate_9idTemp,id_No_10idTemp);
if(editReview37mtemp == null){
%>
<%=editReview37mtemp %>
<%
}else{
        String tempResultreturnp38 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(editReview37mtemp));
        %>
        <%= tempResultreturnp38 %>
        <%
}
break;
case 50:
        gotMethod = true;
        String email_11id=  request.getParameter("email53");
            java.lang.String email_11idTemp = null;
        if(!email_11id.equals("")){
         email_11idTemp  = email_11id;
        }
        String password_12id=  request.getParameter("password55");
            java.lang.String password_12idTemp = null;
        if(!password_12id.equals("")){
         password_12idTemp  = password_12id;
        }
        String id_NoDel_13id=  request.getParameter("id_NoDel57");
            java.lang.String id_NoDel_13idTemp = null;
        if(!id_NoDel_13id.equals("")){
         id_NoDel_13idTemp  = id_NoDel_13id;
        }
        String elementNameDel_14id=  request.getParameter("elementNameDel59");
            java.lang.String elementNameDel_14idTemp = null;
        if(!elementNameDel_14id.equals("")){
         elementNameDel_14idTemp  = elementNameDel_14id;
        }
        String categoryDel_15id=  request.getParameter("categoryDel61");
            java.lang.String categoryDel_15idTemp = null;
        if(!categoryDel_15id.equals("")){
         categoryDel_15idTemp  = categoryDel_15id;
        }
        java.lang.String deleteReview50mtemp = sampleServiceProxyid.deleteReview(email_11idTemp,password_12idTemp,id_NoDel_13idTemp,elementNameDel_14idTemp,categoryDel_15idTemp);
if(deleteReview50mtemp == null){
%>
<%=deleteReview50mtemp %>
<%
}else{
        String tempResultreturnp51 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteReview50mtemp));
        %>
        <%= tempResultreturnp51 %>
        <%
}
break;
case 63:
        gotMethod = true;
        String email_16id=  request.getParameter("email66");
            java.lang.String email_16idTemp = null;
        if(!email_16id.equals("")){
         email_16idTemp  = email_16id;
        }
        String password_17id=  request.getParameter("password68");
            java.lang.String password_17idTemp = null;
        if(!password_17id.equals("")){
         password_17idTemp  = password_17id;
        }
        String categoryType_18id=  request.getParameter("categoryType70");
            java.lang.String categoryType_18idTemp = null;
        if(!categoryType_18id.equals("")){
         categoryType_18idTemp  = categoryType_18id;
        }
        connection.Review[] getReviews63mtemp = sampleServiceProxyid.getReviews(email_16idTemp,password_17idTemp,categoryType_18idTemp);
if(getReviews63mtemp == null){
%>
<%=getReviews63mtemp %>
<%
}else{
        String tempreturnp64 = null;
        if(getReviews63mtemp != null){
        java.util.List listreturnp64= java.util.Arrays.asList(getReviews63mtemp);
        tempreturnp64 = listreturnp64.toString();
        }
        %>
        <%=tempreturnp64%>
        <%
}
break;
case 72:
        gotMethod = true;
        String fname_19id=  request.getParameter("fname75");
            java.lang.String fname_19idTemp = null;
        if(!fname_19id.equals("")){
         fname_19idTemp  = fname_19id;
        }
        String lname_20id=  request.getParameter("lname77");
            java.lang.String lname_20idTemp = null;
        if(!lname_20id.equals("")){
         lname_20idTemp  = lname_20id;
        }
        String email_21id=  request.getParameter("email79");
            java.lang.String email_21idTemp = null;
        if(!email_21id.equals("")){
         email_21idTemp  = email_21id;
        }
        String password_22id=  request.getParameter("password81");
            java.lang.String password_22idTemp = null;
        if(!password_22id.equals("")){
         password_22idTemp  = password_22id;
        }
        java.lang.String signUp72mtemp = sampleServiceProxyid.signUp(fname_19idTemp,lname_20idTemp,email_21idTemp,password_22idTemp);
if(signUp72mtemp == null){
%>
<%=signUp72mtemp %>
<%
}else{
        String tempResultreturnp73 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(signUp72mtemp));
        %>
        <%= tempResultreturnp73 %>
        <%
}
break;
case 83:
        gotMethod = true;
        String email_23id=  request.getParameter("email86");
            java.lang.String email_23idTemp = null;
        if(!email_23id.equals("")){
         email_23idTemp  = email_23id;
        }
        String password_24id=  request.getParameter("password88");
            java.lang.String password_24idTemp = null;
        if(!password_24id.equals("")){
         password_24idTemp  = password_24id;
        }
        String category_25id=  request.getParameter("category90");
            java.lang.String category_25idTemp = null;
        if(!category_25id.equals("")){
         category_25idTemp  = category_25id;
        }
        String element_26id=  request.getParameter("element92");
            java.lang.String element_26idTemp = null;
        if(!element_26id.equals("")){
         element_26idTemp  = element_26id;
        }
        String review_27id=  request.getParameter("review94");
            java.lang.String review_27idTemp = null;
        if(!review_27id.equals("")){
         review_27idTemp  = review_27id;
        }
        String rating_28id=  request.getParameter("rating96");
            java.lang.String rating_28idTemp = null;
        if(!rating_28id.equals("")){
         rating_28idTemp  = rating_28id;
        }
        String perform_29id=  request.getParameter("perform98");
            java.lang.String perform_29idTemp = null;
        if(!perform_29id.equals("")){
         perform_29idTemp  = perform_29id;
        }
        String description_30id=  request.getParameter("description100");
            java.lang.String description_30idTemp = null;
        if(!description_30id.equals("")){
         description_30idTemp  = description_30id;
        }
        java.lang.String postReview83mtemp = sampleServiceProxyid.postReview(email_23idTemp,password_24idTemp,category_25idTemp,element_26idTemp,review_27idTemp,rating_28idTemp,perform_29idTemp,description_30idTemp);
if(postReview83mtemp == null){
%>
<%=postReview83mtemp %>
<%
}else{
        String tempResultreturnp84 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(postReview83mtemp));
        %>
        <%= tempResultreturnp84 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>